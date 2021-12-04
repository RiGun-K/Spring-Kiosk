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
	private Object password;
	@Column
	private LocalDateTime savedTime;
	

	public LocalDateTime getSavedTime() {
		return savedTime;
	}
	public void setSavedTime(LocalDateTime savedTime) {
		this.savedTime = savedTime;
	}
	public User() {}
	public User(String userid, Object password) {
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
	public Object getPassword() {
		return password;
	}
	public void setPassword(Object password) {
		this.password = password;
	}
	

	
	
	
}
