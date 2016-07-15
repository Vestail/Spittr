/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.repository.SpitterRepository;
import java.util.Objects;
import javax.annotation.Nullable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Service
public class SpitterService {
    
    private final SpitterRepository spitterRepository;

    public SpitterService(SpitterRepository spitterRepository) {
        this.spitterRepository = Objects.requireNonNull(spitterRepository);
    }
    
    public void registerSpitter(Spitter spitter) {
        if (findByLogin(spitter.getLogin()) != null) {
            throw new DataIntegrityViolationException("spitter with login " + spitter.getLogin() + " already exists");
        }
        spitterRepository.save(spitter);
    }
    
    @Nullable
    public Spitter findByLogin(String login) {
        return spitterRepository.readByLogin(login);
    }
}
