package com.example.teamproject.data;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	private String userid;
	@Column(nullable=false, length=100)
	private String password="123";
	@Column
	private LocalDateTime savedTime;
	
	@Column(length=100)
	private String role="admin";
	
	

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public LocalDateTime getSavedTime() {
		return savedTime;
	}
	public void setSavedTime(LocalDateTime savedTime) {
		this.savedTime = savedTime;
	}
	public User() {}
	public User(String userid, String password) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.password = password;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	
}
