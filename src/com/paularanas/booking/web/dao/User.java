package com.paularanas.booking.web.dao;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.paularanas.booking.web.validation.constraints.UserEmailValidation;
@Entity
@Table(name ="users")
public class User {
	@Size(min = 7, max = 18)
	@NotBlank
	@Pattern(regexp = "^\\w{8,}$")
	private String username;
	@Size(min = 7, max = 18)
	@NotBlank
	@Pattern(regexp = "^\\w{8,}$")
	private String password;
	@UserEmailValidation
	private String email;
	private boolean enabled;
	@Id
	private String id;
	
	
	public User(String username, String password,boolean enabled , String email, String id) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.id = id;
		this.enabled = enabled;

	}

	public User() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + ", email=" + email + ", enabled=" + enabled
				+ ", id=" + id + "]";
	}




}
