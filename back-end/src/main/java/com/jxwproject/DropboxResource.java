package com.jxwproject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("dropbox")
public class DropboxResource {

	//Token de test : à changer tout le temps
	private final static String OAUTH_KEY = "G7zoVR0rS5oAAAAAAAAN3f44uMBN1VRhjxMGZitWB7BBpEAic4un8gf_lJ_mbwaK";
	HttpsURLConnection connection = null;
	
	/** Get account info
	 * 
	 * 
	 * @return JSON with will be return as text
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	//@Path("infos")
	public String getUserAccountInfos() {
		try {
			Client client = Client.create();
			WebResource webRessource = client.resource("https://api.dropboxapi.com/2/users/get_current_account");
			
			ClientResponse response = webRessource.header("Authorization", "Bearer "+OAUTH_KEY)
					.accept("application/plain;charset=dropbox-cors-hack")
					.post(ClientResponse.class);
		    
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			return output;
	  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
	  } finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
	  }
	}
}
