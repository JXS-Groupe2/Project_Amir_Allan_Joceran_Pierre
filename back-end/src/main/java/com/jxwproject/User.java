package com.jxwproject;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email,password;
	private String googleToken, dropboxToken;
	private String id=null;

	public User(String email,String password) {

		this.email = email;
		this.setPassword(password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGoogleToken() {
		return googleToken;
	}

	public void setGoogleToken(String googleToken) {
		this.googleToken = googleToken;
	}

	public String getDropboxToken() {
		return dropboxToken;
	}

	public void setDropboxToken(String dropboxToken) {
		this.dropboxToken = dropboxToken;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", password=" + password + ", googleToken=" + googleToken + ", dropboxToken="
				+ dropboxToken + ", id=" + id + "]";
	}
	
}
