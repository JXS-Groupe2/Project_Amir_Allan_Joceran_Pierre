package com.jxwproject.apisrest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.GET;
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

	//Token de test : à changer tout le temps
	//private final static String token = "G7zoVR0rS5oAAAAAAAAN9tmXZyESnMYUsTRFCKwwo58DxBTRT1DN2cM6BhGrXlzz";
	
	
	/** Get account info
	 * 
	 * 
	 * @return JSON with infos will be return as text
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public static String getUserAccountInfos(String token) {
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
	public String getFileMetadata(String token, String filepath) {
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
		
		String textoutput = "nom : "+dpf.getName() + " | id : "+dpf.getId() + " | path : "+ dpf.getPathLower() +"| type : "+dpf.getFileType();
		return textoutput;
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
	@GET
	public static List<DropboxFileRessource> getContent(String token) {

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
		JsonArray fileList = root.getAsJsonArray("entities");
		DropboxFileRessource dfr;
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
	@GET
	public static List<DropboxFileRessource> getContent(String token, String path) {
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
	 * Upload a file to root folder in dropbox (for now)
	 * TODO : Get the actual folder where the user is
	 * 
	 * @param fileInputStream
	 * @param fileMetaData
	 * @return Response ok or not
	 * @throws Exception
	 
	@POST
	@Path("/uploadFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(
	        @FormDataParam("file") InputStream uploadedInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileDetail,
	        @FormDataParam("path") String path) {


	    // Path format //localhost/Installables/uploaded/
	    System.out.println("path:"+path);
	    String uploadedFileLocation = path	
	            + fileDetail.getFileName();

	    // save it
	    writeToFile(uploadedInputStream, uploadedFileLocation);

	    String output = "File uploaded to : " + uploadedFileLocation;

	    return Response.status(200).entity(output).build();

	}

	// save uploaded file to new location
	private void writeToFile(InputStream uploadedInputStream,
	        String uploadedFileLocation) {

	    try {
	        OutputStream out = new FileOutputStream(new File(
	                uploadedFileLocation));
	        int read = 0;
	        byte[] bytes = new byte[1024];

	        out = new FileOutputStream(new File(uploadedFileLocation));
	        while ((read = uploadedInputStream.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        Client client = Client.create();
			WebResource webRessource = client.resource("https://content.dropboxapi.com/2/files/upload");
			
			ClientResponse response = webRessource.header("Authorization", "Bearer "+token)
					.header("Dropbox-API-Arg", "{\"path:\""+uploadedFileLocation+", \"mode\": \"add\",\"autorename\": true,\"mute\": false}")
					.header("Content-Type", "application/octet-stream")
					.post(ClientResponse.class, out);
			
	    } catch (IOException e) {

	        e.printStackTrace();
	    }

	}
	*/

}


