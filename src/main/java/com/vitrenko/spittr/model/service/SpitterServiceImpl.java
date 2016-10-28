package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.repository.SpitterRepository;
import java.util.Objects;
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
public class SpitterServiceImpl implements SpitterService {

    private final SpitterRepository spitterRepository;

    @Inject
    public SpitterServiceImpl(SpitterRepository spitterRepository) {
        this.spitterRepository = Objects.requireNonNull(spitterRepository);
    }

    @Override
    public void registerSpitter(Spitter spitter) {
        if (findByLogin(spitter.getLogin()) != null) {
            throw new SpitterAlreadyExistsException(spitter);
        }
        spitterRepository.create(spitter);
    }

    @Nullable
    @Override
    public Spitter findByLogin(String login) {
        return spitterRepository.findByLogin(login);
    }


}
