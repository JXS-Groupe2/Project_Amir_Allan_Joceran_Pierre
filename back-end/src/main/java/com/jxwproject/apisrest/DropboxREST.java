package com.jxwproject.apisrest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.ClientConfig;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jxwproject.fichiers.dropbox.DropboxFileRessource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DropboxREST{

	public DropboxREST() {
		
	}
	
	
	/** Get account info
	 * 
	 * 
	 * @return JSON with infos will be return as text
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getUserAccountInfos(String token) {
			Client client = Client.create();
			WebResource webRessource = client.resource("https://api.dropboxapi.com/2/users/get_current_account");
			
			ClientResponse response = webRessource.header("Authorization", "Bearer "+token)
					.accept("application/plain;charset=dropbox-cors-hack")
	
					.post(ClientResponse.class);
		    
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			return output;
	}
	
	/**
	 * Get File MetaData
	 * 
	 * @return the metadata of the file, for now in string format in the browser
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public DropboxFileRessource getFileMetadata(String token, String filepath) {
		String finalPath;
		finalPath = "/"+filepath;
		
		final String params = "\r\n{\r\n\"path\" : \""+finalPath+"\", \r\n\"include_media_info\": false,\r\n\"include_deleted\": false,\r\n\"include_has_explicit_shared_members\": false}";
		ClientConfig config = new ClientConfig();
		javax.ws.rs.client.Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("https://api.dropboxapi.com/2/")
											.path("files/get_metadata");
		Response response = target.request()
				.header("Authorization", "Bearer "+token)

				.header("Content-Type", "application/plain;charset=dropbox-cors-hack")
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(params, MediaType.APPLICATION_JSON), Response.class);
		
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus() + "\n" + response.getHeaders() + "\n" +response.readEntity(String.class)+ "\n");
		}

		String output = response.readEntity(String.class);
		
		Gson gson = new Gson();
		
		DropboxFileRessource dpf = gson.fromJson(output, DropboxFileRessource.class);
		
		return dpf;
		
	}
	
	/** Open a file in browser from dropbox with file path
	 * 
	 * 
	 * @return the content of the file
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String openFile(String token, String filePath) {
		String fileExtension = FilenameUtils.getExtension(filePath);
		String fileName = FilenameUtils.getBaseName(filePath);
		Client client = Client.create();
		WebResource webRessource = client.resource("https://content.dropboxapi.com/2/files/download");
		
		ClientResponse response = webRessource.header("Authorization", "Bearer "+token)
				.header("Dropbox-API-Arg", "{\"path\" : \"/"+filePath+"\"}")

				.accept("application/plain;charset=dropbox-cors-hack")
				.post(ClientResponse.class);
	    
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}

		String output = response.getEntity(String.class);
		
		return output;
	}
	
	/**
	 * List of content from a path
	 * 
	 * @return JSON File of the content of the folder
	 */
	public List<DropboxFileRessource> getContent(String token) {

		final String params = "\r\n{\r\n\"path\" : \"\", \r\n\"recursive\": false,\"include_media_info\": false,\r\n\"include_deleted\": false,\r\n\"include_has_explicit_shared_members\": false,\r\n\"include_mounted_folders\": true}";
		
		ClientConfig config = new ClientConfig();
		javax.ws.rs.client.Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("https://api.dropboxapi.com/2/")
											.path("files/list_folder");
		Response response = target.request()
				.header("Authorization", "Bearer "+token)

				.header("Content-Type", "application/plain;charset=dropbox-cors-hack")
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(params, MediaType.APPLICATION_JSON), Response.class);
		
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus() + "\n" + response.getHeaders() + "\n" +response.readEntity(String.class)+ "\n");
		}

		String output = response.readEntity(String.class);
		Gson gson = new Gson();
		List<DropboxFileRessource> dfrList = new ArrayList<DropboxFileRessource>();
		JsonParser parser = new JsonParser();
		
		JsonObject root = parser.parse(output).getAsJsonObject();
		JsonArray fileList = root.getAsJsonArray("entries");
		DropboxFileRessource dfr;
		
		System.out.println(fileList.toString());
		System.out.println("Debut du parcours");
		for (JsonElement file : fileList) {
		    dfr = gson.fromJson(file, DropboxFileRessource.class);
		    dfrList.add(dfr);
		}
		return dfrList;
	}
	
	
	/**
	 * List of content from a path
	 * 
	 * @return JSON File of the content of the folder
	 */
	public List<DropboxFileRessource> getContent(String token, String path) {
		String finalPath;
		finalPath = "/"+path;
		
		final String params = "\r\n{\r\n\"path\" : \""+finalPath+"\", \r\n\"recursive\": false,\"include_media_info\": false,\r\n\"include_deleted\": false,\r\n\"include_has_explicit_shared_members\": false,\r\n\"include_mounted_folders\": true}";
		
		ClientConfig config = new ClientConfig();
		javax.ws.rs.client.Client client = ClientBuilder.newClient(config);
		WebTarget target = client.target("https://api.dropboxapi.com/2/")
											.path("files/list_folder");
		Response response = target.request()
				.header("Authorization", "Bearer "+token)
				.header("Content-Type", "application/plain;charset=dropbox-cors-hack")
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(params, MediaType.APPLICATION_JSON), Response.class);
		
		if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus() + "\n" + response.getHeaders() + "\n" +response.readEntity(String.class)+ "\n");
		}

		String output = response.readEntity(String.class);
		
		Gson gson = new Gson();
		List<DropboxFileRessource> dfrList = new ArrayList<DropboxFileRessource>();
		JsonParser parser = new JsonParser();
		
		JsonObject root = parser.parse(output).getAsJsonObject();
		JsonArray fileList = root.getAsJsonArray("entities");
		DropboxFileRessource dfr;
		for (JsonElement file : fileList) {
		    dfr = gson.fromJson(file, DropboxFileRessource.class);
		    dfrList.add(dfr);
		}
		return dfrList;

	}
	
	/** Download file in browser from dropbox with file path
	 * 
	 * 
	 * @return the file to download in browser
	 */
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadFile(final String token, final String filePath) {
		
		String fileExtension = FilenameUtils.getExtension(filePath);
		String fileName = FilenameUtils.getBaseName(filePath);
		
		
		StreamingOutput fileStream = new StreamingOutput() {
			
			@Override
			public void write(java.io.OutputStream output) throws IOException {
				Client client = Client.create();
				WebResource webRessource = client.resource("https://content.dropboxapi.com/2/files/download");
				
				ClientResponse response = webRessource.header("Authorization", "Bearer "+token)
						.header("Dropbox-API-Arg", "{\"path\" : \"/"+filePath+"\"}")
						.accept("application/plain;charset=dropbox-cors-hack")
						.post(ClientResponse.class);
			    
				if (response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}

				InputStream res = response.getEntity(InputStream.class);
				byte[] resByteArray = IOUtils.toByteArray(res);
				output.write(resByteArray);
			}
		};
		
		return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM).build();
				//header("content-disposition", "attachement; filename ="+fileName+"."+fileExtension)
				
	}
	

	/**
	 * Créer un fichier dans Dropbox
	 * 
	 * @param fileInputStream
	 * @param fileMetaData
	 * @return fileMetaData
	 * @throws Exception
	 */
	@POST
	public DropboxFileRessource createFile(String token, String filePath) {
		
        final javax.ws.rs.client.Client client = ClientBuilder.newBuilder().build();
        final WebTarget webtarget = client
                .target("https://content.dropboxapi.com")
                .path("2/files/upload");
        String response = webtarget.request(MediaType.APPLICATION_OCTET_STREAM)
                .header("Authorization", "Bearer " + token)
                .header("Dropbox-API-Arg", "{\"path\": \"/" + filePath + "\",\"mode\": \"add\",\"autorename\": true,\"mute\": false}")
                .post(Entity.entity(filePath, MediaType.APPLICATION_OCTET_STREAM), String.class);
        
        Gson gson = new Gson();
        DropboxFileRessource dfr = gson.fromJson(response, DropboxFileRessource.class);
        
        return dfr;
	}


	/**
	 * Supprime un fichier de dropbox
	 * 
	 * @param token
	 * @param filePath
	 * @return le metadata du fichier, normalement vide.
	 */
	public DropboxFileRessource removeFile(String token, String filePath) {
		
		final String params = "\r\n{\r\n\"path\" : \"/"+filePath+"\"}";
        final javax.ws.rs.client.Client client = ClientBuilder.newBuilder().build();
        final WebTarget webtarget = client
                .target("https://api.dropboxapi.com")
                .path("2/files/delete_v2");
        String response = webtarget.request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.entity(params, MediaType.APPLICATION_JSON), String.class);
        
        Gson gson = new Gson();
        DropboxFileRessource dfr = gson.fromJson(response, DropboxFileRessource.class);
        
        return dfr;
	}
	
	/**
	 * Rename a file
	 * @param token
	 * @param filePath
	 * @return le nouveau filemetadata
	 */
	public DropboxFileRessource renameFile(String token, String oldFilePath, String newFilePath) {
		
		final String params = "\r\n{\r\n\"from_path\" : \"/"+oldFilePath+"\", \r\n\"to_path\" : \"/"+newFilePath+"\"}";
        final javax.ws.rs.client.Client client = ClientBuilder.newBuilder().build();
        final WebTarget webtarget = client
                .target("https://api.dropboxapi.com")
                .path("2/files/move_v2");
        String response = webtarget.request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .post(Entity.entity(params, MediaType.APPLICATION_JSON), String.class);
        
        Gson gson = new Gson();
        DropboxFileRessource dfr = gson.fromJson(response, DropboxFileRessource.class);
        
        return dfr;

		
	}

}


