/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.core.venda;

import com.cashf.controller.caixa.CaixaController;
import com.cashf.core.atualizarestoque.AtualizarEstoque;
import com.cashf.dao.caixamovimento.CaixaMovimentoDAO;
import com.cashf.dao.combo.ComboDAO;
import com.cashf.dao.contacorrente.ContaCorrenteDAO;
import com.cashf.dao.meiopagamento.MeioPagamentoDAO;
import com.cashf.dao.produto.ProdutoDAO;
import com.cashf.dao.venda.VendaDAO;
import com.cashf.model.caixa.CaixaMovimento;
import com.cashf.model.combo.Combo;
import com.cashf.model.combo.ProdutoCombo;
import com.cashf.model.contacorrente.ContaCorrente;
import com.cashf.model.contasPagar.StatusPagto;
import com.cashf.model.meiopagamento.MeioPagamento;
import com.cashf.model.mesa.Mesa;
import com.cashf.model.produto.Produto;
import com.cashf.model.venda.ProdutoVenda;
import com.cashf.model.venda.Venda;
import controller.GenericController;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private ObservableList<Produto> listaProd;
    private MeioPagamento meioPagto;
    private final ProdutoDAO produtoDAO;
    private final ComboDAO comboDAO;
    private final VendaDAO vendaDAO;
    private final CaixaMovimentoDAO caixaMovimentoDAO;
    private final MeioPagamentoDAO meioPAgamentoDAO;
    private final ContaCorrenteDAO contaCorrenteDAO;
    private Produto produtoSelecionado;
    private Combo comboSelecionado;
    private final AtualizarEstoque atualizarEstoque;
    private int tipoConsulta;
    private int etapaAtual;

    public VendaController() {
        this.etapaAtual = 1;
        this.produtoDAO = new ProdutoDAO(Produto.class);
        this.vendaDAO = new VendaDAO(Venda.class);
        this.comboDAO = new ComboDAO(Combo.class);
        this.meioPAgamentoDAO = new MeioPagamentoDAO(MeioPagamento.class);
        this.caixaMovimentoDAO = new CaixaMovimentoDAO(CaixaMovimento.class);
        this.listaProd = FXCollections.observableList(produtoDAO.listProdToVenda());
        this.lista = FXCollections.observableList(new ArrayList<>());
        this.venda = new Venda();
        venda.setIdVenda(0l);
        venda.setValorTotal(BigDecimal.ZERO);
        venda.setListaProdutos(FXCollections.observableList(new ArrayList<>()));
        this.produtoSelecionado = new Produto();
        this.produtoSelecionado.setIdProduto(0l);
        this.comboSelecionado = new Combo();
        this.comboSelecionado.setIdCombo(0l);
        this.atualizarEstoque = new AtualizarEstoque();
        this.contaCorrenteDAO = new ContaCorrenteDAO(ContaCorrente.class);
    }

    public static synchronized VendaController getInstance() {
        if (vendaController == null) {
            vendaController = new VendaController();
        }
        return vendaController;
    }

    public int getEtapaAtual() {
        return etapaAtual;
    }

    public void setEtapaAtual(int etapaAtual) {
        this.etapaAtual = etapaAtual;
    }

    public Combo getComboSelecionado() {
        return comboSelecionado;
    }

    public void setComboSelecionado(Combo comboSelecionado) {
        this.comboSelecionado = comboSelecionado;
    }
    /**
     * Retorna o objeto Venda associado a um objeto Mesa da lista de mesas abertas
     * public Venda getVendaByMesa(Mesa)
     * @param mesa - Objeto mesa que se deseja obter a venda
     * @return Venda - Venda associada a mesa .
     */
    public Venda getVendaByMesa(Mesa mesa) {

        lista.stream().filter((ve) -> (ve.getMesa().equals(mesa))).forEachOrdered((ve) -> {
            venda = ve;
        });
        return venda;
    }
    /**
     * Calcula o valor total dos produtos de uma venda realizando a 
     * multiplicação dos preços unitários pela quantidade.
     * public BigDecimal getValTotal()
     *
     * @return BigDecimal - Valor total da venda
     */
    public BigDecimal getValTotal() {
        BigDecimal tot = BigDecimal.ZERO;
        for (ProdutoVenda pv : VendaController.getInstance().getListaProduosVenda()) {
            tot = tot.add(pv.getPrecoUnit().multiply(pv.getQtde()));
        }
        return tot;
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
    /**
     * Realiza o fechamento da venda gerando sua conta a receber, atualizando 
     * seu valor total e data. Insere a movimentação de caixa e realia a
     * atualização do estoque de produtos e atualiza o saldo da conta conrrente
     * associada ao meio de pagamento selecionado.
     * 
     * private void fecharVenda()
     */
    public void fecharVenda() {
        GerarContasReceber gerarContasReceber = new GerarContasReceber();
        venda.setValorTotal(getValTotal());
        venda.setDataVenda(LocalDate.now());

        insert();
        CaixaController.getInstance().movimentarCaixaCredito("Venda", getValTotal());
        venda.getListaProdutos().stream().map((pv) -> {
            atualizarEstoque.setProduto(pv.getProduto());
            return pv;
        }).map((pv) -> {
            atualizarEstoque.setUnidadeMEdida(pv.getProduto().getUnidadeMedida());
            return pv;
        }).forEachOrdered((pv) -> {
            atualizarEstoque.retirarProduto(pv.getQtde(), pv.getProduto().getUnidadeMedida());
        });
        gerarContasReceber.setContaReceber(LocalDate.now(),
                LocalDate.now(),
                venda.getCliente().getNome(),
                "VENDA", venda.getValorTotal(), BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO,
                venda.getValorTotal(), meioPagto, venda, StatusPagto.PAGO);
        gerarContasReceber.efetuarLancamento();
        lista.remove(venda);
    }

    /**
     * Atualiza o valor do saldo da conta corrente associada ao meio de 
     * pagamento selecionado no fechamento da venda.
     * private void atualizarSaldoCC()
     */
    private void atualizarSaldoCC() {
        meioPagto.getContaCorrente().setSaldo(meioPagto.getContaCorrente().getSaldo().add(venda.getValorTotal()));
        contaCorrenteDAO.update(meioPagto.getContaCorrente());
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

    public void selCombo() {
        comboSelecionado = comboDAO.listProdInsumos(produtoSelecionado).get(0);
    }

    public ObservableList<Produto> getListaProdEtapa(int etapa) {
        ObservableList<Produto> olpc = FXCollections.observableList(new ArrayList<>());
        comboSelecionado.getListaProdutos().stream().filter((pc) -> (pc.getEtapa().equals(etapa))).forEachOrdered((pc) -> {
            olpc.add(pc.getProduto());
        });
        return olpc;
    }

    public ProdutoCombo getByProduto(Produto produto) {
        ProdutoCombo pCombo = new ProdutoCombo();
        for (ProdutoCombo pcs : comboSelecionado.getListaProdutos()) {
            if (pcs.getProduto().equals(produto)) {
                pCombo = pcs;
            }
        }
        return pCombo;
    }

    public void addProdutoComboToProdutoVenda(BigDecimal qtde) {
        ProdutoVenda pv = new ProdutoVenda();
        pv.setIdProdVenda(0l);
        pv.setProduto(produtoSelecionado);
        pv.setPrecoUnit(getByProduto(produtoSelecionado).getValorDiferenciado());
        pv.setQtde(qtde);
        pv.setVendaId(venda);
        this.venda.getListaProdutos().add(pv);
    }

    public int getMaxEtapa(Combo combo) {
        int max = 0;
        for (ProdutoCombo pc : combo.getListaProdutos()) {
            max = (pc.getEtapa() > max) ? pc.getEtapa() : max;
        }
        return max;
    }

    public ObservableList<MeioPagamento> getListaMeioPagto() {
        return FXCollections.observableList(meioPAgamentoDAO.listAll());
    }

    public MeioPagamento getMeioPagto() {
        return meioPagto;
    }

    public void setMeioPagto(MeioPagamento meioPagto) {
        this.meioPagto = meioPagto;
    }

}
