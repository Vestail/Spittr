/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spitter;

/**
 *
 * @author Vitalii_Vitrenko
 */
public interface SpitterService {

    Spitter registerSpitter(Spitter spitter);

    Spitter findByLogin(String login);
}
