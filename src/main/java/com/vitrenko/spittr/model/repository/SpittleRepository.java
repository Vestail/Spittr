package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.model.domain.Spittle;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Vitalii_Vitrenko
 */
public interface SpittleRepository extends JpaRepository<Spittle, Long> {

}
