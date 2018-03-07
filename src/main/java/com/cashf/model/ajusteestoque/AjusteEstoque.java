/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.ajusteestoque;

import com.cashf.model.produto.Produto;
import com.cashf.model.usuario.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
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
@Table(name = "ajuste_estoque")
public class AjusteEstoque implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(columnDefinition = "serial")
    @Id
    private Long idAjuste;
    private String motivo;
    @Column(columnDefinition = "DATE")
    private LocalDate dataAjuste;
    @Column(columnDefinition = "TIME")
    private LocalTime horaAjuste;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Produto produto;
    private BigDecimal qtdeAjustada;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoAjuste tipoAjuste;

    public AjusteEstoque() {
    }

    public AjusteEstoque(Long idAjuste, String motivo, LocalDate dataAjuste, LocalTime horaAjuste, Produto produto, BigDecimal qtdeAjustada, Usuario usuario, TipoAjuste tipoAjuste) {
        this.idAjuste = idAjuste;
        this.motivo = motivo;
        this.dataAjuste = dataAjuste;
        this.horaAjuste = horaAjuste;
        this.produto = produto;
        this.qtdeAjustada = qtdeAjustada;
        this.usuario = usuario;
        this.tipoAjuste = tipoAjuste;
    }

    public Long getIdAjuste() {
        return idAjuste;
    }

    public void setIdAjuste(Long idAjuste) {
        this.idAjuste = idAjuste;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getDataAjuste() {
        return dataAjuste;
    }

    public void setDataAjuste(LocalDate dataAjuste) {
        this.dataAjuste = dataAjuste;
    }

    public LocalTime getHoraAjuste() {
        return horaAjuste;
    }

    public void setHoraAjuste(LocalTime horaAjuste) {
        this.horaAjuste = horaAjuste;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQtdeAjustada() {
        return qtdeAjustada;
    }

    public void setQtdeAjustada(BigDecimal qtdeAjustada) {
        this.qtdeAjustada = qtdeAjustada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoAjuste getTipoAjuste() {
        return tipoAjuste;
    }

    public void setTipoAjuste(TipoAjuste tipoAjuste) {
        this.tipoAjuste = tipoAjuste;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idAjuste);
        hash = 97 * hash + Objects.hashCode(this.dataAjuste);
        hash = 97 * hash + Objects.hashCode(this.horaAjuste);
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
        final AjusteEstoque other = (AjusteEstoque) obj;
        if (!Objects.equals(this.idAjuste, other.idAjuste)) {
            return false;
        }
        if (!Objects.equals(this.dataAjuste, other.dataAjuste)) {
            return false;
        }
        if (!Objects.equals(this.horaAjuste, other.horaAjuste)) {
            return false;
        }
        return true;
    }
    
}
