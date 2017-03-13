/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spittle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.annotation.Nullable;
import java.util.List;

/**
 *
 * @author Vitalii_Vitrenko
 */
public interface SpittleService {

    Page<Spittle> find(Pageable page);

    List<Spittle> find();

    @Nullable
    Spittle find(long id);
    
    long count();
}
