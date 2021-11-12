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

	//  FIRST PAGE
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// CART PAGE
	@GetMapping("/cart")
	public String cart() {
		return "Cart";
	}

	// PAYMENT PAGE
	@GetMapping("/payment")
	public String payment() {
		return "Payment";
	}
	
	///////////////////////////////// 로그인 /////////////////////
	
	@GetMapping("/login")
	public String login() {
		return "AdminLogin";
	}
	
	@GetMapping("/register")
	public String register() {
		return "AdminRegister";
	}
	
	
	
	///////////////////////////////// 관리자 /////////////////////
	
	// MAIN PAGE ( 로그인 이후 )
	@GetMapping("/main")
	public String main() {
		return "AdminMain";
	}
	
	// PRODUCT REGISTER
	@GetMapping("/pregister")
	public String pregister() {
		return "Pregister";
	}
	
	// PRODUCT CHECK
	@GetMapping("/pcheck")
	public String pcheck(Model model) {
		model.addAttribute("menus", menuRepository.findAll());
		return "Pcheck";
	}
	
	// PRODUCT MODIFY
	@GetMapping("/pmodify")
	public String pmodify() {
		return "Pmodify";
	}
	
	// PRODUCT SALES STATS
	@GetMapping("/pstats")
	public String pstats() {
		return "Pstats";
	}
}
