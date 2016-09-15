package com.vitrenko.spittr.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by vitalii on 12.07.16.
 */
@Controller
@RequestMapping({"/", "/home"})
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }


    @RequestMapping(method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> homeJson() {
        Map<String, String> map = new HashMap<>();
        map.put("page", "home");
        map.put("status", "success");
        return map;
    }

}
