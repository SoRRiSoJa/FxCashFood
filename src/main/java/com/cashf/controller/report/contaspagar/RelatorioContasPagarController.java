/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.contaspagar;

import com.cashf.dao.contaspagar.ContaPagarDAO;
import com.cashf.model.contasPagar.ContaPagar;
import com.cashf.model.contasPagar.StatusPagto;
import java.math.BigDecimal;
import java.time.LocalDate;
import static java.util.Collections.list;
import java.util.Iterator;
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
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author joao
 */
public class RelatorioContasPagarController {

    private final ContaPagarDAO contasPagarDAO;
    private ObservableList<ContaPagar> lista;
    private StatusPagto statusPagto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private final String reportFilePath;

    public RelatorioContasPagarController() {
        this.contasPagarDAO = new ContaPagarDAO(ContaPagar.class);
        this.lista = FXCollections.observableList(contasPagarDAO.listAll());
        this.dataInicio = this.dataFim = LocalDate.now();

        // /home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/ContasPagarPeriodoReport.jrxml
        reportFilePath = "/home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/ContasPagarPeriodoReport.jasper";

    }

    public StatusPagto getStatusPagto() {
        return statusPagto;
    }

    public void setStatusPagto(StatusPagto statusPagto) {
        this.statusPagto = statusPagto;
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

    public BigDecimal totalPeriodo() {
        BigDecimal total = BigDecimal.ZERO;
        for (ContaPagar cp : lista) {
            total = total.add(cp.getValorBruto());
        }
        return total;
    }

    public void gerarDados() {
        this.lista = FXCollections.observableList(contasPagarDAO.listByPeriodoAndStatus(dataInicio, dataFim,statusPagto));
    }

    
    public void testaDois() {
        try {
            lista.forEach((cp) -> {
                System.out.println(cp.getDescricao() + "|" + cp.getFavorecido() + "|" + cp.getDataVencimento() + "|" + cp.getValorBruto());
            });
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(lista);
            String RelName = JasperFillManager.fillReportToFile(reportFilePath, null, beanColDataSource);
            JasperViewer viewer = new JasperViewer(RelName, false, false);
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            viewer.setTitle("CONTAS A PAGAR");
            viewer.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro-->>" + ex);
        }

    }

}
