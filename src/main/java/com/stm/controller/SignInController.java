package com.stm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {
	
	@RequestMapping("/signin")
	public String signIn() {
		return "signin"; 
	}

}
