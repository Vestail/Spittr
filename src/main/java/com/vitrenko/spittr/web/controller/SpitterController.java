package com.vitrenko.spittr.web.controller;

import com.vitrenko.spittr.model.domain.Spitter;
import com.vitrenko.spittr.model.service.SpitterAlreadyExistsException;
import com.vitrenko.spittr.model.service.SpitterService;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        Spitter registeredSpitter = spitterService.registerSpitter(spitter);
        return "redirect:/spitter/" + registeredSpitter.getLogin();
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

    @ExceptionHandler(SpitterAlreadyExistsException.class)
    public ModelAndView spitterExists(SpitterAlreadyExistsException exception) {
        ModelAndView modelView = new ModelAndView("registerForm");
        modelView.getModelMap().addAttribute(exception.getSpitter());
        modelView.getModelMap().addAttribute("loginExists", true);
        return modelView;
    }
}
