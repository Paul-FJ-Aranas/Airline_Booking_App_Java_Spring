package com.paularanas.booking.web.controllers;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestClientException;

import com.paularanas.booking.web.dao.User;
import com.paularanas.booking.web.service.Rest;
import com.paularanas.booking.web.service.UsersService;
import com.paularanas.booking.web.travel_pojos.Account;
import com.paularanas.booking.web.travel_pojos.AirlineOffer;
import com.paularanas.booking.web.travel_pojos.AirlineTicket;

@Controller
public class LoginController {

	private UsersService usersService;
	private Rest rest;
	
	@Autowired
	public void setRestService(Rest rest) {
		this.rest = rest;
	}

	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	

	@RequestMapping("/loggedout")
	public String displayLoggedoutPage() {

		return "loggedout";

	}
	@RequestMapping("/login")
	public String displayLogin(Model model) {
		
		return "login";
	}

	@RequestMapping("/newaccount")
	public String displayNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";

	}
	
	
	@RequestMapping("/airlineoffers")
	public String showOffersUponLogin(Model model) {
		AirlineOffer[] allOffers = rest.getAirlineOffers();
		model.addAttribute("offerArray", allOffers);

		return "airlineoffers";
	}
	
	@RequestMapping("/yourtickets")
	public String showPurchasedTickets(Model model) {
		AirlineTicket[] allTickets = rest.viewPurchasedTickets();
		model.addAttribute("ticketArray", allTickets);
		System.out.println(Arrays.toString(allTickets));
		return "yourtickets";
	}
	
	@RequestMapping("/purchaseticket")
	public String purchaseTickets(Model model) {
		//AirlineTicket purchasedTicket = rest.purchaseTickets(id, amount, from, to)();
		//model.addAttribute("offerArray", purchasedTicket);

		return "purchaseticket";
	}

	@RequestMapping(value = "/establishaccount", method = RequestMethod.POST)
	public String establishAccount( @Valid User user, BindingResult result)
			throws RestClientException, URISyntaxException {

		if (result.hasErrors()) {
			System.out.println("This form fails to validate.");
			List<ObjectError> validationErrors = result.getAllErrors();

			for (ObjectError error : validationErrors) {
				System.out.println(error.getDefaultMessage());
			}
			return "newaccount";
		}
		if (usersService.usernameExists(user.getUsername())) {
			result.rejectValue("username", "KeyDuplicated.user.username", "Username is taken!");
			return "newaccount";
		}
		try {
			//create new Bank Account and save new Account Id in MySql Database
			//with User information
			Account newAcc = rest.registerNewPaypallets();
			String theNewId = newAcc.getId();
			Account afterDepositAccount = rest.initialDeposit(theNewId);
			user.setId(theNewId);
			user.setEnabled(true);;
			// returns the primary key of the new user account to create a
			// Paypaletts Account
			// and deposit $1000
			usersService.createUser(user);

			
		
		} catch (DuplicateKeyException e) {
			result.rejectValue("username", "KeyDuplicated.user.username", "Username is taken!");
			return "newaccount";
		}

		return "accountestablished";
	}
	
		
		

}
