/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.web.controller;

import com.vitrenko.spittr.model.service.SpittleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Vitalii_Vitrenko
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private final SpittleService spittleService;

    public SpittleController(SpittleService spitterService) {
        this.spittleService = spitterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spittleService.find());
        return "spittles";
    }

    @RequestMapping(method = RequestMethod.GET, params = {"count"})
    public String spittles(
            @RequestParam(value = "count") int count, 
            @RequestParam(value = "currentPage", defaultValue = "1") int currentPage,
            Model model) {
        int pageCount = (int)Math.ceil((double)spittleService.count() / count);
        model.addAttribute(spittleService.find((currentPage - 1) * count, count));
        model.addAttribute("pageCount", pageCount);
        return "spittles";
    }
}
