/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.venda;

import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.dao.venda.VendaDAO;
import com.cashf.model.mesa.Mesa;
import com.cashf.model.produto.Produto;
import com.cashf.model.venda.ProdutoVenda;
import com.cashf.model.venda.Venda;
import controller.GenericController;
import java.math.BigDecimal;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class VendaController implements GenericController<Venda> {

    private static VendaController vendaController = null;
    private Venda venda;
    private ObservableList<Venda> lista;
    //private ObservableList<ProdutoVenda> listaProduosVenda;
    private ObservableList<Produto> listaProd;
    private final ProdutoDAO produtoDAO;
    private final VendaDAO vendaDAO;
    private Produto produtoSelecionado;
    private int tipoConsulta;

    public VendaController() {

        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.vendaDAO = new VendaDAO(Venda.class);
        this.listaProd = FXCollections.observableList(produtoDAO.listProdToVenda());
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.venda = new Venda();
        venda.setIdVenda(0l);
        venda.setValorTotal(BigDecimal.ZERO);
        venda.setListaProdutos(FXCollections.observableList(new ArrayList<>()));
        this.produtoSelecionado = new Produto();
        this.produtoSelecionado.setIdProduto(0l);
    }

    public static synchronized VendaController getInstance() {
        if (vendaController == null) {
            vendaController = new VendaController();
        }
        return vendaController;
    }

    public Venda getVendaByMesa(Mesa mesa) {
        Venda venda = null;
        for (Venda ve : lista) {
            if (ve.getMesa().equals(mesa)) {
                venda = ve;
            }
        }
        return venda;
    }

    @Override
    public void insert() {
        venda.setIdVenda(vendaDAO.save(venda));
    }

    @Override
    public void update() {
        vendaDAO.update(venda);
    }

    @Override
    public void delete() {

    }

    @Override
    public void flushObject() {
        this.listaProd = FXCollections.observableList(produtoDAO.listProdToVenda());
        this.produtoSelecionado = new Produto();
        this.produtoSelecionado.setIdProduto(0l);
        this.venda = new Venda();
        venda.setIdVenda(0l);
        venda.setListaProdutos(FXCollections.observableList(new ArrayList<>()));
    }

    @Override
    public ObservableList<Venda> getLista() {
        return this.lista;
    }

    @Override
    public void setLista(ObservableList<Venda> lista) {
        this.lista = lista;
    }

    @Override
    public void setItenLista(Venda obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public ObservableList<ProdutoVenda> getListaProduosVenda() {
        return FXCollections.observableList(venda.getListaProdutos());
    }

    public void setListaProduosVenda(long idProdVenda, Venda venda, Produto produto, BigDecimal qtde, BigDecimal precoUnit) {
        ProdutoVenda pv = new ProdutoVenda();
        pv.setIdProdVenda(idProdVenda);
        pv.setVendaId(venda);
        pv.setProduto(produto);
        pv.setQtde(qtde);
        pv.setPrecoUnit(precoUnit);

        this.venda.getListaProdutos().add(pv);
    }

    public ObservableList<Produto> getListaProd() {
        return listaProd;
    }

    public void setListaProd(ObservableList<Produto> listaProd) {
        this.listaProd = listaProd;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public int getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(int tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

}
