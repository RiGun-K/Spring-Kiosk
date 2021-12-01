package com.example.teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teamproject.data.Menu;
import com.example.teamproject.mapper.MenuMapper;

@Service
public interface MenuService {

	// 메뉴 테이블 리스트로 모두 조회
	public Iterable<Menu> findAll();
	// List => Iterable 로 수정
	
	// PK 조회 
	public Menu find(int menuid);
}
 