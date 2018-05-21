package com.jxwproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("users")
public class UsersResource {
	public ArrayList<User> users;

	public UsersResource() {

		try{
		FileInputStream file = new FileInputStream("users.tmp");
		ObjectInputStream stream = new ObjectInputStream(file);
		users = (ArrayList<User>) stream.readObject();
		stream.close();
		}catch(Exception e){
		users = new ArrayList<User>();
		}
		if(users.size()<=0){
			users = new ArrayList<User>();
		}
	}

	@GET
	@Path("/")
	public String getuserid(@PathParam("email") final String email) {
		if (users.contains(email)) {
			return String.valueOf(users.indexOf(email));
		} else {
			return null;
		}
	}

	@POST
	@Path("/create")
	public String createUser(@PathParam("email") final String email) {

		users.add(new User(email));
		save();
		return "user created";
	}

	@POST
	@Path("/{user}/google")
	public String setGoogleToken(@PathParam("user") final String user, @PathParam("token") final String token) {
		int userIndex = Integer.getInteger(user);
		if (userIndex >= users.size()) {
			return null;
			// user not found
		}
		users.get(userIndex).setGoogleToken(token);
		save();
		return "google token added";
	}

	@POST
	@Path("/{user}/dropbox")
	public String setDropboxToken(@PathParam("user") final String user, @PathParam("token") final String token) {
		int userIndex = Integer.getInteger(user);
		if (userIndex >= users.size()) {
			return null;
			// user not found
		}
		users.get(userIndex).setDropboxToken(token);
		save();

		return "dropbox token added";
	}

	@GET
	@Path("/{user}/google")
	public String getGoogleToken(@PathParam("user") final String user) {
		int userIndex = Integer.getInteger(user);
		if (userIndex >= users.size()) {
			return null;
			// user not found
		}

		return users.get(userIndex).getGoogleToken();
	}

	@GET
	@Path("/{user}/dropbox")
	public String getDropboxToken(@PathParam("user") final String user) {
		int userIndex = Integer.getInteger(user);
		if (userIndex >= users.size()) {
			return null;
			// user not found
		}

		return users.get(userIndex).getDropboxToken();
	}

	private void save() {
		try {
			FileOutputStream file = new FileOutputStream("users.tmp");
			ObjectOutputStream stream = new ObjectOutputStream(file);
			stream.writeObject(users);
			stream.close();
		} catch (IOException e) {
			System.err.println("file error" + e.getMessage());
		}
	}

}
