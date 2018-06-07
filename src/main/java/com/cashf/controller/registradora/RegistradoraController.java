/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.registradora;

import com.cashf.controller.mesas.MesaController;
import com.cashf.core.venda.VendaController;
import com.cashf.dao.funcionario.FuncionarioDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.funcionario.Funcionario;
import com.cashf.model.mesa.StatusMesa;
import com.cashf.model.produto.Produto;
import com.cashf.model.venda.ProdutoVenda;
import java.math.BigDecimal;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class RegistradoraController {

    public static RegistradoraController registradoraController = null;
    private final ProdutoDAO produtoDAO;
    private final FuncionarioDAO funcionarioDAO;
    private Funcionario funcionario;
    private Produto produto;
    private ObservableList<Produto> lista;
    private ObservableList<ProdutoVenda> listaProdutoVenda;
    private ObservableList<Funcionario> listaFuncioanrio;

    private RegistradoraController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.funcionarioDAO = new FuncionarioDAO(Funcionario.class);
        this.lista = FXCollections.observableArrayList(produtoDAO.listProdToVenda());
        this.listaFuncioanrio = FXCollections.observableArrayList(funcionarioDAO.listAll());
        this.produto = new Produto();
        this.listaProdutoVenda = FXCollections.observableArrayList(new ArrayList<>());
        this.funcionario = new Funcionario();
        this.produto.setIdProduto(0l);
        this.funcionario.setIdPessoa(0l);
    }

    public static synchronized RegistradoraController getInstance() {
        if (registradoraController == null) {
            registradoraController = new RegistradoraController();
        }
        return registradoraController;
    }

    public void setVenda(int numMesa) {
        if (MesaController.getInstance().getMesaNum(numMesa).getStatus() == StatusMesa.ABERTA) {
            VendaController.getInstance().setVenda(VendaController.getInstance().getVendaByMesa(MesaController.getInstance().getMesaNum(numMesa)));
        }
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ObservableList<Produto> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Produto> lista) {
        this.lista = lista;
    }

    public ObservableList<Funcionario> getListaFuncioanrio() {
        return listaFuncioanrio;
    }

    public void setListaFuncioanrio(ObservableList<Funcionario> listaFuncioanrio) {
        this.listaFuncioanrio = listaFuncioanrio;
    }

    public ObservableList<ProdutoVenda> getListaProdutoVenda() {
        return listaProdutoVenda;
    }

    public void setListaProdutoVenda(ObservableList<ProdutoVenda> listaProdutoVenda) {
        this.listaProdutoVenda = listaProdutoVenda;
    }

    public void setListaProduosVenda(long idProdVenda, Produto produto, BigDecimal qtde) {
        ProdutoVenda pv = new ProdutoVenda();
        pv.setIdProdVenda(idProdVenda);
        pv.setVendaId(VendaController.getInstance().getVenda());
        pv.setProduto(produto);
        pv.setQtde(qtde);
        pv.setPrecoUnit(produto.getPreco_venda());
        this.listaProdutoVenda.add(pv);
        //this.venda.getListaProdutos().add(pv);
    }

    BigDecimal getTotalLancamento() {
        BigDecimal total = BigDecimal.ZERO;
        for (ProdutoVenda val : listaProdutoVenda) {
            total = total.add(val.getPrecoUnit().multiply(val.getQtde()));
        }
        return total;
    }

}
