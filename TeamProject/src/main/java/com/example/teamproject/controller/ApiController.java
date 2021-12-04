package com.example.teamproject.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.teamproject.repository.MenuRepository;
import com.example.teamproject.repository.UserRepository;
import com.example.teamproject.service.MenuService;
import com.example.teamproject.data.Menu;
import com.example.teamproject.data.Result;
import com.example.teamproject.data.User;




@RestController
@RequestMapping("/api")
@SessionAttributes()
public class ApiController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private MenuService menuService;
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		if(user.getSavedTime()==null)
			user.setSavedTime(LocalDateTime.now());
		userRepository.save(user);
		return user;
	}
	
	
	// 이미지 등록
	@PostMapping("/image/pregister")
	public String uploadFile(Menu menu, Model model, MultipartFile file) throws Exception {
		
		menuService.write(menu, file);
		
		model.addAttribute("searchUrl", "/main");

		return null;
		
	}
	
	// 상품 등록 
	@PostMapping("/pregister")
	public Menu addPregister(@RequestBody Menu menu, @RequestParam File filename) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		if(menu.getSavedTime()==null)
			menu.setSavedTime(LocalDateTime.now());
		menuRepository.save(menu);
		return menu;
	}
	
	
	@PostMapping("/login")
	public Result loginUser(@RequestBody User user) {
		Optional<User> searchedMember = userRepository.findById(user.getUserid());
		if(searchedMember.isPresent()) {
			// 객체끼리 값을 비교 ( 비밀번호가 같은지 )
			if(searchedMember.get().getPassword().equals(user.getPassword())) {
				return new Result("ok");
			} else { // 비번 틀림.
				return new Result("ng");
			}
			
		} else { // 등록되지 않은 사용자.
				return new Result("ng");
		}
		
	}
	
	
	// PRODUCT DELETE ( 삭제 )
		@DeleteMapping("/delete")
		   public Menu deletePregister(@RequestBody Menu menu) {
		      
		      System.out.println();
		      
		      Optional<Menu> m = menuRepository.findById(menu.getMenuid());
		      System.out.println(m);

		      if (m.isPresent()) {      
		         menuRepository.deleteById(m.get().getMenuid());      
		      } 
		      return menu;
		   }

		// PRODUCT MODIFY ( 수정 )
		@PutMapping("/modify")
		   public Menu modifyPregister(@RequestBody Menu menu) {
		      
		      Optional<Menu> searchedMenu = menuRepository.findById(menu.getMenuid());
		      System.out.println(menu.getMenuname());
		      // 메뉴가 존재하는 경우.
		      
		      searchedMenu.get().setMenuname(menu.getMenuname());
		      searchedMenu.get().setKind(menu.getKind());
		      searchedMenu.get().setPrice(menu.getPrice());
		      searchedMenu.get().setStock(menu.getStock());
		      searchedMenu.get().setEx(menu.getEx());
		      menuRepository.save(menu);
		      
		      return menu;
		   }

}
