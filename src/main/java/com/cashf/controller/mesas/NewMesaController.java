/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

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

/**
 *
 * @author joao
 */
public class NewMesaController implements GenericController<Mesa>{

    private static NewMesaController newMesaController = null;
    private Mesa mesaAtual;
    private ObservableList<Mesa> lista;
    private ObservableList<Cliente> listaCli;
    private final MesaDAO mesaDAO;
    private final ClienteDAO clienteDAO;
    private int tipoConsulta;

    private NewMesaController() {
        this.mesaDAO = new MesaDAO(Mesa.class);
        this.clienteDAO = new ClienteDAO(Cliente.class);
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.listaCli = FXCollections.observableList(clienteDAO.listAll());
        this.mesaAtual = new Mesa();
        this.mesaAtual.setIdMesa(0l);

    }

    public static synchronized NewMesaController getInstance() {
        if (newMesaController == null) {
            newMesaController = new NewMesaController();
        }
        return newMesaController;
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

    public void setLista(ObservableList<Mesa> lista) {
        this.lista = lista;
    }

    public ObservableList<Cliente> getListaCli() {
        return listaCli;
    }

    public void setListaCli(ObservableList<Cliente> listaCli) {
        this.listaCli = listaCli;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public Mesa getMesaNum(int num) {
        for (Mesa mesa : lista) {
            if (mesa.getNumMesa() == num) {
                return mesa;
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

    @Override
    public void insert() {
        mesaAtual.setIdMesa(mesaDAO.save(mesaAtual));mesaAtual.setIdMesa(mesaDAO.save(mesaAtual));
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
    public void setItenLista(Mesa obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
