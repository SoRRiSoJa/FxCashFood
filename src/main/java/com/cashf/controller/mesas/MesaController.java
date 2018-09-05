/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.core.venda.VendaController;
import com.cashf.dao.cliente.ClienteDAO;
import com.cashf.dao.mesa.MesaDAO;
import com.cashf.model.cliente.Cliente;
import com.cashf.model.mesa.Mesa;
import com.cashf.model.mesa.StatusMesa;
import com.cashf.model.produto.Produto;
import com.cashf.model.venda.ProdutoVenda;
import com.cashf.model.venda.Venda;
import controller.GenericController;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.PoupUpUtil;

/**
 *
 * @author joao
 */
public class MesaController implements GenericController<Mesa> {

    private static MesaController mesaController = null;
    private Mesa mesaAtual;
    private Cliente cliente;
    private ObservableList<Mesa> lista;
    private ObservableList<Cliente> listaCli;
    private final MesaDAO mesaDAO;
    private final ClienteDAO clienteDAO;
    private Produto produtoSelecionado;
    private int tipoConsulta;

    private MesaController() {
        this.mesaDAO = new MesaDAO(Mesa.class);
        this.clienteDAO = new ClienteDAO(Cliente.class);
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.listaCli = FXCollections.observableList(clienteDAO.listAll());
        this.mesaAtual = new Mesa();
        this.mesaAtual.setIdMesa(0l);
        this.produtoSelecionado = new Produto();
        this.produtoSelecionado.setIdProduto(0l);
        gerarMesas();

    }

    public static synchronized MesaController getInstance() {
        if (mesaController == null) {
            mesaController = new MesaController();
        }
        return mesaController;
    }

    public Mesa getMesaAtual() {
        return mesaAtual;
    }

    public void setMesaAtual(Mesa mesaAtual) {
        this.mesaAtual = mesaAtual;
    }

    public ObservableList<Mesa> getLista() {
        return lista;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Mesa getMesaNum(int num) {
        for (Mesa me : lista) {
            if (me.getNumMesa() == num) {
                return me;
            }
        }
        return null;
    }

    public void setLista(ObservableList<Mesa> lista) {
        this.lista = lista;
    }

    public void setMesaAtual(long idMesa, Integer numPax, int numMesa, LocalDate dataAbertura, LocalTime horaAbertura, LocalTime horaFechamento, StatusMesa status) {
        this.mesaAtual.setIdMesa(idMesa);
        this.mesaAtual.setNumMesa(numMesa);
        this.mesaAtual.setNumPax(numPax);
        this.mesaAtual.setDataAbertura(dataAbertura);
        this.mesaAtual.setHoraAbertura(horaAbertura);
        this.mesaAtual.setHoraFechamento(horaFechamento);
        this.mesaAtual.setStatus(status);
    }

    private void gerarMesas() {
        for (int i = 1; i < 19; i++) {
            this.lista.add(new Mesa(0, 0, i, LocalDate.now(), LocalTime.now(), null, StatusMesa.DISPONIVEL));
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ObservableList<Cliente> getListaCli() {
        return listaCli;
    }

    public void setListaCli(ObservableList<Cliente> listaCli) {
        this.listaCli = listaCli;
    }

    public void abrirMesa(int nPax) {
        mesaAtual.setNumPax(nPax);
        mesaAtual.setHoraAbertura(LocalTime.now());
        mesaAtual.setStatus(StatusMesa.ABERTA);
        insert();
        VendaController.getInstance().setNewVenda();
        VendaController.getInstance().getVenda().setMesa(mesaAtual);
        VendaController.getInstance().getVenda().setCliente(cliente);
        VendaController.getInstance().getLista().add(VendaController.getInstance().getVenda());
        VendaController.getInstance().setVenda(VendaController.getInstance().getVendaByMesa(mesaAtual));
    }

    public void fecharMesa() {
        VendaController.getInstance().setVenda(VendaController.getInstance().getVendaByMesa(mesaAtual));
        Mesa mesaAux = new Mesa(0, 0, VendaController.getInstance().getVenda().getMesa().getNumMesa(), LocalDate.now(), LocalTime.now(), null, StatusMesa.DISPONIVEL);
        VendaController.getInstance().getVenda().getMesa().setHoraFechamento(LocalTime.now());
        VendaController.getInstance().getVenda().getMesa().setStatus(StatusMesa.FECHADA);
        mesaDAO.update(VendaController.getInstance().getVenda().getMesa());
        VendaController.getInstance().fecharVenda();
        this.lista.remove(mesaAtual);
        this.mesaAtual = new Mesa();
        this.mesaAtual.setIdMesa(0l);
        this.lista.add(mesaAux);
    }

    @Override
    public void insert() {
        mesaAtual.setIdMesa(mesaDAO.save(mesaAtual));
    }

    @Override
    public void update() {
        mesaDAO.update(mesaAtual);
    }

    @Override
    public void delete() {
        mesaDAO.delete(mesaAtual);
    }

    @Override
    public void flushObject() {
        this.listaCli = FXCollections.observableList(clienteDAO.listAll());
        this.mesaAtual = new Mesa();
        this.mesaAtual.setIdMesa(0l);
        this.produtoSelecionado = new Produto();
        this.produtoSelecionado.setIdProduto(0l);
    }

    @Override
    public void setItenLista(Mesa obj) {

    }

    public boolean tranferirMesa(Mesa destino) {
        boolean flag = false;
        int index;
        if (destino.getStatus() != StatusMesa.ABERTA) {

            Venda vAux = VendaController.getInstance().getVendaByMesa(mesaAtual);
            VendaController.getInstance().getLista().remove(vAux);
            destino.setHoraAbertura(LocalTime.now());
            destino.setNumPax(mesaAtual.getNumPax());
            destino.setStatus(StatusMesa.ABERTA);
            vAux.setMesa(destino);
            vAux.getListaProdutos().forEach((pv) -> {
                pv.setVendaId(vAux);
            });
            VendaController.getInstance().getLista().add(vAux);
            VendaController.getInstance().setVenda(vAux);

            mesaAtual.setStatus(StatusMesa.FECHADA);
            setMesaAtual(destino);
            flag = true;
        }
        return flag;
    }

    public boolean tranferirItemMesa(Mesa destino, ProdutoVenda pv) {
        boolean flag = false;
        int index;
        if (destino.getStatus() != StatusMesa.ABERTA) {
            Venda vOrigen = VendaController.getInstance().getVendaByMesa(mesaAtual);
            Venda vDestino = VendaController.getInstance().getVendaByMesa(destino);
            vOrigen.getListaProdutos().remove(pv);
            vDestino.getListaProdutos().add(pv);
            flag = true;
        }
        return flag;
    }
}
