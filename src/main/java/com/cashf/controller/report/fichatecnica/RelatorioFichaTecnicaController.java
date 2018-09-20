/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.report.fichatecnica;

import com.cashf.dao.fichatecnica.FichaTecnicaDAO;
import com.cashf.model.fichatecnica.FichaTecnica;
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
public class RelatorioFichaTecnicaController {

    private final FichaTecnicaDAO fichaTecnicaDAO;
    private ObservableList<FichaTecnica> lista;
    private FichaTecnica fichaTecnica;
    private final String reportFilePath;
    private Map<String, Object> parameters;

    public RelatorioFichaTecnicaController() {
        this.fichaTecnicaDAO = new FichaTecnicaDAO(FichaTecnica.class);
        this.lista = FXCollections.observableList(fichaTecnicaDAO.listAll());
        this.fichaTecnica = new FichaTecnica();
        this.fichaTecnica.setIdFichaTecnica(0l);
        this.fichaTecnica.setListaProdutos(FXCollections.observableList(new ArrayList<>()));
        this.reportFilePath="/home/joao/NetBeansProjects/FXCashFood/src/main/resources/reports/RelFichaTecnica.jasper";
        this.parameters= new HashMap<>();
    }
     private void gerarDados(){
        parameters.put("produtoPrincipal",fichaTecnica.getProdutoPrincipal().getDescriao());
        parameters.put("dataProducao",fichaTecnica.getDataProducao());
        parameters.put("custoTotal",fichaTecnica.getCustoTotal());
    }
     public void gerarRelatorio() {
        gerarDados();
        try {
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(fichaTecnica.getListaProdutos());
            String RelName = JasperFillManager.fillReportToFile(reportFilePath, parameters, beanColDataSource);
            JasperViewer viewer = new JasperViewer(RelName, false, false);
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
            viewer.setTitle("FICHA TÉCNICA DE PRODUTO");
            viewer.setVisible(true);

        } catch (JRException ex) {
            System.out.println("Erro-->>" + ex);
        }

    }
    public ObservableList<FichaTecnica> getLista() {
        return lista;
    }

    public void setLista(ObservableList<FichaTecnica> lista) {
        this.lista = lista;
    }

    public FichaTecnica getFichaTecnica() {
        return fichaTecnica;
    }

    public void setFichaTecnica(FichaTecnica fichaTecnica) {
        this.fichaTecnica = fichaTecnica;
    }
    

}
