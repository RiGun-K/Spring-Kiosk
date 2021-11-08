package com.example.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	
	@GetMapping("/denied")
	public String denied() {
		return "denied";
	}
	
	@GetMapping("/adduser")
	public String user() {
		return "addUser";
	}
	

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "AdministratorLogin";
	}
	
	@GetMapping("/register")
	public String register() {
		return "AdministratorRegister";
	}
	
	
}
