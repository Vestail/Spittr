/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spittle;
import com.vitrenko.spittr.model.repository.SpittleRepository;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Service
@Transactional
public class SpittleServiceImpl implements SpittleService {

    private final SpittleRepository spittleRepository;

    @Inject
    public SpittleServiceImpl(SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }
    
    @Override
    public List<Spittle> find(int start, int count) {
        return spittleRepository.find(start, count);
    }

    @Override
    @Nullable
    public Spittle find(long id) {
        return spittleRepository.find(id);
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
