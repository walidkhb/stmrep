package com.stm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 * 
 * 
 * 
 * 
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String index() {
        return "/index";
    }
    @GetMapping("/login")
    public String login() {
        return "/pages-login";
    }
   
}
