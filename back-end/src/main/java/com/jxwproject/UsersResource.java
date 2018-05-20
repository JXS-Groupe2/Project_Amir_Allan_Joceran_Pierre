package com.jxwproject;

import java.util.HashMap;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/user")
public class UsersResource {
	public HashMap<String, String> users;

	public UsersResource() {

		users = new HashMap<String, String>();
	}

	@Path("/create")
	public String createUser(@PathParam("file") final String email, @PathParam("file") final String password) {

		if (users.containsKey(email)){
			
		}

			return null;
	}

}
