package com.paularanas.booking.web.travel_pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class Account {
	
	private MonetaryAmount balance;
	
	private String id;
	
	public Account() {
	}

	@Autowired
	public Account(MonetaryAmount balance, String id) {
		this.balance = balance;
		this.id = id;
	}

	public MonetaryAmount getBalance() {
		return balance;
	}

	public void setBalance(MonetaryAmount balance) {
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", id=" + id + "]";
	}
	
	
	

}
