package com.jxwproject.apisrest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jxwproject.fichiers.googledrive.GoogleDriveFileRessource;
import com.jxwproject.fichiers.googledrive.GoogleDriveFilesList;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class DriveREST {

	// private String token =
	// "ya29.Glu5BX5E_CPeT78i9VQHs_VOqlHj_BVE71djvALeNL0_wAxZ8TxnFhN3y1pONdet6x7_-aGIDWwEiw7TDkpCxfyVS5JwH9o-7iufWHNheaTVwel2HxGsttbGctHP";

	public DriveREST() {

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfos(String token) {

		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/").path("about")
				.queryParam("fields", "user");

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token)
                .header("Access-Control-Allow-Origin", "*")
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);

		return output;

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)

	public GoogleDriveFilesList getFilesList(String token) {
        final javax.ws.rs.client.Client client = ClientBuilder.newBuilder().build();
        final WebTarget webtarget = client.target("https://www.googleapis.com").path("drive/v3/files");
		String response;
		
		System.out.println("Envoi de la requête");
		response = webtarget
				.queryParam("q", "%27root%27%20in%20parents")
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .header("Access-Control-Allow-Origin", "*")
                .get(String.class);
		
		Gson gson = new Gson();
		GoogleDriveFilesList gdfrList = gson.fromJson(response, GoogleDriveFilesList.class);
		System.out.println("Post processing : "+gdfrList.getKind() + " " +gdfrList.getFiles().length);

		return gdfrList;

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public GoogleDriveFileRessource fileInfo(String token, final String file) {

		//System.out.println(file);
		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/files").path(file);

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token)
                .header("Access-Control-Allow-Origin", "*")
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			System.err.println(response.getStatus());
			return null;
		}
		String output = response.getEntity(String.class);
		Gson gson = new Gson();
		GoogleDriveFileRessource fileressource =gson.fromJson(output, GoogleDriveFileRessource.class);
		return fileressource;


	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String fileParent(final String token, final String file) {

		return fileAttributs(token, file, "parents").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();

	}

	@GET
	public String[] fileChildren(String token/*, final String folder*/) {

		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v2/files/").path("/").path("children");

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token)
                .header("Access-Control-Allow-Origin", "*")
				.get(ClientResponse.class);

		if (response.getStatus() != 200) {
			System.err.println(response.getStatus());
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		JsonParser parser = new JsonParser();
		JsonArray jsonresponse = parser.parse(response.getEntity(String.class)).getAsJsonObject().get("items")
				.getAsJsonArray();

		String[] result = new String[jsonresponse.size()];
		for (int i = 0; i < jsonresponse.size(); i++) {
			result[i] = jsonresponse.get(i).getAsJsonObject().get("id").getAsString();
		}


		return result;

	}

	@GET
	public Response downloadFile(final String token, final String file) {

		StreamingOutput fileStream = new StreamingOutput() {
			@Override
			public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
				try {

					Client client = Client.create();
					WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/files/").path(file)
							.queryParam("alt", "media");

					ClientResponse response = null;
					response = webResource.header("Content-Type", "application/json;charset=UTF-8")
							.header("Authorization", "Bearer " + token)
			                .header("Access-Control-Allow-Origin", "*")
							.get(ClientResponse.class);

					if (response.getStatus() != 200) {
						System.out.println(response.getStatus());
						throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
					}

					InputStream res = response.getEntity(InputStream.class);
					byte[] resByteArray = IOUtils.toByteArray(res);
					output.write(resByteArray);

				} catch (Exception e) {
					System.err.println(e);
					throw new WebApplicationException("File Not Found !!");
				}
			}
		};
		return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM).header("content-disposition",
				"attachment; filename = " + fileAttributs(token, file, "title").getAsString()).build();
	}

	@GET
	public Response exeportFile(final String token, final String file) {

		StreamingOutput fileStream = new StreamingOutput() {
			@Override
			public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
				try {
					Client client = Client.create();
					WebResource webResource = client.resource("https://www.googleapis.com/drive/v2/files/").path(file)
							.path("export").queryParam("mimeType", "application/pdf").queryParam("alt", "media");

					ClientResponse response = null;
					response = webResource.header("Content-Type", "application/json;charset=UTF-8")
							.header("Authorization", "Bearer " + token)
			                .header("Access-Control-Allow-Origin", "*")
							.get(ClientResponse.class);

					if (response.getStatus() != 200) {
						throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
					}

					InputStream res = response.getEntity(InputStream.class);
					byte[] resByteArray = IOUtils.toByteArray(res);
					output.write(resByteArray);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM).header("content-disposition",
				"attachment; filename = " + fileAttributs(token, file, "title").getAsString() + ".pdf").build();

	}

	@DELETE
	public String removeFile(String token, final String file) {

		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/files/").path(file);

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
                .header("Access-Control-Allow-Origin", "*")
				.header("Authorization", "Bearer " + token).delete(ClientResponse.class);

		if (response.getStatus() % 100 != 2) {
			System.out.println(response.getStatus());
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);

		return output;
	}

	@GET
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputSteam,
			@FormDataParam("file") FormDataContentDisposition fileDetail) {

		String uploadedFileLocation = "e://upload/" + fileDetail.getFileName();
		writeToFile(uploadedInputSteam, uploadedFileLocation);

		String output = "File uploaded to : " + uploadedFileLocation;
		return Response.status(200).entity(output).build();

		// Client client = Client.create();
		// WebResource webResource =
		// client.resource("https://www.googleapis.com/upload/drive/v3/files?uploadType=media");
		//
		// ClientResponse response = response =
		// webResource.header("Content-Type", "")
		// .header("Authorization", "Bearer " +
		// token).delete(ClientResponse.class);
		//
		// return null;

	}

	// ************************ internal methods ************************
	
	
	public String filePath(String file, String token){
		StringBuilder path = new StringBuilder();
		path.append(fileAttributs(token, file, "title").getAsString());
		while(true){
			if (fileAttributs(token, file, "parents").getAsJsonArray().get(0).getAsJsonObject().get("isRoot").getAsBoolean()){
				path.append("/",0,0);
				break;
			}else{
				
				file = fileAttributs(token, file, "parents").getAsJsonArray().get(0).getAsJsonObject().get("id").getAsString();
				path.append(fileAttributs(token, file, "title").getAsString(),0,0);
				
			}	
			
		}
		
		
		return path.toString();
	}
	

	public JsonElement fileAttributs(final String token, final String file, final String att) {

		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v2/files/").path(file);

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			System.out.println(response.getStatus());
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		JsonParser parser = new JsonParser();
		JsonObject output = parser.parse(response.getEntity(String.class)).getAsJsonObject();

		return output.get(att);
	}

	private void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) {

		try {
			OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			out = new FileOutputStream(new File(uploadedFileLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
