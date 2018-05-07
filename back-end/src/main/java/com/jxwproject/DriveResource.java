package com.jxwproject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/drive")
public class DriveResource {

	private String token = "ya29.GluzBdH9VHoSJsgUEmzRyEVnvihVNFLX-9rdX3BXze3eHuHuDQrkrB_gbqtI5nfzBdqxPfRJsB8FcobUNPldZdqRCs__w9Cnz32-3Tw3r_DkB4U5NfI_qyTFh38X";
	
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/infos")
	public String getInfos() {

		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/").path("about")
				.queryParam("fields", "user");

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);

		return output;

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/files")
	public String getFilesList() {

		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/").path("files");

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);

		return output;

	}
	
	@GET
	@Path("/{file}")
	public String fileInfo(@PathParam("file") final String file) {

		
		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v2/").path(file);

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token).get(ClientResponse.class);

		if (response.getStatus() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);

		return output;


	}

	@GET
	@Path("/{file}/download")
	public Response downloadFile(@PathParam("file") final String file) {

		StreamingOutput fileStream = new StreamingOutput() {
			@Override
			public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
				try {

					Client client = Client.create();
					WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/files/").path(file)
							.queryParam("alt", "media");

					ClientResponse response = null;
					response = webResource.header("Content-Type", "application/json;charset=UTF-8")
							.header("Authorization", "Bearer " + token).get(ClientResponse.class);

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
		return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition", "attachment; filename = " + fileTitle(file)).build();

	}

	@GET
	@Path("/{file}/export")
	public Response exeportFile(@PathParam("file") final String file) {

		StreamingOutput fileStream = new StreamingOutput() {
			@Override
			public void write(java.io.OutputStream output) throws IOException, WebApplicationException {
				try {
					Client client = Client.create();
					WebResource webResource = client.resource("https://www.googleapis.com/drive/v2/files/").path(file)
							.path("export").queryParam("mimeType", "application/pdf").queryParam("alt", "media");

					ClientResponse response = null;
					response = webResource.header("Content-Type", "application/json;charset=UTF-8")
							.header("Authorization", "Bearer " + token).get(ClientResponse.class);

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
		
		return Response.ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
				.header("content-disposition", "attachment; filename = "+fileTitle(file)+".pdf").build();

	}

	@DELETE
	@Path("/{file}")
	public String removeFile(@PathParam("file") final String file) {

		Client client = Client.create();
		WebResource webResource = client.resource("https://www.googleapis.com/drive/v3/files/").path(file);

		ClientResponse response = null;
		response = webResource.header("Content-Type", "application/json;charset=UTF-8")
				.header("Authorization", "Bearer " + token).delete(ClientResponse.class);

		if (response.getStatus() % 100 != 2) {
			System.out.println(response.getStatus());
			throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
		}
		String output = response.getEntity(String.class);

		return output;
	}

	
//	@GET
//	@Path("/upload")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputSteam,
//			@FormDataParam("file") FormDataContentDisposition fileDetail){
//		String uploadedFileLocation = "e://upload/" + fileDetail.getFileName();
//		writeToFile(uploadedInputSteam, uploadedFileLocation);
//		
//		String output = "File uploaded to : " + uploadedFileLocation;
//		return Response.status(200).entity(output).build();
//		Client client = Client.create();
//		WebResource webResource = client.resource("https://www.googleapis.com/upload/drive/v3/files?uploadType=media");
//
//		ClientResponse response = response = webResource.header("Content-Type", "")
//				.header("Authorization", "Bearer " + token).delete(ClientResponse.class);
//
//		return null;
//
//	}
	


	// ************************ internal methods ************************
	public String fileTitle(final String file) {

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

		return output.get("title").getAsString();
		//return output.get("originalFilename").getAsString();
	}

	
	
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
				out.flush();
				out.close();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}
}
