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
public class NMesaController implements GenericController<Mesa> {

    private Mesa mesaAtual;
    private ObservableList<Mesa> lista;
    private ObservableList<Cliente> listaCli;
    private final MesaDAO mesaDAO;
    private final ClienteDAO clienteDAO;
    private int tipoConsulta;
    public static NMesaController nMesaController = null;

    private NMesaController() {
        this.mesaDAO = new MesaDAO(Mesa.class);
        this.clienteDAO = new ClienteDAO(Cliente.class);
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.listaCli = FXCollections.observableList(clienteDAO.listAll());
        this.mesaAtual = new Mesa();
        this.mesaAtual.setIdMesa(0l);
    }

    public static synchronized NMesaController getInstance() {
        if (nMesaController == null) {
            nMesaController = new NMesaController();
        }
        return nMesaController;
    }

    public Mesa getMesaByNum(int num) {
        for (Mesa me : lista) {
            if (me.getNumMesa() == num) {
                return me;
            }
        }
        return null;
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

    public void abrirMesa(int nPax) {
        mesaAtual.setNumPax(nPax);
        mesaAtual.setHoraAbertura(LocalTime.now());
        mesaAtual.setStatus(StatusMesa.ABERTA);
        insert();
        VendaController.getInstance().getVenda().setMesa(mesaAtual);
        VendaController.getInstance().getLista().add(VendaController.getInstance().getVenda());
    }
     public void fecharMesa() {
        VendaController.getInstance().getVenda().getMesa().setHoraFechamento(LocalTime.now());
        VendaController.getInstance().getVenda().getMesa().setStatus(StatusMesa.FECHADA);
        mesaDAO.update(VendaController.getInstance().getVenda().getMesa());
        VendaController.getInstance().fecharVenda();
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
    }

    @Override
    public ObservableList<Mesa> getLista() {
        return lista;
    }

    @Override
    public void setLista(ObservableList<Mesa> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setItenLista(Mesa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
