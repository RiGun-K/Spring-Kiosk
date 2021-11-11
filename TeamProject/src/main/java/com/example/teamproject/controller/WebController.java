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
	
	@GetMapping("/cart")
	public String cart() {
		return "Cart";
	}
	
	@GetMapping("/login")
	public String login() {
		return "AdminLogin";
	}
	
	@GetMapping("/register")
	public String register() {
		return "AdminRegister";
	}
	
	@GetMapping("/main")
	public String main() {
		return "AdminMain";
	}
	
	
}
