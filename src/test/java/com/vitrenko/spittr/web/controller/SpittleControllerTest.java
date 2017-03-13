package com.vitrenko.spittr.web.controller;

import com.vitrenko.spittr.model.domain.Spittle;
import com.vitrenko.spittr.model.service.SpittleService;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 *
 * @author Vitalii_Vitrenko
 */
public class SpittleControllerTest {

    private final SpittleService spittleService = mock(SpittleService.class);
    List<Spittle> expectedSpittles = new ArrayList<>();
    SpittleController spittleController = new SpittleController(spittleService);
    MockMvc mockMvc = standaloneSetup(spittleController)
            .setSingleView(new InternalResourceView("/WEB-INF/views/spittle.jsp"))
            .build();





}
