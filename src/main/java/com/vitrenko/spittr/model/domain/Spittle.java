/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

/**
 * @author Vitalii_Vitrenko
 */
@Entity
public class Spittle extends DomainObject {

    @NotNull
    private String message;

    @Past
    private LocalDate date;

    @ManyToOne()
    @JoinColumn(nullable = false)
    private Spitter spitter;

    public Spittle() {

    }

    public Spittle(Long id, String message, LocalDate date, Double latitude, Double longitude) {
        super(id);
        this.message = message;
        this.date = date;

    }

    public Spittle(long id, String message, LocalDate date) {
        this(id, message, date, null, null);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
