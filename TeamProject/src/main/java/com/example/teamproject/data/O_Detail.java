package com.example.teamproject.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="o_detail")
public class O_Detail {
	@Id
	private String orderdetailid;
	
	@Column(nullable = false)
	private int amount;
	
	@ManyToOne(targetEntity = Menu.class)
	@JoinColumn(nullable = false,  name="menuid")
	private Menu menuid;
	
	public Menu getMenuid() {
		return menuid;
	}

	public void setMenuid(Menu menuid) {
		this.menuid = menuid;
	}

	public Ordered getOrderedid() {
		return orderedid;
	}

	public void setOrderedid(Ordered orderedid) {
		this.orderedid = orderedid;
	}

	@ManyToOne(targetEntity = Ordered.class)
	@JoinColumn(nullable = false,  name="orderedid")
	private Ordered orderedid;

	public String getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}