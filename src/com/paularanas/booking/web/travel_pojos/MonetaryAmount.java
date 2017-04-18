package com.paularanas.booking.web.travel_pojos;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.paularanas.booking.web.travel_pojos.Currency;

@Component 
@Scope("prototype")
public class MonetaryAmount {
	
	private int amount;
	private Currency currency;

	public MonetaryAmount() {
	}

	public MonetaryAmount(int amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "MonetaryAmount [amount=" + amount + ", currency=" + currency + "]";
	}
	
	

}
