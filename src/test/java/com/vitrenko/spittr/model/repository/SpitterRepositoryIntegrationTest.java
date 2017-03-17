package com.vitrenko.spittr.model.repository;

import com.vitrenko.spittr.config.TestRepositoryConfig;
import com.vitrenko.spittr.model.domain.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestRepositoryConfig.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@Transactional
public class SpitterRepositoryIntegrationTest {


    private final Spitter spitter = new Spitter(
            null,
            "login",
            "123456",
            "email@gmail.com",
            "fname",
            "lname",
            new ArrayList<>()
    );

    private final Spitter spitterWithErrors = new Spitter(
            null,
            "login",
            "1",
            "badEmail",
            "fname",
            "lname",
            new ArrayList<>()
    );

    @Inject
    SpitterRepository spitterRepository;


    @Test
    public void shouldSaveSpitter() {
        Long id = spitterRepository.save(spitter).getId();
        assertTrue(spitterRepository.exists(id));
    }


    @Test
    public void shouldFindByLogin() {
        spitterRepository.save(spitter);
        assertEquals("queried spitter != saved", spitterRepository.findByLogin(spitter.getLogin()), spitter);
    }
    
    @Test
    public void shouldReturnTrueIfSpitterExists() {
        spitter.setLogin("anotherLogin");
        spitter.setEmail("another@mail.com");
        spitterRepository.save(spitter);
        assertTrue(spitterRepository.exists(spitter));
    }

}
