/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.prepreparo;

import com.cashf.dao.prepreparo.PrePreparoDAO;
import com.cashf.dao.venda.VendaDAO;
import com.cashf.model.prepreparo.PrePreparo;
import com.cashf.model.prepreparo.ProdutoPrePreparo;
import com.cashf.model.venda.Venda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
public class RelatorioPrePreparoController {

    private final PrePreparoDAO prePreparoDAO;
    private final VendaDAO vendaDAO;
    private ObservableList<PrePreparo> lista;
    private ObservableList<ProdutoPrePreparo> listaProd;
    private PrePreparo prePreparo;
    private final String reportFilePath;
    private Map<String, Object> parameters;
    public RelatorioPrePreparoController() {
        this.vendaDAO=new VendaDAO(Venda.class);
        this.prePreparoDAO = new PrePreparoDAO(PrePreparo.class);
        this.lista = FXCollections.observableList(prePreparoDAO.listAll());
        this.prePreparo = new PrePreparo();
        this.prePreparo.setIdPrepreparo(0l);
        this.listaProd=FXCollections.observableList(new ArrayList<>());
        this.prePreparo.setListaProdutos(FXCollections.observableList(new ArrayList<>()));
        this.reportFilePath="/home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/RelPrePreparo.jasper";
        this.parameters= new HashMap<>();
        vendaDAO.rankingProdutos();
    }

    public ObservableList<PrePreparo> getLista() {
        return lista;
    }

    public void setLista(ObservableList<PrePreparo> lista) {
        this.lista = lista;
    }

    

    public PrePreparo getPrePreparo() {
        return prePreparo;
    }

    public void setPrePreparo(PrePreparo prePreparo) {
        this.prePreparo = prePreparo;
    }
    private void gerarDados(){
        parameters.put("produtoPrincipal",prePreparo.getProdutoPrincipal().getDescriao());
        parameters.put("rendimento",prePreparo.getRendimento());
        parameters.put("dataProducao",prePreparo.getDataProducao());
        parameters.put("custoTotal",prePreparo.getCustoTotal());
        listaProd= FXCollections.observableList(prePreparo.getListaProdutos());
        listaProd.forEach((pp) -> {
            System.out.println(pp.getProduto());
        });
    }
    public void gerarRelatorio() {
        gerarDados();
        try {
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(listaProd);
            String RelName = JasperFillManager.fillReportToFile(reportFilePath, parameters, beanColDataSource);
            JasperViewer viewer = new JasperViewer(RelName, false, false);
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            viewer.setTitle("FICHA DE PRE-PREPARO");
            viewer.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro-->>" + ex);
        }

    }
    

}
