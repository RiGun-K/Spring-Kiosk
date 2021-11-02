package com.example.teamproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.teamproject.repository.UserRepository;
import com.example.teamproject.data.User;


public class ApiController {
	
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		// 추후 DB 코드 추가 = 아이디,이름 값이 저장버튼으로 넘어온 데이터를 받아서 DB에 Insert
		userRepository.save(user);
		return user;
	}

}
