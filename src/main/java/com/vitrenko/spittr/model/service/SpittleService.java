/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spittle;
import java.util.List;
import javax.annotation.Nullable;

/**
 *
 * @author Vitalii_Vitrenko
 */
public interface SpittleService {

    List<Spittle> find(int start, int count);

    List<Spittle> find();

    @Nullable
    Spittle find(long id);
    
    long count();
}
