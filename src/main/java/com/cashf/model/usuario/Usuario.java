/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.usuario;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author joao
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(columnDefinition = "serial")
    private Long idUsuario;
    @NotNull
    @Column(unique = true)
    private String login;
    @NotEmpty
    private String senha;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UNivel nivel;
    private Boolean status;

    public Usuario() {
    }

    public Usuario(Long id, String login, String senha, UNivel nivel, Boolean status) {
        this.idUsuario = id;
        this.login = login;
        this.senha = senha;
        this.nivel = nivel;
        this.status = status;
    }

    public Long getId() {
        return idUsuario;
    }

    public void setId(Long id) {
        this.idUsuario = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UNivel getNivel() {
        return nivel;
    }

    public void setNivel(UNivel nivel) {
        this.nivel = nivel;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idUsuario + "-" + login + "|" + nivel;
    }

}
