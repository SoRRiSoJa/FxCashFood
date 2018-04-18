/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.venda;

import com.cashf.model.cliente.Cliente;
import com.cashf.model.mesa.Mesa;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idVenda;
    private BigDecimal valorTotal;
    private LocalDate dataVenda;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Mesa mesa;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "vendaId", cascade = CascadeType.ALL)
    private List<ProdutoVenda> listaProdutos;

    public Venda() {
    }

    public Venda(long idVenda, BigDecimal valorTotal, LocalDate dataVenda, Mesa mesa, Cliente cliente, List<ProdutoVenda> listaProdutos) {
        this.idVenda = idVenda;
        this.valorTotal = valorTotal;
        this.dataVenda = dataVenda;
        this.mesa = mesa;
        this.cliente = cliente;
        this.listaProdutos = listaProdutos;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(long idVenda) {
        this.idVenda = idVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProdutoVenda> getListaProdutos() {
        return listaProdutos;
    }

    public void setListaProdutos(List<ProdutoVenda> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.idVenda ^ (this.idVenda >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.idVenda != other.idVenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "valorTotal=" + valorTotal + ", dataVenda=" + dataVenda + ", mesa=" + mesa + '}';
    }
    

}
