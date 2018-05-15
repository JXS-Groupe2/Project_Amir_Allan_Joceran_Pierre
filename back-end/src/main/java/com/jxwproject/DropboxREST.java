package com.jxwproject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jxwproject.fichiers.DropboxFileRessource;
import com.jxwproject.fichiers.DropboxMetadataDeserializer;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Path("dropbox")
public class DropboxREST{

	//Token de test : à changer tout le temps
	private final static String OAUTH_KEY = "G7zoVR0rS5oAAAAAAAAN9tmXZyESnMYUsTRFCKwwo58DxBTRT1DN2cM6BhGrXlzz";
	HttpsURLConnection connection = null;
	
	/** Get account info
	 * 
	 * 
	 * @return JSON with infos will be return as text
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("infos")
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
	
	/**
	 * Get File MetaData
	 * 
	 * @return the metadata of the file, for now in string format in the browser
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("getFileMetadata/{filepath}")
	public String getFileMetadata(@PathParam("filepath") String filepath) {
		String finalPath;
		finalPath = "/"+filepath;
		
		final String params = "\r\n{\r\n\"path\" : \""+finalPath+"\", \r\n\"include_media_info\": false,\r\n\"include_deleted\": false,\r\n\"include_has_explicit_shared_members\": false}";
		try {
			ClientConfig config = new ClientConfig();
			javax.ws.rs.client.Client client = ClientBuilder.newClient(config);
			WebTarget target = client.target("https://api.dropboxapi.com/2/")
												.path("files/get_metadata");
			Response response = target.request()
					.header("Authorization", "Bearer "+OAUTH_KEY)
					.header("Content-Type", "application/plain;charset=dropbox-cors-hack")
					.accept(MediaType.APPLICATION_JSON)
					.post(Entity.entity(params, MediaType.APPLICATION_JSON), Response.class);
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus() + "\n" + response.getHeaders() + "\n" +response.readEntity(String.class)+ "\n");
			}

			String output = response.readEntity(String.class);
			JsonParser parser = new JsonParser();
			JsonObject json = parser.parse(output).getAsJsonObject();
			
			DropboxFileRessource dpf = DropboxMetadataDeserializer.deserialize(json);

			String textoutput = "nom : "+dpf.getName() + " | id : "+dpf.getId() + " | path : "+ dpf.getPath();
			return textoutput;
	  } catch (Exception e) {
		    e.printStackTrace();
		    return null;
	  } finally {
		    if (connection != null) {
		      connection.disconnect();
		    }
	  }
	}
	
	/** Open a file in browser from dropbox with file path
	 * 
	 * 
	 * @return the content of the file
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("openFile/{filepath}")
	public String openFile(@PathParam("filepath") String filePath) {
		String fileExtension = FilenameUtils.getExtension(filePath);
		String fileName = FilenameUtils.getBaseName(filePath);
		try {
			Client client = Client.create();
			WebResource webRessource = client.resource("https://content.dropboxapi.com/2/files/download");
			
			ClientResponse response = webRessource.header("Authorization", "Bearer "+OAUTH_KEY)
					.header("Dropbox-API-Arg", "{\"path\" : \"/"+filePath+"\"}")
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
	
	/**
	 * List of content from a path
	 * 
	 * @return JSON File of the content of the folder
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("listFolder")
	public String getRootContent() {

		final String params = "\r\n{\r\n\"path\" : \"\", \r\n\"recursive\": false,\"include_media_info\": false,\r\n\"include_deleted\": false,\r\n\"include_has_explicit_shared_members\": false,\r\n\"include_mounted_folders\": true}";
		try {
			ClientConfig config = new ClientConfig();
			javax.ws.rs.client.Client client = ClientBuilder.newClient(config);
			WebTarget target = client.target("https://api.dropboxapi.com/2/")
												.path("files/list_folder");
			Response response = target.request()
					.header("Authorization", "Bearer "+OAUTH_KEY)
					.header("Content-Type", "application/plain;charset=dropbox-cors-hack")
					.accept(MediaType.APPLICATION_JSON)
					.post(Entity.entity(params, MediaType.APPLICATION_JSON), Response.class);
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus() + "\n" + response.getHeaders() + "\n" +response.readEntity(String.class)+ "\n");
			}

			String output = response.readEntity(String.class);

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
	
	
	/**
	 * List of content from a path
	 * 
	 * @return JSON File of the content of the folder
	 */
	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("listFolder/{path}")
	public String getFolderContent(@PathParam("path") final String path) {
		String finalPath;
		finalPath = "/"+path;
		
		final String params = "\r\n{\r\n\"path\" : \""+finalPath+"\", \r\n\"recursive\": false,\"include_media_info\": false,\r\n\"include_deleted\": false,\r\n\"include_has_explicit_shared_members\": false,\r\n\"include_mounted_folders\": true}";
		try {
			ClientConfig config = new ClientConfig();
			javax.ws.rs.client.Client client = ClientBuilder.newClient(config);
			WebTarget target = client.target("https://api.dropboxapi.com/2/")
												.path("files/list_folder");
			Response response = target.request()
					.header("Authorization", "Bearer "+OAUTH_KEY)
					.header("Content-Type", "application/plain;charset=dropbox-cors-hack")
					.accept(MediaType.APPLICATION_JSON)
					.post(Entity.entity(params, MediaType.APPLICATION_JSON), Response.class);
			
			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus() + "\n" + response.getHeaders() + "\n" +response.readEntity(String.class)+ "\n");
			}

			String output = response.readEntity(String.class);

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
	
	/** Download file in browser from dropbox with file path
	 * 
	 * 
	 * @return the file to download in browser
	 */
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	@Path("getFile/{filepath}")
	public Response downloadFile(@PathParam("filepath") final String filePath) {
		
		String fileExtension = FilenameUtils.getExtension(filePath);
		String fileName = FilenameUtils.getBaseName(filePath);
		
		
		StreamingOutput fileStream = new StreamingOutput() {
			
			@Override
			public void write(java.io.OutputStream output) {
				try {
					Client client = Client.create();
					WebResource webRessource = client.resource("https://content.dropboxapi.com/2/files/download");
					
					ClientResponse response = webRessource.header("Authorization", "Bearer "+OAUTH_KEY)
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
				catch (Exception e) {
				    e.printStackTrace();
				}
				finally {
				    if (connection != null) {
				      connection.disconnect();
				   }
				}
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
			
			ClientResponse response = webRessource.header("Authorization", "Bearer "+OAUTH_KEY)
					.header("Dropbox-API-Arg", "{\"path:\""+uploadedFileLocation+", \"mode\": \"add\",\"autorename\": true,\"mute\": false}")
					.header("Content-Type", "application/octet-stream")
					.post(ClientResponse.class, out);
			
	    } catch (IOException e) {

	        e.printStackTrace();
	    }

	}
	*/

}


