/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.web.controller;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.service.SpitterService;

import java.util.ArrayList;
import java.util.Objects;
import org.hamcrest.Matchers;
import org.hamcrest.beans.HasPropertyWithValue;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 *
 * @author Vitalii_Vitrenko
 */
public class SpitterControllerTest {

    SpitterService service = mock(SpitterService.class);
    SpitterController controller = new SpitterController(service);
    MockMvc mockMvc = standaloneSetup(controller).build();

    @Test
    public void shoudReturnEmptySpitterWhenRegister() throws Exception {
        mockMvc.perform(get("/spitter/register/"))
                .andExpect(view().name("registerForm"))
                .andExpect(model().attributeExists("spitter"))
                .andExpect(model().attribute("spitter", Matchers.hasProperty("id", IsNull.nullValue())));
    }

    @Test
    public void shouldPerfomRegistration() throws Exception {
        Spitter spitter = new Spitter(null, "login", "password", "email@email.com", "fname", "lname", new ArrayList<>());

        mockMvc.perform(post("/spitter/register")
                .param("id", Objects.toString(spitter.getId(), ""))
                .param("login", spitter.getLogin())
                .param("email", spitter.getEmail())
                .param("firstName", spitter.getFirstName())
                .param("lastName", spitter.getLastName())
                .param("password", spitter.getPassword())
        ).andExpect(redirectedUrl("/spitter/" + spitter.getLogin()));

        verify(service, times(1)).registerSpitter(spitter);
    }

    @Test
    public void shoudShowRegisterFormWhenHasErrors() throws Exception {
        Spitter spitterWithError = new Spitter(null, "login", "123", "asdxsdfgs@dasfdsf.ru", "fname", "lname", new ArrayList<>());

        mockMvc.perform(post("/spitter/register")
                .param("id", Objects.toString(spitterWithError.getId(), ""))
                .param("login", spitterWithError.getLogin())
                .param("email", spitterWithError.getEmail())
                .param("firstName", spitterWithError.getFirstName())
                .param("lastName", spitterWithError.getLastName())
                .param("password", spitterWithError.getPassword()))
                .andExpect(view().name("registerForm"))
                .andExpect(model().attributeHasErrors("spitter"));

        verify(service, never()).registerSpitter(spitterWithError);
    }

}
