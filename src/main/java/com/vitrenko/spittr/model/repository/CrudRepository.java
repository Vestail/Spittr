/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.repository;

import java.util.Collection;

/**
 *
 * @author Vitalii_Vitrenko
 */
public interface CrudRepository<T, PK> {
    
    T read(PK pk);
    Collection<T> read();
    void save(T entity);
    void delete(T entity);
            
}
