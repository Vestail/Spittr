package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spitter;

public class SpitterAlreadyExistsException extends RuntimeException {

    Spitter spitter;

    public SpitterAlreadyExistsException(Spitter spitter) {
        this.spitter = spitter;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    @Override
    public String toString() {
        return String.format("Spitter with login %s or email %s is already exist",
                spitter.getLogin(), spitter.getEmail());
    }
}
