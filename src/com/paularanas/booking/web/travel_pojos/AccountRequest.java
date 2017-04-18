package com.paularanas.booking.web.travel_pojos;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.paularanas.booking.web.travel_pojos.Currency;
@Component
@Scope("prototype")
public class AccountRequest {
	
	
	public AccountRequest() {
	}

	private Currency currency;

	public AccountRequest(Currency currency) {
		this.currency = currency;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency Currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "AccountRequest [currency=" + currency + "]";
	}
	
	

}
