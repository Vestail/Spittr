package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.repository.SpitterRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Predicate;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.inject.Inject;

import static org.springframework.data.domain.ExampleMatcher.matching;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Service
@Transactional
@RequiredArgsConstructor
public class SpitterServiceImpl implements SpitterService {

    @Inject
    @NonNull
    private final SpitterRepository spitterRepository;

    @Override
    public Spitter registerSpitter(Spitter spitter) {
        try {
            return spitterRepository.save(spitter);
        } catch (DataIntegrityViolationException ex) {
            throw new SpitterAlreadyExistsException(spitter.getLogin(), spitter.getEmail());
        }
    }

    @Nullable
    @Override
    public Spitter findByLogin(String login) {
        return spitterRepository.findByLogin(login);
    }

}
