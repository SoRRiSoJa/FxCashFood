/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.fluxocaixa;

import com.cashf.dao.caixa.CaixaDAO;
import com.cashf.dao.caixamovimento.CaixaMovimentoDAO;
import com.cashf.model.caixa.Caixa;
import com.cashf.model.caixa.CaixaMovimento;
import java.time.LocalDate;
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
public class RelatorioFLuxoCaixaController {

    private final CaixaDAO caixaDAO;
    private final CaixaMovimentoDAO caixaMovimentoDAO;
    private ObservableList<Caixa> lista;
    private ObservableList<CaixaMovimento> listaMov;
    private Caixa caixa;
    private CaixaMovimento caixaMovimento;
    private LocalDate dataAbertura;
    private final String reportFilePath;

    public RelatorioFLuxoCaixaController() {
        this.caixaDAO = new CaixaDAO(Caixa.class);
        this.caixaMovimentoDAO = new CaixaMovimentoDAO(CaixaMovimento.class);
        this.lista = FXCollections.observableList(caixaDAO.listAll());
        this.dataAbertura=LocalDate.now();
        this.caixa=new Caixa();
        this.caixa.setIdCaixa(0l);
        this.reportFilePath="/home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/FluxoDeCaixa.jasper";
    }

    public ObservableList<Caixa> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Caixa> lista) {
        this.lista = lista;
    }

    public Caixa getCaixa() {
        return caixa;
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }
    public void loadCaixaList(){
        this.lista= FXCollections.observableList(caixaDAO.listByDate(dataAbertura));
        lista.forEach((cx)->{
            System.out.println("--->>>>"+cx.toString());
        });
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }
     public void gerarDados() {
        this.listaMov = FXCollections.observableList(caixaMovimentoDAO.listByDateAndCaixa(dataAbertura,caixa));
    }
    public void gerarRelatorio() {
        try {
            listaMov.forEach((cr) -> {
                System.out.println(cr.getDataMovimento() + "|" + cr.getObservacao() + "|" + cr.getTipoMovimento() + "|" + cr.getValor());
            });
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listaMov);
            String RelName = JasperFillManager.fillReportToFile(reportFilePath, null, beanColDataSource);
            JasperViewer viewer = new JasperViewer(RelName, false, false);
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            viewer.setTitle("FLUXO DE CAIXA");
            viewer.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro-->>" + ex);
        }

    }

}
