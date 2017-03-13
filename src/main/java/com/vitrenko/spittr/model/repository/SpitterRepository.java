/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 *
 * @author Vitalii_Vitrenko
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    
    Spitter findByLogin(String login);

}
