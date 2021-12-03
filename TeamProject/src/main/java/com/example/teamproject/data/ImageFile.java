package com.example.teamproject.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="imagefile")
public class ImageFile {

	
	@Id
	private String filename;
	
	@Column(nullable=false)
	private String filepath;
	
	
	public ImageFile(){}
	public ImageFile(String filename, String filepath) {
		this.filename = filename;
		this.filepath = filepath;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}
