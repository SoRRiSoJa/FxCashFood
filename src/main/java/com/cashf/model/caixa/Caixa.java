/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.caixa;

import com.cashf.model.contacorrente.ContaCorrente;
import com.cashf.model.usuario.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @ManyToOne
    @JoinColumn(nullable = false)
    private ContaCorrente contaCorrente;
    private LocalDate dataAbertura;
    private LocalTime horaAbertura;
    private LocalDate dataFechamento;
    private LocalTime horaFechamento;
    private BigDecimal valorInicial;
    @Enumerated(EnumType.STRING)
    private TPStatusCX status;
    

    public Caixa() {
    }

    public Caixa(long idCaixa, Usuario usuario,ContaCorrente contaCorrente, LocalDate dataAbertura, LocalTime horaAbertura, LocalDate dataFechamento, LocalTime horaFechamento, BigDecimal valorInicial,TPStatusCX status) {
        this.idCaixa = idCaixa;
        this.usuario = usuario;
        this.contaCorrente=contaCorrente;
        this.dataAbertura = dataAbertura;
        this.horaAbertura=horaAbertura;
        this.dataFechamento = dataFechamento;
        this.horaFechamento=horaFechamento;
        this.valorInicial = valorInicial;
        this.status=status;
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

    public LocalTime getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(LocalTime horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public LocalTime getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(LocalTime horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public TPStatusCX getStatus() {
        return status;
    }

    public void setStatus(TPStatusCX status) {
        this.status = status;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
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
