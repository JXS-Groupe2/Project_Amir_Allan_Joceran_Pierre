package com.jxwproject;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/users")
public class UsersResource {
	public ArrayList<User> users;

	public UsersResource() {

		users = new ArrayList<User>();
	}
	
	@GET
	@Path("/")
	public String getuserid(@PathParam("email") final String email){
		if (users.contains(email)){
			return String.valueOf(users.indexOf(email));
		}else{
			return null;
		}
	}

	@POST
	@Path("/create")
	public String createUser(@PathParam("email") final String email) {

		users.add(new User(email));

		return "user created";
	}
	
	@POST
	@Path("/{user}/google")
	public String setGoogleToken(@PathParam("user") final String user,@PathParam("token") final String token){
		int userIndex=Integer.getInteger(user);
		if(userIndex>=users.size()){
			return null; 
			//user not found
		}
		users.get(userIndex).setGoogleToken(token);
		
		return "google token added";
	}
	
	@POST
	@Path("/{user}/dropbox")
	public String setDropboxToken(@PathParam("user") final String user,@PathParam("token") final String token){
		int userIndex=Integer.getInteger(user);
		if(userIndex>=users.size()){
			return null; 
			//user not found
		}
		users.get(userIndex).setDropboxToken(token);
		
		return "dropbox token added";
	}
	
	

	@GET
	@Path("/{user}/dropbox")
	public String getGoogleToken(@PathParam("user") final String user){
		int userIndex=Integer.getInteger(user);
		if(userIndex>=users.size()){
			return null; 
			//user not found
		}
		
		return users.get(userIndex).getGoogleToken();
	}
	
	
	
	@GET
	@Path("/{user}/dropbox")
	public String getDropboxToken(@PathParam("user") final String user){
		int userIndex=Integer.getInteger(user);
		if(userIndex>=users.size()){
			return null; 
			//user not found
		}
		
		return users.get(userIndex).getDropboxToken();
	}
	
	

}
