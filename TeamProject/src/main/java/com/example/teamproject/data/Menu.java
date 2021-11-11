package com.example.teamproject.data;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author RiGun
 *
 */
@Entity
@Table(name="menu")
public class Menu {

	@Id
	private int menuid;
	@Column(nullable=false)
	private String menuname;
	private int price;
	private Blob image;
	private String ex;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "kind")
	private Kind kind;
	
	// 생성자 우선 생략
	// kindid(기본키) 와 맵핑해야됨. 
	
	public int getMenuid() {
		return menuid;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
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
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public String getEx() {
		return ex;
	}
	public void setEx(String ex) {
		this.ex = ex;
	}
	
	
	
}
