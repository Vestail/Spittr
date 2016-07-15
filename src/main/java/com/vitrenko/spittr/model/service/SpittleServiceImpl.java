/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spittle;
import com.vitrenko.spittr.model.repository.SpittleRepository;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Service
public class SpittleServiceImpl implements SpittleService {

    private final SpittleRepository spittleRepository;

    @Inject
    public SpittleServiceImpl(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }
    
    @Override
    public List<Spittle> find(int start, int count) {
        return spittleRepository.read(start, count);
    }

    @Override
    public Spittle find(long id) {
        return spittleRepository.read(id);
    }

    @Override
    public List<Spittle> find() {
        return find(0, Integer.MAX_VALUE);
    }

    @Override
    public long count() {
        return spittleRepository.size();
    }
    
}
