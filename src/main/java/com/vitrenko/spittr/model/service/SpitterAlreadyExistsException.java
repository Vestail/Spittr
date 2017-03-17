package com.vitrenko.spittr.model.service;

import com.vitrenko.spittr.model.domain.Spitter;
import lombok.Data;

@Data
public class SpitterAlreadyExistsException extends RuntimeException {

    private final String login;

    private final String email;

    @Override
    public String toString() {
        return String.format("Spitter with login %s or email %s is already exist", login, email);
    }
}
