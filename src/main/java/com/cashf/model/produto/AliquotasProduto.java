/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "aliquotas_produto")
public class AliquotasProduto implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    @Id
    private long idAliquota;
    private BigDecimal percentualPis;
    private BigDecimal cstpPis;
    private BigDecimal cfop;
    private BigDecimal cstConfins;
    private BigDecimal percentualConfins;
    private BigDecimal aliquotaCsosn;
    private BigDecimal cest;
    private BigDecimal aliquotaIcms;
    private BigDecimal aliquotafederal;
    private BigDecimal aliquotaestadual;
    private BigDecimal aliquotamunicipal;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoTributaria situacaoTributaria;

    public AliquotasProduto(long id, BigDecimal percentualPis, BigDecimal cstpPis, BigDecimal cfop, BigDecimal cstConfins, BigDecimal percentualConfins, BigDecimal aliquotaCsosn, BigDecimal cest, BigDecimal aliquotaIcms, BigDecimal aliquotafederal,BigDecimal aliquotaestadual,BigDecimal aliquomunicipal, SituacaoTributaria situacaoTributaria) {
        this.idAliquota = id;
        this.percentualPis = percentualPis;
        this.cstpPis = cstpPis;
        this.cfop = cfop;
        this.cstConfins = cstConfins;
        this.percentualConfins = percentualConfins;
        this.aliquotaCsosn = aliquotaCsosn;
        this.cest = cest;
        this.aliquotaIcms = aliquotaIcms;
        this.aliquotafederal = aliquotafederal;
        this.aliquotaestadual = aliquotaestadual;
        this.aliquotamunicipal = aliquomunicipal;
        this.situacaoTributaria = situacaoTributaria;
    }
    
    
    public AliquotasProduto() {
    }

    public long getIdAliquota() {
        return idAliquota;
    }

    public void setIdAliquota(long idAliquota) {
        this.idAliquota = idAliquota;
    }

    

    public BigDecimal getPercentualPis() {
        return percentualPis;
    }

    public void setPercentualPis(BigDecimal percentualPis) {
        this.percentualPis = percentualPis;
    }

    public BigDecimal getCstpPis() {
        return cstpPis;
    }

    public void setCstpPis(BigDecimal cstpPis) {
        this.cstpPis = cstpPis;
    }

    public BigDecimal getCfop() {
        return cfop;
    }

    public void setCfop(BigDecimal cfop) {
        this.cfop = cfop;
    }

    public BigDecimal getCstConfins() {
        return cstConfins;
    }

    public void setCstConfins(BigDecimal cstConfins) {
        this.cstConfins = cstConfins;
    }

    public BigDecimal getPercentualConfins() {
        return percentualConfins;
    }

    public void setPercentualConfins(BigDecimal percentualConfins) {
        this.percentualConfins = percentualConfins;
    }

    public BigDecimal getAliquotaCsosn() {
        return aliquotaCsosn;
    }

    public void setAliquotaCsosn(BigDecimal aliquotaCsosn) {
        this.aliquotaCsosn = aliquotaCsosn;
    }

    public BigDecimal getCest() {
        return cest;
    }

    public void setCest(BigDecimal cest) {
        this.cest = cest;
    }

    public BigDecimal getAliquotaIcms() {
        return aliquotaIcms;
    }

    public void setAliquotaIcms(BigDecimal aliquotaIcms) {
        this.aliquotaIcms = aliquotaIcms;
    }

    public BigDecimal getAliquotafederal() {
        return aliquotafederal;
    }

    public void setAliquotafederal(BigDecimal aliquotafederal) {
        this.aliquotafederal = aliquotafederal;
    }

    public BigDecimal getAliquotaestadual() {
        return aliquotaestadual;
    }

    public void setAliquotaestadual(BigDecimal aliquotaestadual) {
        this.aliquotaestadual = aliquotaestadual;
    }

    public BigDecimal getAliquotamunicipal() {
        return aliquotamunicipal;
    }

    public void setAliquotamunicipal(BigDecimal aliquotamunicipal) {
        this.aliquotamunicipal = aliquotamunicipal;
    }
    
    public SituacaoTributaria getSituacaoTributaria() {
        return situacaoTributaria;
    }

    public void setSituacaoTributaria(SituacaoTributaria situacaoTributaria) {
        this.situacaoTributaria = situacaoTributaria;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (int) (this.idAliquota ^ (this.idAliquota >>> 32));
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
        final AliquotasProduto other = (AliquotasProduto) obj;
        if (this.idAliquota != other.idAliquota) {
            return false;
        }
        if (!Objects.equals(this.percentualPis, other.percentualPis)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  ""+idAliquota;
    }
    
    
    
}
