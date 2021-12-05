package com.example.teamproject.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.example.teamproject.repository.KindRepository;
import com.example.teamproject.repository.MenuRepository;
import com.example.teamproject.repository.UserRepository;
import com.example.teamproject.service.MenuService;
import com.example.teamproject.data.Cart;
import com.example.teamproject.data.Kind;
import com.example.teamproject.data.Menu;
import com.example.teamproject.mapper.MenuMapper;

@Controller
//@SessionAttributes("cart")	// ModelAttribute("cart")를 찾는다.
public class WebController {
	

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	MenuRepository menuRepository;
	
	@Autowired
	KindRepository kindRepository;
	
	@Autowired
	MenuService menuService;
	
	

	//  FIRST PAGE
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	// PRACTICE PAGE
	@GetMapping("/index")
	public String index2(Model model) {
		
		// 둘다 동일하게 메뉴 테이블의 칼럼들을 다 가져옴 
		model.addAttribute("menus", menuRepository.findAll());


		return "index2";
	}
	
	
	
	@GetMapping("/indexcart")
	public String indexcart() {
		return "indexcart";
	}
	
	
	
	
	
	// CART PAGE
//	@GetMapping("/cart")
//	@ModelAttribute("cart")
//	public String cart(HttpServletRequest request, Model model, HttpSession session) throws Exception {
//		
//		// 여기에 '담기' 버튼을 클릭한 정보 ( 상품수량,명 등 ) 이 담겨야 함 ! 
//		model.addAttribute("menus", menuRepository.findAll());
//		
//		// 세션 선언
//		session = request.getSession();
//		// session 저장( 값 부여 )
////		session.setAttribute("저장하고자 하는 변수이름", 저장 변수값);
//		session.setAttribute("cart", "menus");
//		// session 가져오기 ( 조회 ) 
//		String userid = (String)session.getAttribute("cart");
//		System.out.println(userid);
//		return "Cart";
//	}

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
	
	@GetMapping("/denied")
	public String denied() {
		return "denied";
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
		// html 내 kind 값들을 조회하려면 GET 방식으로 봐야됨 
		model.addAttribute("kind", kindRepository.findAll());
		return "Pregister";
	}
	
//	@PostMapping("/image/main")
//	public Menu menuWritePro(@RequestBody Menu menu, Menu menus, Model model, @RequestParam("filename") MultipartFile filename) throws Exception {
//		menuService.write(menu, filename);
//		
////		model.addAttribute("message", "사진 등록완료");
////		model.addAttribute("searchUrl", "/pregister");
//		
//		return menu;
//	}
	
	
	@PostMapping("/pregister")
	public Menu addPregister(Menu menu, @RequestParam(name="kind") Kind kind,
			@RequestParam(name="menuname") String menuname,
			@RequestParam(name="price") int price,
			@RequestParam(name="stock") int stock,
			@RequestParam(name="ex") String ex,
			@RequestParam(name="filename") MultipartFile file, 
			Model model) throws Exception {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert 
		
		
		
		
		menuService.write(menu, kind, menuname, price, stock, ex, file);
		return menu;
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
	
	
	// PRODUCT SALES STATS
	@GetMapping("/pstats")
	public String pstats() {
		return "Pstats";
	}
}
