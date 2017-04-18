package com.paularanas.booking.web.travel_pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class AirlineRoute {
	
	private String from;
	
	private String to;

	public AirlineRoute() {
		super();
	}

	public AirlineRoute(String from, String to) {
		super();
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	@Override
	public String toString() {
		return "AirlineRoute [from=" + from + ", to=" + to + "]";
	}
	
	

}
