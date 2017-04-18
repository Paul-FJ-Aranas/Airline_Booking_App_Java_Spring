package com.paularanas.booking.web.travel_pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class AirlineOffer {
	
	private MonetaryAmount price;
	
	private AirlineRoute route;

	public AirlineOffer() {
		super();
	}

	public AirlineOffer(MonetaryAmount price, AirlineRoute route) {
		this.price = price;
		this.route = route;
	}

	public MonetaryAmount getPrice() {
		return price;
	}

	public void setPrice(MonetaryAmount price) {
		this.price = price;
	}

	public AirlineRoute getRoute() {
		return route;
	}

	public void setRoute(AirlineRoute route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "AirlineOffer [price=" + price + ", route=" + route + "]";
	}
	
	

}
