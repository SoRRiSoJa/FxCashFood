/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author joao
 */
public interface GenericViewController {

    public void clearFields();

    public void setInputOff();

    public void setInputOn();

    public Boolean validateFields();

    public void getData();

    public void loadDataToScreen();
}
