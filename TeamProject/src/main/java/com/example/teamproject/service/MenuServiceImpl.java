package com.example.teamproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.* ;

import com.example.teamproject.data.Menu;
import com.example.teamproject.repository.MenuRepository;

@Service("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public Iterable<Menu> findAll() {
		// TODO Auto-generated method stub
		return menuRepository.findAll();
	}

	@Override
	public Menu find(int menuid) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Menu find(int menuid) {
//		// TODO Auto-generated method stub
//		return menuRepository.findById(menuid);
//	}

}
