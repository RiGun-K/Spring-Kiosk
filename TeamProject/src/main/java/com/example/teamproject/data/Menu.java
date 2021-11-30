package com.example.teamproject.data;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author RiGun
 *
 */

// DTO 기능 ( DB의 특정 테이블의 정보를 정의 ) 

@Entity
@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	// 우선 자동으로 등록되도록 설정했음  
	private int menuid;
	
	@Column(nullable=false)
	private String menuname;
	private int price;
	private String image;
	private String ex;
	private Integer stock;
	private LocalDateTime savedTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kind")
	private Kind kind;
	
	// 생성자 우선 생략
	// kindid(기본키) 와 맵핑해야됨. 
	
	public LocalDateTime getSavedTime() {
		return savedTime;
	}
	public void setSavedTime(LocalDateTime savedTime) {
		this.savedTime = savedTime;
	}
	public Menu(){}
	public Menu(int menuid, String menuname, int price, String image, String ex, Kind kind, int stock) {
		this.menuid = menuid;
		this.menuname = menuname;
		this.price = price;
		this.image = image;
		this.ex = ex;
		this.stock = stock;
		this.kind = kind;

	}
	
	public int getMenuid() {
		return menuid;
	}
	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getEx() {
		return ex;
	}
	public void setEx(String ex) {
		this.ex = ex;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	

	
	////////////////////////
	
	
	
}
