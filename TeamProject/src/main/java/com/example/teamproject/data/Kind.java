package com.example.teamproject.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="kind")
public class Kind {

	@Id
	private int kindid;
	@Column(nullable=false)
	private String kindname;
	
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
	
	
}
