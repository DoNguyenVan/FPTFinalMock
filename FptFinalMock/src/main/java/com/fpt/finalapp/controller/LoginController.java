package com.fpt.finalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	@RequestMapping(value={"/","/login"})
	public String showHome() {
		return "login";
	}
	
	@RequestMapping("/loginsuccess")
	public String hienThongKe() {
		return "redirect:/home";
	}

	@RequestMapping(value="/home")
	public String showThongKe() {
		return "home";
	}
}
