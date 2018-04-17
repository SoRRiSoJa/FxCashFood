/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.parametros;

import com.cashf.model.produto.SituacaoTributaria;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "parametros_fiscais")
public class ParametrosFiscais implements Serializable{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    @Id
    private long idParametroFiscal;
    @Column(precision = 8, scale = 4)
    private BigDecimal percentualPis;
    private BigDecimal cstpPis;
    private BigDecimal cfop;
    private BigDecimal cstConfins;
    @Column(precision = 8, scale = 4)
    private BigDecimal percentualConfins;
    @Column(precision = 8, scale = 4)
    private BigDecimal aliquotaCsosn;
    private BigDecimal cest;
    @Column(precision = 8, scale = 4)
    private BigDecimal aliquotaIcms;
    @Column(precision = 8, scale = 4)
    private BigDecimal aliquotafederal;
    @Column(precision = 8, scale = 4)
    private BigDecimal aliquotaestadual;
    @Column(precision = 8, scale = 4)
    private BigDecimal aliquotamunicipal;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SituacaoTributaria situacaoTributaria;

    public ParametrosFiscais() {
    }

    public ParametrosFiscais(long idParametroFiscal, BigDecimal percentualPis, BigDecimal cstpPis, BigDecimal cfop, BigDecimal cstConfins, BigDecimal percentualConfins, BigDecimal aliquotaCsosn, BigDecimal cest, BigDecimal aliquotaIcms, BigDecimal aliquotafederal, BigDecimal aliquotaestadual, BigDecimal aliquotamunicipal, SituacaoTributaria situacaoTributaria) {
        this.idParametroFiscal = idParametroFiscal;
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
        this.aliquotamunicipal = aliquotamunicipal;
        this.situacaoTributaria = situacaoTributaria;
    }

    public long getIdParametroFiscal() {
        return idParametroFiscal;
    }

    public void setIdParametroFiscal(long idParametroFiscal) {
        this.idParametroFiscal = idParametroFiscal;
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
        hash = 97 * hash + (int) (this.idParametroFiscal ^ (this.idParametroFiscal >>> 32));
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
        final ParametrosFiscais other = (ParametrosFiscais) obj;
        if (this.idParametroFiscal != other.idParametroFiscal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  situacaoTributaria.toString();
    }
    
    
}
