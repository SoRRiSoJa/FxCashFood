/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.parametros;

import com.cashf.model.cidade.Cidade;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "Parametros")
public class Parametros implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    @Id
    private long idParametro;
    private String cnpj;
    private String inscrEst;
    private String nomefantasia;
    private String razaoSocial;
    private String endereco;
    private String complemento;
    private int numero;
    private String cep;
    private String bairro;
    private String email;
    private String telefone;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Cidade cidade;
    @Lob
    private byte[] foto;

    public Parametros() {
    }

    public Parametros(long idParametro, String cnpj, String inscrEst, String nomefantasia, String razaoSocial, String endereco, String complemento, int numero, String cep, String bairro, String email, String telefone, Cidade cidade, byte[] foto) {
        this.idParametro = idParametro;
        this.cnpj = cnpj;
        this.inscrEst = inscrEst;
        this.nomefantasia = nomefantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
        this.foto = foto;
    }

    public long getIdParametro() {
        return idParametro;
    }

    public void setIdParametro(long idParametro) {
        this.idParametro = idParametro;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscrEst() {
        return inscrEst;
    }

    public void setInscrEst(String inscrEst) {
        this.inscrEst = inscrEst;
    }

    public String getNomefantasia() {
        return nomefantasia;
    }

    public void setNomefantasia(String nomefantasia) {
        this.nomefantasia = nomefantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (this.idParametro ^ (this.idParametro >>> 32));
        hash = 23 * hash + Objects.hashCode(this.cnpj);
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
        final Parametros other = (Parametros) obj;
        if (this.idParametro != other.idParametro) {
            return false;
        }
        if (!Objects.equals(this.cnpj, other.cnpj)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomefantasia;
    }

}
