/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.produto;

import com.cashf.dao.produto.AliquotasProdutoDAO;
import com.cashf.dao.produto.GrupoDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.produto.AliquotasProduto;
import com.cashf.model.produto.Grupo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.SituacaoTributaria;
import com.cashf.model.produto.TipoProduto;
import com.cashf.model.produto.UnidadeMedida;
import controller.GenericController;
import java.math.BigDecimal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author joao
 */
public class ProdutoController implements GenericController<Produto> {

    private final ProdutoDAO produtoDAO;
    private final GrupoDAO grupoDAO;
    private final AliquotasProdutoDAO aliquotasProdutoDAO;
    private Produto produto;
    private Grupo grupo;
    private AliquotasProduto aliquotaProduto;
    private SituacaoTributaria situacaoTributaria;
    private TipoProduto tipoProduto;
    private UnidadeMedida unidadeMedida;
    private ObservableList<Produto> lista;
    private ObservableList<Grupo> listaGrupo;

    public ProdutoController() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.grupoDAO=new GrupoDAO(Grupo.class);
        this.aliquotasProdutoDAO=new AliquotasProdutoDAO(AliquotasProduto.class);
        this.lista=FXCollections.observableList(produtoDAO.listAll());
        this.listaGrupo=FXCollections.observableList(grupoDAO.listAll());
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public void setProduto(long id, String codigoReferencia, String descriao, int qtdeEmbalagem, String ncm, BigDecimal preco_custo, BigDecimal preco_venda, Grupo grupo,UnidadeMedida unidadeMedida, TipoProduto tipo, boolean status) {
        this.produto.setIdProduto(id);
        this.produto.setCodigoReferencia(codigoReferencia);
        this.produto.setDescriao(descriao);
        this.produto.setQtdeEmbalagem(qtdeEmbalagem);
        this.produto.setNcm(ncm);
        this.produto.setPreco_custo(preco_custo);
        this.produto.setPreco_venda(preco_venda);
        this.produto.setGrupo(grupo);
        //this.produto.setAliquotasProduto(aliquotasProduto);
        this.produto.setUnidadeMedida(unidadeMedida);
        this.produto.setTipo(tipo);
        this.produto.setStatus(status);
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public AliquotasProduto getAliquotaProduto() {
        return aliquotaProduto;
    }

    public void setAliquotaProduto(AliquotasProduto aliquotaProduto) {
        this.aliquotaProduto = aliquotaProduto;
    }
    public void setAliquotaProduto(long id, BigDecimal percentualPis, BigDecimal cstpPis, BigDecimal cfop, BigDecimal cstConfins, BigDecimal percentualConfins, BigDecimal aliquotaCsosn, BigDecimal cest, BigDecimal aliquotaIcms, BigDecimal aliquotafederal) {
        this.aliquotaProduto.setIdAliquota(id);
        this.aliquotaProduto.setPercentualPis(percentualPis);
        this.aliquotaProduto.setCstpPis(cstpPis);
        this.aliquotaProduto.setCfop(cfop);
        this.aliquotaProduto.setCstConfins(cstConfins);
        this.aliquotaProduto.setPercentualConfins(percentualConfins);
        this.aliquotaProduto.setAliquotaCsosn(aliquotaCsosn);
        this.aliquotaProduto.setCest(cest);
        this.aliquotaProduto.setAliquotaIcms(aliquotaIcms);
        this.aliquotaProduto.setAliquotafederal(aliquotafederal);
        this.aliquotaProduto.setSituacaoTributaria(situacaoTributaria);
    }

    public SituacaoTributaria getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public void setSituacaoTributaria(SituacaoTributaria situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public UnidadeMedida getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public ObservableList<Grupo> getListaGrupo() {
        return listaGrupo;
    }

    public void setListaGrupo(ObservableList<Grupo> listaGrupo) {
        this.listaGrupo = listaGrupo;
    }
    
    public void insertAliquotaProduto() {

    }

    public void updateAliquotaProduto() {

    }
    
    public void flushAliquotaProduto() {
        this.aliquotaProduto=new AliquotasProduto();
        this.aliquotaProduto.setIdAliquota(0l);
    }


    @Override
    public void insert() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void flushObject() {
        this.produto=new Produto();
        produto.setIdProduto(0l);
    }

    @Override
    public ObservableList<Produto> getLista() {
        return this.lista;
    }

    @Override
    public void setLista(ObservableList<Produto> lista) {
        this.lista=lista;
    }

    @Override
    public void setItenLista(Produto obj) {
        this.lista.add(obj);
    }

}
