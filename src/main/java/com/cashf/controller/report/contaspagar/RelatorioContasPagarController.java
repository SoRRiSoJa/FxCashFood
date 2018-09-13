/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.contaspagar;

import com.cashf.dao.contaspagar.ContaPagarDAO;
import com.cashf.model.contasPagar.ContaPagar;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author joao
 */
public class RelatorioContasPagarController {

    private final ContaPagarDAO contasPagarDAO;
    private ObservableList<ContaPagar> lista;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String reportFilePath;

    public RelatorioContasPagarController() {
        this.contasPagarDAO = new ContaPagarDAO(ContaPagar.class);
        this.lista = FXCollections.observableList(contasPagarDAO.listAll());
        this.dataInicio = this.dataFim = LocalDate.now();
        
        // /home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/ContasPagarPeriodoReport.jrxml
        reportFilePath = "/home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/ContasPagarPeriodoReport.jrxml";

    }

    public ObservableList<ContaPagar> getLista() {
        return lista;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public void gerarDados() {
        this.lista = FXCollections.observableList(contasPagarDAO.listByPeriodo(dataInicio, dataFim));
    }

    public void testarRelatorio() {
        try {
            // First, compile jrxml file.
            JasperReport jasperReport = JasperCompileManager.compileReport(reportFilePath);
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(lista);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, beanColDataSource);
            JRViewer viewer = new JRViewer(print);
            viewer.setOpaque(true);
            viewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(RelatorioContasPagarController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
