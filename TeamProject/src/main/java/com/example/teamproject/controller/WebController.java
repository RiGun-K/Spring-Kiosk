package com.example.teamproject.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.teamproject.repository.MenuRepository;
import com.example.teamproject.repository.UserRepository;

import com.example.teamproject.data.Menu;
import com.example.teamproject.mapper.MenuMapper;

@Controller
@SessionAttributes("cart")	// ModelAttribute("cart")를 찾는다.
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
	
	// PRACTICE PAGE
	@GetMapping("/index")
	public String index2(Model model) {
		model.addAttribute("menus", menuRepository.findAll());
		return "index2";
	}
	
	
	
	
	// CART PAGE
	@GetMapping("/cart")
	@ModelAttribute("cart")
	public String cart(HttpServletRequest request, Model model, HttpSession session) throws Exception {
		
		// 여기에 '담기' 버튼을 클릭한 정보 ( 상품수량,명 등 ) 이 담겨야 함 ! 
		model.addAttribute("menus", menuRepository.findAll());
		
		// 세션 선언
		session = request.getSession();
		// session 저장( 값 부여 )
//		session.setAttribute("저장하고자 하는 변수이름", 저장 변수값);
		session.setAttribute("cart", "menus");
		// session 가져오기 ( 조회 ) 
		String userid = (String)session.getAttribute("cart");
		System.out.println(userid);
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
	@GetMapping("/pcheck/{menuid}")
	public String getMenu(@PathVariable("menuid") int menuid, Model model) {
		// 주소창의 menuid 값이 <Menu> 에 있는가 
		Optional<Menu> searchedPost = menuRepository.findById(menuid);
		if(searchedPost.isPresent()) {
			model.addAttribute("menuid", searchedPost.get());
		}
		return "Pmodify";
	}
	
	
	// PRODUCT SALES STATS
	@GetMapping("/pstats")
	public String pstats() {
		return "Pstats";
	}
}
