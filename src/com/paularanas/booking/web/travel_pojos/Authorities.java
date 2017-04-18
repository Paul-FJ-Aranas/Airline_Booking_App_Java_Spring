package com.paularanas.booking.web.travel_pojos;

public class Authorities {
private String authority;
private String username;

	public Authorities() {
		// TODO Auto-generated constructor stub
	}

	public Authorities(String authority, String username) {
		super();
		this.authority = authority;
		this.username = username;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Authorities [authority=" + authority + ", username=" + username + "]";
	}

}
