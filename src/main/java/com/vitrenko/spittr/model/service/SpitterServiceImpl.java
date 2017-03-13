package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.repository.SpitterRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.inject.Inject;

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
        if (findByLogin(spitter.getLogin()) != null) {
            throw new SpitterAlreadyExistsException(spitter);
        }
        return spitterRepository.save(spitter);
    }

    @Nullable
    @Override
    public Spitter findByLogin(String login) {
        return spitterRepository.findByLogin(login);
    }

}
