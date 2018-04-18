/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.mesa;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "mesa")
public class Mesa implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private long idMesa;
    private Integer numPax;
    private int numMesa;
    @Column(columnDefinition = "DATE")
    private LocalDate dataAbertura;
    @Column(columnDefinition = "TIME")
    private LocalTime horaAbertura;
    @Column(columnDefinition = "TIME")
    private LocalTime horaFechamento;
    private int status;

    public Mesa() {
    }

    public Mesa(long idMesa, Integer numPax, int numMesa, LocalDate dataAbertura, LocalTime horaAbertura, LocalTime horaFechamento, int status) {
        this.idMesa = idMesa;
        this.numPax = numPax;
        this.numMesa = numMesa;
        this.dataAbertura = dataAbertura;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.status = status;
    }

    public long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(long idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getNumPax() {
        return numPax;
    }

    public void setNumPax(Integer numPax) {
        this.numPax = numPax;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.idMesa ^ (this.idMesa >>> 32));
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
        final Mesa other = (Mesa) obj;
        if (this.idMesa != other.idMesa) {
            return false;
        }
        if (!Objects.equals(this.horaAbertura, other.horaAbertura)) {
            return false;
        }
        if (!Objects.equals(this.horaFechamento, other.horaFechamento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  numMesa +"";
    }
    
    
}
