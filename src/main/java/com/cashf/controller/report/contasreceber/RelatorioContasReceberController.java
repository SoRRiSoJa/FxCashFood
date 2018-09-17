/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.contasreceber;

import com.cashf.dao.contareceber.ContaReceberDAO;
import com.cashf.model.contareceber.ContaReceber;
import com.cashf.model.contasPagar.StatusPagto;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author joao
 */
public class RelatorioContasReceberController {
    private final ContaReceberDAO contaReceberDAO;
    private ObservableList<ContaReceber> lista;
    private StatusPagto statusPagto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private final String reportFilePath;

    public RelatorioContasReceberController() {
     this.contaReceberDAO = new ContaReceberDAO(ContaReceber.class);
     this.lista = FXCollections.observableList(new ArrayList<>());
      this.dataInicio = this.dataFim = LocalDate.now();
     this.reportFilePath="/home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/ContasReceberPeriodoReport.jasper";
    }

    public ObservableList<ContaReceber> getLista() {
        return lista;
    }

    public void setLista(ObservableList<ContaReceber> lista) {
        this.lista = lista;
    }

    public StatusPagto getStatusPagto() {
        return statusPagto;
    }

    public void setStatusPagto(StatusPagto statusPagto) {
        this.statusPagto = statusPagto;
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
        for (ContaReceber cr : lista) {
            total = total.add(cr.getValorBruto());
        }
        return total;
    }

    public void gerarDados() {
        this.lista = FXCollections.observableList(contaReceberDAO.listByPeriodo(dataInicio, dataFim,statusPagto));
    }

    
    public void gerarRelatorio() {
        try {
            lista.forEach((cr) -> {
                System.out.println(cr.getDescricao() + "|" + cr.getFavorecido() + "|" + cr.getDataVencimento() + "|" + cr.getValorBruto());
            });
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(lista);
            String RelName = JasperFillManager.fillReportToFile(reportFilePath, null, beanColDataSource);
            JasperViewer viewer = new JasperViewer(RelName, false, false);
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            viewer.setTitle("CONTAS A RECEBER");
            viewer.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro-->>" + ex);
        }

    }

}
