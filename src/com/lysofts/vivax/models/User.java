package com.lysofts.vivax.models;

import java.io.Serializable;


public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id, username, email, password;
	private boolean is_admin = false;
	
	public User() {}
	

	public User(String username, String email, boolean is_admin) {
		super();
		this.username = username;
		this.email = email;
		this.is_admin = is_admin;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean is_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	
}
