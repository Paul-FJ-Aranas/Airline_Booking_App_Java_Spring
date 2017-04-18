package com.paularanas.booking.web.travel_pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class AirlineTicket {
	
	private long amount;
	
	private AirlineOffer details;

	public AirlineTicket(long amount, AirlineOffer details) {
		super();
		this.amount = amount;
		this.details = details;
	}

	public AirlineTicket() {
		super();
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public AirlineOffer getDetails() {
		return details;
	}

	public void setDetails(AirlineOffer details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "AirlineTicket [amount=" + amount + ", details=" + details + "]";
	}
	
	

}
