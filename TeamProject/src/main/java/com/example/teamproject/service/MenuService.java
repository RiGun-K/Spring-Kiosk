package com.example.teamproject.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.teamproject.data.Menu;
import com.example.teamproject.repository.MenuRepository;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;
	
	public void write(Menu menu, MultipartFile filename) throws Exception {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";
		 
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid + "_" + filename.getOriginalFilename();
		
		File saveFile = new File(projectPath, fileName);
		
		filename.transferTo(saveFile);
		
		menu.setFilename(fileName);
		menu.setFilepath("/images/" + fileName);
		
		if(menu.getSavedTime()==null)
			menu.setSavedTime(LocalDateTime.now());
		
		
		menuRepository.save(menu);
	}
}
 