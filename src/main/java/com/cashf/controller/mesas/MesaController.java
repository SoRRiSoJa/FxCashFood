/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.mesas;

import com.cashf.controller.prepreparo.PrePreparoController;
import static com.cashf.controller.prepreparo.PrePreparoController.prePreparoController;
import com.cashf.dao.mesa.MesaDAO;
import com.cashf.model.mesa.Mesa;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class MesaController {

    private static MesaController mesaController = null;
    private Mesa mesaAtual;
    private ObservableList<Mesa> lista;
    private final MesaDAO mesaDAO;

    private MesaController() {
        this.mesaDAO = new MesaDAO(Mesa.class);
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.mesaAtual = new Mesa();
        this.mesaAtual.setIdMesa(0l);
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

    public void setLista(ObservableList<Mesa> lista) {
        this.lista = lista;
    }
    public void setMesaAtual(long idMesa, Integer numPax, int numMesa, LocalDate dataAbertura, LocalTime horaAbertura, LocalTime horaFechamento, int status) {
        this.mesaAtual.setIdMesa(idMesa);
        this.mesaAtual.setNumMesa(numMesa);
        this.mesaAtual.setNumPax(numPax);
        this.mesaAtual.setDataAbertura(dataAbertura);
        this.mesaAtual.setHoraAbertura(horaAbertura);
        this.mesaAtual.setHoraFechamento(horaFechamento);
        this.mesaAtual.setStatus(0);
    }

}
