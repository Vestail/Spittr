/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author Vitalii_Vitrenko
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
    
    Spitter findByLogin(String login);

    Spitter findByEmail(String email);

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END " +
            "FROM Spitter s WHERE s.login = :#{#spitter.login} or s.email = :#{#spitter.login}")
    boolean exists(@Param("spitter") Spitter spitter);
}
