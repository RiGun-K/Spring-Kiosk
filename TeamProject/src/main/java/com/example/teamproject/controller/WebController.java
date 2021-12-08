package com.example.teamproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.teamproject.repository.KindRepository;
import com.example.teamproject.repository.MenuRepository;
import com.example.teamproject.repository.OrderedRepository;
import com.example.teamproject.repository.UserRepository;
import com.example.teamproject.data.Menu;


@Controller
public class WebController {
	

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	MenuRepository menuRepository;
	
	@Autowired
	KindRepository kindRepository;
	
	@Autowired
	OrderedRepository orderedRepository;

	//  FIRST PAGE
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("menus", menuRepository.findAll());
		model.addAttribute("kind", kindRepository.findAll());
	//    model.addAttribute("menus", menuService.findAll());
		return "index";
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
	public String pregister(Model model) {
		model.addAttribute("kind", kindRepository.findAll());
		return "Pregister";
	}
	
	   // PRODUCT CHECK
	   @GetMapping("/pcheck")
	   public String pcheck(Model model) {
	      model.addAttribute("menus", menuRepository.findAll());
	      return "Pcheck";
	   }
	   
	   // PRODUCT MODIFY
	   @GetMapping("/pcheck/{menuid}")
	   public String getMenu(@PathVariable("menuid") int menuid, Model model) {
	      // 주소창의 postId 값이 <Post> 에 있는가 
	      Optional<Menu> searchedMenu = menuRepository.findById(menuid);
	      	 model.addAttribute("kind", kindRepository.findAll());
	         model.addAttribute("menu", searchedMenu.get());
	      
	      return "Pmodify";
	   }
	   
	
	// PRODUCT MODIFY
	@GetMapping("/pmodify")
	public String pmodify() {
		return "Pmodify";
	}
	
	// PRODUCT SALES STATS
		@GetMapping("/pstats")
		public String pstats(Model model) {

			model.addAttribute("ordered", orderedRepository.findAll());
			return "Pstats";
		}
}
