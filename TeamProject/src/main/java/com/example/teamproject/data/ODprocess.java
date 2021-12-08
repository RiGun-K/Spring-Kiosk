package com.example.teamproject.data;

import java.time.LocalDateTime;

public class ODprocess {
	private int[] basket;
	private int[] bamount;
	private int sum;
	private LocalDateTime time;
	private String pay;
	
	public ODprocess() {
		
	}

	

	public LocalDateTime getTime() {
		return time;
	}



	public void setTime(LocalDateTime time) {
		this.time = time;
	}



	public int[] getBasket() {
		return basket;
	}



	public void setBasket(int[] basket) {
		this.basket = basket;
	}



	public int[] getBamount() {
		return bamount;
	}



	public void setBamount(int[] bamount) {
		this.bamount = bamount;
	}



	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}



	public String getPay() {
		return pay;
	}



	public void setPay(String pay) {
		this.pay = pay;
	}
	
	
}
