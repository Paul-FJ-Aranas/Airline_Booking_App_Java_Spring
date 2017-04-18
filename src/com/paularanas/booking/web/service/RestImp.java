package com.paularanas.booking.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paularanas.booking.web.travel_pojos.Account;
import com.paularanas.booking.web.travel_pojos.AccountRequest;
import com.paularanas.booking.web.travel_pojos.AirlineOffer;
import com.paularanas.booking.web.travel_pojos.AirlineRoute;
import com.paularanas.booking.web.travel_pojos.AirlineTicket;
import com.paularanas.booking.web.travel_pojos.Currency;
import com.paularanas.booking.web.travel_pojos.DepositWithdrawalRequest;
import com.paularanas.booking.web.travel_pojos.MonetaryAmount;
import com.paularanas.booking.web.travel_pojos.TicketRequest;

@Component
public class RestImp implements Rest {
	RestOperations operations;
	RestTemplate rest;

	@Override
	public AirlineOffer[] getAirlineOffers() {
		rest = headersAndConverter();
		AirlineOffer[] airOffersArray = rest
				.getForObject("[API URL AND KEY REDACTED]", AirlineOffer[].class);
		return airOffersArray;
	}

	@Override
	public Account registerNewPaypallets() {
		rest = headersAndConverter();
		AccountRequest accountRequest = new AccountRequest(Currency.USD);
		Account newAccountResponse = rest.postForObject("[API URL AND KEY REDACTED]",
				accountRequest, Account.class);
		return newAccountResponse;

	}

	@Override
	public Account initialDeposit(String id) {
		rest = headersAndConverter();
		DepositWithdrawalRequest accountAction = new DepositWithdrawalRequest(id,
				new MonetaryAmount(1000, Currency.USD));
		Account updatedAccountResponse = rest.postForObject(
				"[API URL AND KEY REDACTED]", accountAction, Account.class);
		return updatedAccountResponse;

	}

	@Override
	public AirlineTicket[] viewPurchasedTickets() {
		rest = headersAndConverter();
		AirlineTicket[] airOffersArray = rest
				.getForObject("[API URL AND KEY REDACTED]", AirlineTicket[].class);
		return airOffersArray;
		
	}

	@Override
	public AirlineTicket purchaseTickets(String id, long amount, String from, String to ) {
		rest = headersAndConverter();
		TicketRequest ticketRequest = new TicketRequest(id,amount, new AirlineRoute(from, to));
		AirlineTicket ticketResponse = rest.postForObject(
				"[API URL AND KEY REDACTED]", ticketRequest, AirlineTicket.class);
		return ticketResponse;


	}

	private RestTemplate headersAndConverter() {
		LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("HeaderName", "value");
		headers.add("Content-Type", "application/json");

		ObjectMapper mapper = new ObjectMapper();
		RestTemplate rest = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonMessageConverter.setObjectMapper(mapper);
		messageConverters.add(jsonMessageConverter);
		rest.setMessageConverters(messageConverters);
		return rest;

	}

}
