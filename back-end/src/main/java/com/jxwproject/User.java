package com.jxwproject;

import java.io.Serializable;

public class User implements Serializable {
	
	private String email;
	private String googleToken,dropboxToken;

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

	public User(String email) {

		this.email=email;
	}

	

}
