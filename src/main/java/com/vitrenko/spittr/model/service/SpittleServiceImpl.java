/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spittle;
import com.vitrenko.spittr.model.repository.SpittleRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.List;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Service
@Transactional
@RequiredArgsConstructor
public class SpittleServiceImpl implements SpittleService {

    @Inject
    @NonNull
    private final SpittleRepository spittleRepository;

    @Override
    public Page<Spittle> find(Pageable page) {
        return spittleRepository.findAll(page);
    }

    @Override
    @Nullable
    public Spittle find(long id) {
        return spittleRepository.findOne(id);
    }

    @Override
    public List<Spittle> find() {
        return spittleRepository.findAll();
    }

    @Override
    public long count() {
        return spittleRepository.count();
    }
    
}
