/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.atualizarestoque;

import com.cashf.controller.login.LoginController;
import com.cashf.dao.ajusteestoque.AjusteEstoqueDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.model.ajusteestoque.AjusteEstoque;
import com.cashf.model.ajusteestoque.TipoAjuste;
import com.cashf.model.notafiscal.NotaFiscal;
import com.cashf.model.prepreparo.PrePreparo;
import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import util.UnitConverter;

/**
 *
 * @author joao
 */
public class AtualizarEstoque {

    private final AjusteEstoqueDAO ajusteEstoqueDAO;
    private final ProdutoDAO produtoDAO;
    private Produto produto;
    private PrePreparo prePreparo;
    private AjusteEstoque ajusteEstoque;
    private TipoAjuste tipoAjuste;
    private UnidadeMedida unidadeMEdida;

    public AtualizarEstoque() {
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.ajusteEstoqueDAO = new AjusteEstoqueDAO(AjusteEstoque.class);
        this.produto = new Produto();
        produto.setIdProduto(0l);
        this.prePreparo = new PrePreparo();
        prePreparo.setIdPrepreparo(0l);
        this.ajusteEstoque = new AjusteEstoque();
        this.ajusteEstoque.setIdAjuste(0l);
    }

    public Boolean retirarProduto(BigDecimal qtdeAjuste, UnidadeMedida unidadeMedida) {
        boolean flag = true;
        try {
            BigDecimal qtdeAtual = produto.getUnidadesEstoque();
            if (produto.getUnidadeMedida().equals(unidadeMedida)) {
                if (qtdeAtual.compareTo(qtdeAjuste) >= 0) {//Se unidades iguáis e qtde>= a ajuste
                    produto.setUnidadesEstoque(qtdeAtual.subtract(qtdeAjuste));
                } else {
                    flag = false;
                }
            } else {
                produto.setUnidadesEstoque(qtdeAtual.subtract(UnitConverter.convertTo(unidadeMedida, produto.getUnidadeMedida(), qtdeAjuste)));
            }

            produtoDAO.update(produto);
        } catch (Exception ex) {
            System.out.println("Erro ao retirar Produto:--->>>> " + ex);
            flag = false;
        }
        return flag;
    }

    public Boolean adicionarProduto(BigDecimal qtdeAjuste, UnidadeMedida unidadeMedida) {
        boolean flag = true;
        try {
            BigDecimal qtdeAtual = produto.getUnidadesEstoque();
            if (produto.getUnidadeMedida().equals(unidadeMedida)) {
                if (qtdeAjuste.compareTo(BigDecimal.ZERO) > 0) {// qtdeAjuste>= 0
                    produto.setUnidadesEstoque(qtdeAtual.add(qtdeAjuste));
                }
            } else {
                produto.setUnidadesEstoque(qtdeAtual.add(UnitConverter.convertTo(unidadeMedida, produto.getUnidadeMedida(), qtdeAjuste)));
            }
            produtoDAO.update(produto);
        } catch (Exception ex) {
            System.out.println("Erro ao adicionar Produto:--->>>> " + ex);
            flag = false;
        }
        return flag;
    }

    public Boolean adicionarPrePreparo() {
        boolean flag = true;
        try {
            prePreparo.getListaProdutos().forEach((itemAtual) -> {
                produto = produtoDAO.findById(itemAtual.getProduto().getIdProduto());
                if (itemAtual.getUnidadeMedida().equals(produto.getUnidadeMedida())) {
                    produto.setUnidadesEstoque(produto.getUnidadesEstoque().subtract(itemAtual.getQtdeProduto()));
                } else {
                    produto.setUnidadesEstoque(produto.getUnidadesEstoque().subtract(UnitConverter.convertTo(itemAtual.getUnidadeMedida(), produto.getUnidadeMedida(), itemAtual.getQtdeProduto())));
                }
                produtoDAO.update(produto);
            });
            produto = produtoDAO.findById(prePreparo.getProdutoPrincipal().getIdProduto());
            produto.setUnidadesEstoque(prePreparo.getRendimento());
            produto.setUnidadeMedida(unidadeMEdida);
            produto.setPreco_custo(prePreparo.getCustoTotal().divide(prePreparo.getRendimento()));
            produto.setPreco_venda(prePreparo.getCustoTotal().divide(prePreparo.getRendimento()));
            produtoDAO.update(produto);
        } catch (Exception ex) {
            System.out.println("Erro ao adicionar Pre-preparo:--->>>> " + ex);
            flag = false;
        }
        return flag;
    }

    public PrePreparo getPrePreparo() {
        return prePreparo;
    }

    public void setPrePreparo(PrePreparo prePreparo) {
        this.prePreparo = prePreparo;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public AjusteEstoque getAjusteEstoque() {
        return ajusteEstoque;
    }

    public void setAjusteEstoque(AjusteEstoque ajusteEstoque) {
        this.ajusteEstoque = ajusteEstoque;
    }

    public UnidadeMedida getUnidadeMEdida() {
        return unidadeMEdida;
    }

    public void setUnidadeMEdida(UnidadeMedida unidadeMEdida) {
        this.unidadeMEdida = unidadeMEdida;
    }

    public void setAjusteEstoque(String motivo, LocalDate dataAjuste, LocalTime horaAjuste, BigDecimal qtdeAjustada) {
        this.ajusteEstoque.setMotivo(motivo);
        this.ajusteEstoque.setDataAjuste(dataAjuste);
        this.ajusteEstoque.setHoraAjuste(horaAjuste);
        this.ajusteEstoque.setProduto(produto);
        this.ajusteEstoque.setUsuario(LoginController.getInstance().getUsuario());
        this.ajusteEstoque.setTipoAjuste(tipoAjuste);
        this.ajusteEstoque.setQtdeAjustada(qtdeAjustada);
    }

    public TipoAjuste getTipoAjuste() {
        return tipoAjuste;
    }

    public void setTipoAjuste(TipoAjuste tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
    }

    public void atualizar() {
        ajusteEstoqueDAO.save(ajusteEstoque);
    }

    public Boolean adicionarProdutosNota(NotaFiscal nota) {
        boolean flag = true;
        try {
            nota.getListaProdutos().forEach((itemAtual) -> {
                produto = produtoDAO.findById(itemAtual.getProduto().getIdProduto());

                produto.setUnidadeMedida(itemAtual.getProduto().getUnidadeMedida());
                produto.setQtdeEmbalagem(itemAtual.getProduto().getQtdeEmbalagem());
                produto.setQtdeProduto(produto.getQtdeProduto().add(BigDecimal.valueOf(itemAtual.getQtdeProduto())));
                produto.setUnidadesEstoque(produto.getUnidadesEstoque().add(itemAtual.getProduto().getUnidadesEstoque()));

                produto.setPreco_custo(itemAtual.getValorTotal().add(itemAtual.getValorIpi()).divide(itemAtual.getProduto().getQtdeEmbalagem().multiply(BigDecimal.valueOf(itemAtual.getQtdeProduto())),4, RoundingMode.HALF_EVEN));
                produto.setPreco_venda(itemAtual.getValorTotal().add(itemAtual.getValorIpi()).divide(itemAtual.getProduto().getQtdeEmbalagem().multiply(BigDecimal.valueOf(itemAtual.getQtdeProduto())),4, RoundingMode.HALF_EVEN));

                produtoDAO.update(produto);
            });
        } catch (Exception ex) {
            System.out.println("Erro ao adicionar Produtos:--->>>> " + ex);
            flag = false;
        }
        return flag;
    }

}
