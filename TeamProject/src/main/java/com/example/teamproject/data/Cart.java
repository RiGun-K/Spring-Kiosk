package com.example.teamproject.data;

public class Cart {

	// 메뉴 테이블
	private Menu menu;
	private int quantity;
	
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Source -> Generate Constructor using Fields...
	public Cart(Menu menu, int quantity) {
		super();
		this.menu = menu;
		this.quantity = quantity;
	}
	
	
}
