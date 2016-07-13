/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spittle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Repository
public class InMemorySpittleRepository implements SpittleRepository {
    
    private Map<Long, Spittle> spittles;
    
    private static final int INIT_SPITTLE_COUNT = 20;
    
    public InMemorySpittleRepository() {
        initSpittles(INIT_SPITTLE_COUNT);
    }

    @Override
    public List<Spittle> read(int start, int count) {
        List<Spittle> spittleList = new ArrayList(spittles.values());
        spittleList.sort((e1, e2) -> e1.getDate().compareTo(e2.getDate()));
        int toIndex = start + count;
        if (toIndex > spittleList.size()) {
            toIndex = spittleList.size();
        }
        return spittleList.subList(start, toIndex);
    }

    @Override
    @Nullable
    public Spittle read(long id) {
        return spittles.get(id);
    }

    private void initSpittles(int count) {
        spittles = new HashMap<>();
        for (int i = 1; i <= count; i++) {
            spittles.put((long) i, new Spittle(i, Integer.toString(i), LocalDate.now()));
        }      
    }

    @Override
    public long size() {
        return spittles.size();
    }
    
}
