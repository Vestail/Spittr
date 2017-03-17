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
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * @author Vitalii_Vitrenko
 */
public class SpitterControllerTest {

    public static final String SPITTER_REGISTER_ENDPOINT = "/spitter/register";

    private Spitter spitterWithoutError = new Spitter(
            null,
            "login",
            "123456",
            "email@gmail.com",
            "fname",
            "lname",
            new ArrayList<>()
    );

    private Spitter spitterWithErrors = new Spitter(
            null,
            "login",
            "1",
            "badEmail",
            "fname",
            "lname",
            new ArrayList<>()
    );

    private SpitterService service = mock(SpitterService.class);
    private SpitterController controller = new SpitterController(service);
    private MockMvc mockMvc = standaloneSetup(controller).build();

    @Before
    public void startUp() {


    }

    @Test
    public void shoudReturnEmptySpitterWhenRegister() throws Exception {
        mockMvc.perform(get(SPITTER_REGISTER_ENDPOINT))
                .andExpect(view().name("registerForm"))
                .andExpect(model().attributeExists("spitter"))
                .andExpect(model().attribute("spitter", Matchers.hasProperty("id", IsNull.nullValue())));
    }


    @Test
    public void shouldRegisterIfNoFormError() {

    }

    @Test
    public void shouldRedirectAfterRegistration() throws Exception {
        mockMvc.perform(spitterRegisterRequest(spitterWithoutError))
                .andExpect(redirectedUrl("/spitter/" + spitterWithoutError.getLogin()));

        verify(service, times(1)).registerSpitter(spitterWithoutError);
    }


    @Test
    public void shouldShowRegisterFormWhenHasErrors() throws Exception {
        Spitter spitterWithError = new Spitter(null, "login", "123", "asdxsdfgs@dasfdsf.ru", "fname", "lname", new ArrayList<>());

        mockMvc.perform(post("/spitter/register")
                .param("login", spitterWithError.getLogin())
                .param("email", spitterWithError.getEmail())
                .param("firstName", spitterWithError.getFirstName())
                .param("lastName", spitterWithError.getLastName())
                .param("password", spitterWithError.getPassword()))
                .andExpect(view().name("registerForm"))
                .andExpect(model().attributeHasErrors("spitter"));

        verify(service, never()).registerSpitter(spitterWithError);
    }

    public RequestBuilder spitterRegisterRequest(Spitter spitter) {
        return post(SPITTER_REGISTER_ENDPOINT)
                .param("login", spitter.getLogin())
                .param("email", spitter.getEmail())
                .param("firstName", spitter.getFirstName())
                .param("lastName", spitter.getLastName())
                .param("password", spitter.getPassword());
    }

}
