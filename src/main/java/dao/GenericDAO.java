/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author joao
 */
interface GenericDAO<T> {

    public Long save(T obj);

    public void update(T obj);

    public void delete(T obj);

    public T findById(long id);

    public List<T> listAll();
}
