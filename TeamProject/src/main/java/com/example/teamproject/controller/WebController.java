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
	

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/Login")
	public String login() {
		return "AdministratorMain";
	}
	
	
}
