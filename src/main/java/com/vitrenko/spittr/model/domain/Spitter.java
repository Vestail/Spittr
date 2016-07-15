/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.domain;

import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Vitalii_Vitrenko
 */
public class Spitter extends DomainObject {

    @NotNull
    @Size(min = 4, max = 16)
    private String login;

    @NotNull
    @Size(min = 6, max = 24)
    private String password;

    @Email
    @NotNull
    private String email;

    private String firstName;

    private String lastName;

    public Spitter() {

    }

    public Spitter(Long id, String login, String password, String email, String firstName, String lastName) {
        super(id);
        this.login = login;
        this.password = password;
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
