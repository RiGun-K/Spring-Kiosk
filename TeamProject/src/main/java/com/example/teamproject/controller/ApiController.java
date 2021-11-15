package com.example.teamproject.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.teamproject.repository.MenuRepository;
import com.example.teamproject.repository.UserRepository;
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
	
	@PostMapping("/register")
	public User addUser(@RequestBody User user) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		if(user.getSavedTime()==null)
			user.setSavedTime(LocalDateTime.now());
		userRepository.save(user);
		return user;
	}
	
	@PostMapping("/pregister")
	public Menu addPregister(@RequestBody Menu menu) {
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

}
