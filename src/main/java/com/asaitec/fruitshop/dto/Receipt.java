package com.asaitec.fruitshop.dto;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	private List<Purchase> itemsPurchased = new ArrayList<Purchase>();
	private List<Offer> purchases = new ArrayList<Offer>();
	private Double totalPrice;
	
	public List<Purchase> getItemsPurchased() {
		return itemsPurchased;
	}
	public void setItemsPurchased(List<Purchase> itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}
	public List<Offer> getPurchases() {
		return purchases;
	}
	public void setPurchases(List<Offer> purchases) {
		this.purchases = purchases;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	

	

}
