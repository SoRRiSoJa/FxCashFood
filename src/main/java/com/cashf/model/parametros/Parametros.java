/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.model.parametros;

import com.cashf.model.cidade.Cidade;
import java.io.Serializable;
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
}
