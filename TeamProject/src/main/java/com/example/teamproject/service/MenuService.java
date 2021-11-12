package com.example.teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.data.Menu;
import com.example.teamproject.mapper.MenuMapper;

@Service
public class MenuService {

	@Autowired
	public MenuMapper menuMapper;
	
	public List<Menu> findAllMenu() {
		return menuMapper.findAll();
	}
}
