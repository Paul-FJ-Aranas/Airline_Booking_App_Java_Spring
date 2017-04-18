package com.paularanas.booking.web.travel_pojos;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("prototype")
public class Error {
	
	private String message;

	
	public Error() {
		super();
	}

	public Error(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Error [message=" + message + "]";
	}
	
	

}
