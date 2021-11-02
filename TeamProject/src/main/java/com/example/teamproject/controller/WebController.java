package com.example.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/denied")
	public String denied() {
		return "denied";
	}
	
	@GetMapping("/adduser")
	public String user() {
		return "addUser";
	}
}
