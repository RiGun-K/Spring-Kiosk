package com.example.teamproject.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ordered")
public class Ordered {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderedid;
	@Column(nullable=false)
	private int totalsum;
	@Column
	private LocalDateTime orderedTime;
	@Column(length=10)
	private String payway;
	
	@OneToMany
	@JoinColumn(name = "orderedid")
	private List<O_Detail> details;

	public Ordered() {}
	public Ordered(int orderedid, int totalsum, LocalDateTime orderedTime) {
		this.orderedid = orderedid;
		this.totalsum = totalsum;
		this.orderedTime = orderedTime;
	}
	
	public int getOrderedid() {
		return orderedid;
	}
	public void setOrderedid(int orderedid) {
		this.orderedid = orderedid;
	}
	public int getTotalsum() {
		return totalsum;
	}
	public void setTotalsum(int totalsum) {
		this.totalsum = totalsum;
	}
	public LocalDateTime getOrderedTime() {
		return orderedTime;
	}
	public void setOrderedTime(LocalDateTime orderedTime) {
		this.orderedTime = orderedTime;
	}
	public List<O_Detail> getDetails() {
		return details;
	}
	public void setDetails(List<O_Detail> details) {
		this.details = details;
	}
	public String getPayway() {
		return payway;
	}
	public void setPayway(String payway) {
		this.payway = payway;
	}
	

	
}
