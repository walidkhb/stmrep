package com.stm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String index() {
        return "redirect:/agentes";
    }
    @GetMapping("/login")
    public String login() {
        return "/login2";
    }
    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
