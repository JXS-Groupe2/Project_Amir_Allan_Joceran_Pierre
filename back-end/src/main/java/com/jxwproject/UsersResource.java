package com.jxwproject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("users")
public class UsersResource {
	public static ArrayList<User> users;

	public UsersResource() {
		/*
		try {
			FileInputStream file = new FileInputStream("users.tmp");
			ObjectInputStream stream = new ObjectInputStream(file);
			users = (ArrayList<User>) stream.readObject();
			stream.close();
			// System.out.println("uploaded"+users.size());
		} catch (Exception e) {
			users = new ArrayList<User>();
			System.out.println("new file");
		}
		*/
		// TODO A MODIFIER
		users = new ArrayList<User>();
		
		users.add(new User("admin"));
		users.add(new User("user@example.com"));
	}

	@GET
	@Path("/user")
	public String getuserid(@QueryParam("email") final String email, @QueryParam("password") final String password) {
		for (User user : users) {
			if (user.getEmail().equals(email)) {
				if (user.getPassword().equals(password)) {
					String uniqueID = UUID.randomUUID().toString();
					user.setId(uniqueID);
					save();
					return uniqueID;
				}
			}
		}
		return null;

	}

	@POST
	@Path("/create")
	public String createUser(@QueryParam("email") final String email, @QueryParam("password") final String password) {

		for (User user : users) {
			if (user.getEmail().equals(email)) {
				return null;
			}
		}
		users.add(new User(email, password));
		save();

		return "user created";
	}

	@POST
	@Path("/{user}/google")
	public String setGoogleToken(@PathParam("user") final String id, @QueryParam("token") final String token) {
		
		
		if(userById(id)<0){
			return null;
		}
		
		users.get(userById(id)).setGoogleToken(token);
		save();
		return "google token added";
	}

	@POST
	@Path("/{user}/dropbox")
	public String setDropboxToken(@PathParam("user") final String id, @QueryParam("token") final String token) {

		if(userById(id)<0){
			return null;
		}
		users.get(userById(id)).setDropboxToken(token);
		save();
		return "dropbox token added";
	}

	@GET
	@Path("/{user}/google")
	public String getGoogleToken(@PathParam("user") final String id) {

		
		if(userById(id)<0){
			return null;
		}

		return users.get(userById(id)).getGoogleToken();
	}

	@GET
	@Path("/{user}/dropbox")
	public String getDropboxToken(@PathParam("user") final String id) {

		if(userById(id)<0){
			return null;
		}

		return users.get(userById(id)).getDropboxToken();
	}

	
	public User getUser(int index){
		return users.get(index);
	}
	
	
	private int userById(String id){
		for (User user : users) {
			if((user.getId()!=null)&&(user.getId().equals(id))){
				return users.indexOf(user);
			}
			
		}
		
		return -1;
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
