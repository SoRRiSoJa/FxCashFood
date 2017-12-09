/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cashf.controller.login;

import com.cashf.dao.usuario.UsuarioDAO;
import com.cashf.model.usuario.Usuario;
import util.SafePass;

/**
 *
 * @author joao
 */
public class LoginController {

    private final UsuarioDAO usuarioDAO;
    private Usuario usuario;
    private String login;
    private String senha;
    private int loginStatus;
    public static LoginController loginController = null;

    private LoginController() {
        this.login = "";
        this.senha = "";
        this.loginStatus = -1;
        this.usuario = new Usuario();
        this.usuarioDAO = new UsuarioDAO(Usuario.class);
    }

    public static synchronized LoginController getInstance() {
        if (loginController == null) {
            loginController = new LoginController();
        }
        return loginController;
    }

    public Usuario getUsuario() {
        return usuario;
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
        this.senha = SafePass.crypPass(senha);
        System.out.println("Nova Senha:" + this.senha);
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus() {
        this.loginStatus = usuario.getNivel().ordinal();
    }

    public boolean validateUser() {
        boolean flag = false;
        try {
            usuario = usuarioDAO.findByLogin(login);
            flag = (usuario != null);
            System.out.println("" + usuario.getLogin());
        } catch (Exception ex) {
            System.out.println("Erro:" + ex);
        }

        return flag;
    }

    public boolean validatePassword() {
        boolean flag;
        flag = (usuario.getSenha().equalsIgnoreCase(senha));
        return flag;
    }

}
