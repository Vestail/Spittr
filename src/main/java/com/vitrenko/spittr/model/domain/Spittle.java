/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.domain;

import java.time.LocalDate;

/**
 *
 * @author Vitalii_Vitrenko
 */
public class Spittle extends DomainObject {

    private String message;
    private LocalDate date;
    private Double latitude;
    private Double longitude;
    
    public Spittle() {
        
    }

    public Spittle(Long id, String message, LocalDate date, Double latitude, Double longitude) {
        super(id);
        this.message = message;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
