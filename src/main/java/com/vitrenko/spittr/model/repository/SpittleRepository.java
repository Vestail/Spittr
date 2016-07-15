package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spittle;
import java.util.List;

/**
 *
 * @author Vitalii_Vitrenko
 */
public interface SpittleRepository extends CrudRepository<Spittle, Long> {

    List<Spittle> read(int start, int count);
    
    long size();

    Spittle read(long id);
}
