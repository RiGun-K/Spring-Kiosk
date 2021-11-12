package com.example.teamproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.teamproject.repository.MenuRepository;
import com.example.teamproject.repository.UserRepository;
import com.example.teamproject.data.Menu;
import com.example.teamproject.mapper.MenuMapper;

@Controller
public class WebController {
	

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	MenuRepository menuRepository;

	
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
	
	///////////////////////////////// 관리자 /////////////////////
	
	@GetMapping("/pcheck")
	public String pcheck(Model model) {
		model.addAttribute("menus", menuRepository.findAll());
		return "Pcheck";
	}
}
