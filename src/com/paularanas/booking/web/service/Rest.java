package com.paularanas.booking.web.service;

import java.util.List;

import com.paularanas.booking.web.travel_pojos.Account;
import com.paularanas.booking.web.travel_pojos.AirlineOffer;
import com.paularanas.booking.web.travel_pojos.AirlineTicket;

public interface Rest {
	
	 AirlineOffer[] getAirlineOffers();
	 
	 Account registerNewPaypallets();
	 
	 Account initialDeposit(String id); 
	 
	 AirlineTicket[] viewPurchasedTickets();
	 
	 AirlineTicket purchaseTickets(String id, long amount, String from, String to);
	 

}
