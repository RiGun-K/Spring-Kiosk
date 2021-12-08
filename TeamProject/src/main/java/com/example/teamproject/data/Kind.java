package com.example.teamproject.data;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="kind")
public class Kind {

	@Id
	private int kindid;
	@Column(nullable=false)
	private String kindname;
	
	@JsonManagedReference
	@OneToMany
	@JoinColumn(name = "kind")
	private List<Menu> menus;
	
	public Kind() {}
	public Kind(int kindid, String kindname) {
		this.kindid = kindid;
		this.kindname = kindname;
	}
	
	public int getKindid() {
		return kindid;
	}
	public void setKindid(int kindid) {
		this.kindid = kindid;
	}
	public String getKindname() {
		return kindname;
	}
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	

	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	
}
