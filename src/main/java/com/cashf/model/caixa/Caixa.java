/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.caixa;

import com.cashf.model.usuario.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "caixa")
public class Caixa implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idCaixa;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
    @Column(columnDefinition = "DATE")
    private LocalDate dataAbertura;
    private LocalDate dataFechamento;
    private BigDecimal valorInicial;

    public Caixa() {
    }

    public Caixa(long idCaixa, Usuario usuario, LocalDate dataAbertura, LocalDate dataFechamento, BigDecimal valorInicial) {
        this.idCaixa = idCaixa;
        this.usuario = usuario;
        this.dataAbertura = dataAbertura;
        this.dataFechamento = dataFechamento;
        this.valorInicial = valorInicial;
    }

    public long getIdCaixa() {
        return idCaixa;
    }

    public void setIdCaixa(long idCaixa) {
        this.idCaixa = idCaixa;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDate getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDate dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.idCaixa ^ (this.idCaixa >>> 32));
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
        final Caixa other = (Caixa) obj;
        if (this.idCaixa != other.idCaixa) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Caixa:" + usuario.getLogin() + "|DTA" + dataAbertura.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
    }
    

}
