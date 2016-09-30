package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.domain.Spittle;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vitalii_Vitrenko on 30-Sep-16.
 */
@Repository
public class JpaSpittleRepository extends JpaCrudRepository<Spittle, Long> implements SpittleRepository {

    public JpaSpittleRepository() {
        super(Spittle.class);
    }
}
