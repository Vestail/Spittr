package com.vitrenko.spittr.web.controller;

import com.vitrenko.spittr.model.domain.Spittle;
import com.vitrenko.spittr.model.service.SpittleService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.matchers.JUnitMatchers.hasItems;
import static org.mockito.Mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 *
 * @author Vitalii_Vitrenko
 */
public class SpittleControllerTest {

    private final SpittleService spittleService = mock(SpittleService.class);
    List<Spittle> expectedSpittles = new ArrayList<>();
    SpittleController spittleController = new SpittleController(spittleService);
    MockMvc mockMvc = standaloneSetup(spittleController)
            .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
            .build();

    @Test
    public void shouldReturnSpittleList() throws Exception {
        int size = 10;
        initSpittleList(size);
        when(spittleService.find()).thenReturn(expectedSpittles);

        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    @Test
    public void shouldReturnPagedSpittleList() throws Exception {
        int count = 10;
        int start = 0;
        initSpittleList(count);
        when(spittleService.find(start, count)).thenReturn(expectedSpittles);

        mockMvc.perform(get("/spittles?count=" + count))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    private void initSpittleList(int count) {
        for (int i = 1; i <= count; i++) {
            expectedSpittles.add(new Spittle(i, Integer.toString(i), LocalDate.now()));
        }
    }

}
