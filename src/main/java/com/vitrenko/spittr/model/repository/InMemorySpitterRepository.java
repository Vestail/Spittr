/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spitter;
import javax.annotation.Nullable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Repository
public class InMemorySpitterRepository extends InMemoryDomainObjectRepository<Spitter>
        implements SpitterRepository {

    @Override
    @Nullable
    public Spitter readByLogin(String login) {
        return getEntityMap().values().stream()
                .filter(e -> e.getLogin().equals(login))
                .findAny()
                .orElse(null);
    }

}
