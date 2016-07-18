package com.vitrenko.spittr.web.controller;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.service.SpitterService;
import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private final SpitterService spitterService;

    @Inject
    public SpitterController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@Valid Spitter spitter, BindingResult errors, Model model) {
        model.addAttribute(spitter);
        if (errors.hasErrors()) {
            return "registerForm";
        }
        try {
            spitterService.registerSpitter(spitter);
        } catch (DataIntegrityViolationException ex) {
            errors.addError(new ObjectError("spitter", "user with login " + spitter.getLogin() + " already exists"));
            return "registerForm";
        }
        return "redirect:/spitter/" + spitter.getLogin();
    }

    @RequestMapping(value = "/{login}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable("login") String login, Model model) {
        Spitter spitter = spitterService.findByLogin(login);
        if (spitter == null) {
            return "profileNotFound";
        }
        model.addAttribute("spitter", spitter);
        return "profile";
    }
}
