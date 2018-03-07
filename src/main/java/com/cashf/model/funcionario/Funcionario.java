/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.funcionario;

import com.cashf.model.cidade.Cidade;
import com.cashf.model.pessoa.Pessoa;
import com.cashf.model.pessoa.Sexo;
import com.cashf.model.telefone.Telefone;
import com.cashf.model.usuario.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "funcionario")
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Funcionario extends Pessoa implements Serializable {
    private String ctps;
    private BigDecimal salarioIncial;
    private BigDecimal salarioAtual;
    private BigDecimal vrDia;
    private BigDecimal vtDia;
    @Column(columnDefinition = "DATE")
    private LocalDate dataAdimissao;
    @Column(columnDefinition = "DATE")
    private LocalDate dataDemissao;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

    public Funcionario() {
        super();
    }
    
    public Funcionario(Long id, String nome, Sexo sexo, LocalDate dataNas, String endereco, String bairro, Integer numero, String complemento, String cep, Cidade cidade, String cpf, String rg, String email, List<Telefone> telefones, Boolean status,long id_funcionario, String ctps, BigDecimal salarioIncial, BigDecimal salarioAtual, BigDecimal vrDia, BigDecimal vtDia, LocalDate dataAdimissao, LocalDate dataDemissao, Usuario usuario) {
        super(id, nome, sexo, dataNas, endereco, bairro, numero, complemento, cep, cidade, cpf, rg, email, telefones, status);
        this.ctps = ctps;
        this.salarioIncial = salarioIncial;
        this.salarioAtual = salarioAtual;
        this.vrDia = vrDia;
        this.vtDia = vtDia;
        this.dataAdimissao = dataAdimissao;
        this.dataDemissao = dataDemissao;
        this.usuario = usuario;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public BigDecimal getSalarioIncial() {
        return salarioIncial;
    }

    public void setSalarioIncial(BigDecimal salarioIncial) {
        this.salarioIncial = salarioIncial;
    }

    public BigDecimal getSalarioAtual() {
        return salarioAtual;
    }

    public void setSalarioAtual(BigDecimal salarioAtual) {
        this.salarioAtual = salarioAtual;
    }

    public BigDecimal getVrDia() {
        return vrDia;
    }

    public void setVrDia(BigDecimal vrDia) {
        this.vrDia = vrDia;
    }

    public BigDecimal getVtDia() {
        return vtDia;
    }

    public void setVtDia(BigDecimal vtDia) {
        this.vtDia = vtDia;
    }

    public LocalDate getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(LocalDate dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    public LocalDate getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(LocalDate dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + (int) (getIdPessoa() ^ (this.getIdPessoa()>>> 32));
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.getIdPessoa(), other.getIdPessoa())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getNome();
    }
    
}
