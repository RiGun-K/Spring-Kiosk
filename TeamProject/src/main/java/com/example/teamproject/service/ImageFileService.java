package com.example.teamproject.service;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.teamproject.data.ImageFile;
import com.example.teamproject.repository.ImageFileRepository;

@Service
public class ImageFileService {
	
	@Autowired
	private ImageFileRepository imagefileRepository;
	
	public void write(ImageFile imagefile, MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\images";
		 
		UUID uuid = UUID.randomUUID();
		
		String fileName = uuid + "_" + file.getOriginalFilename();
		
		File saveFile = new File(projectPath, fileName);
		
		file.transferTo(saveFile);
		
		imagefile.setFilename(fileName);
		imagefile.setFilepath("/images/" + fileName);
		
		
		imagefileRepository.save(imagefile);
	}
}
