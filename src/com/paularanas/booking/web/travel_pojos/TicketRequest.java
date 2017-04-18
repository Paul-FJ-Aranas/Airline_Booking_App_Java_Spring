package com.paularanas.booking.web.travel_pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class TicketRequest {
	
	private String accountId;
	private long amount;
	private AirlineRoute route;
	
	public TicketRequest() {
		super();
	}
	@Autowired
	public TicketRequest(String accountId, long amount, AirlineRoute route) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.route = route;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public AirlineRoute getRoute() {
		return route;
	}
	public void setRoute(AirlineRoute route) {
		this.route = route;
	}
	@Override
	public String toString() {
		return "TicketRequest [accountId=" + accountId + ", amount=" + amount + ", route=" + route + "]";
	}
	
	

}
