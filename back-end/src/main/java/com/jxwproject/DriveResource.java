package com.jxwproject;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("drive")
public class DriveResource {

	private String token = "ya29.GlunBaLLvdUHAT-07EKRLbEb9AhgnpmhendcL6hdzTNald9rUWxlWMcdcyjSx8e0t8JTkGx-02VvOLaoHbk_ku4xQ3_nEMI_uH5QcPBKGVq5rkQQV4_MlJeasVhl";
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("files")
	public String getFilesList() {

		try {

			Client client = Client.create();
			WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/files");

			ClientResponse response = null;
			response = webResource.header("Content-Type", "application/json;charset=UTF-8")
					.header("Authorization", "Bearer " + token).get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}
			String output = response.getEntity(String.class);

			return output;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
	
	
}
