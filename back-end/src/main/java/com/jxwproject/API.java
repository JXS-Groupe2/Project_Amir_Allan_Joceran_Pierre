package com.jxwproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.jxwproject.apisrest.DriveREST;
import com.jxwproject.apisrest.DropboxREST;
import com.jxwproject.fichiers.MetaFile;
import com.jxwproject.fichiers.dropbox.DropboxFileRessource;
import com.jxwproject.fichiers.googledrive.GoogleDriveFileRessource;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("files")
public class API {

	private User user;
	private DropboxREST dropbox;
	private DriveREST drive;

	public API() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		// this.user = new Gson().fromJson(new FileReader("comptedev.json"),
		// User.class);
		this.user = new UsersResource().getUser(0);
		System.out.println("Dropbox Token : " + user.getDropboxToken());
		System.out.println("Google Token : " + user.getGoogleToken());

		dropbox = new DropboxREST();
		drive = new DriveREST();

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Méthode permettant de renvoyer la liste de tous les
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listFiles(/* String path */) {
		List<GoogleDriveFileRessource> gdfr;
		List<DropboxFileRessource> dfr;

		List<MetaFile> mf = new ArrayList<MetaFile>();

		// Deuxième condition pour le compte dev
		/*
		 * if((user.getGoogleToken() != null) || (user.getGoogleToken() != ""))
		 * { System.out.println("Récupération des fichiers Google Drive !");
		 * gdfr = DriveREST.getFilesList(user.getGoogleToken()); MetaFile m =
		 * null; int i = 0; for(GoogleDriveFileRessource g : gdfr) { m = new
		 * MetaFile(); m.setName(g.getTitle()); m.setFileType(g.getKind());
		 * m.setOrigin(new SimpleEntry<String, String>("googledrive",
		 * g.getId())); if(m.getFileType() == "file") {
		 * m.setSize(g.getFileSize()); m.setMimeType(g.getMimeType()); } i++; }
		 * System.out.println("Nombre de fichiers Google Drive récupérés : "+i);
		 * mf.add(m); }
		 */

		if (user.getDropboxToken() != null) {
			System.out.println("Récupération des fichiers Dropbox !");
			dfr = dropbox.getContent(user.getDropboxToken());
			System.out.println("Nombre de fichiers Dropbox récupérés : " + dfr.size());
			MetaFile m = null;
			for (DropboxFileRessource d : dfr) {
				m = new MetaFile();
				m.setName(d.getName());
				m.setFileType(d.getFileType());
				m.setOrigin(new SimpleEntry<String, String>("dropbox", d.getId()));
				if (m.getFileType() == "file") {
					m.setSize(d.getSize());
					m.setMimeType(FilenameUtils.getExtension(d.getName()));
				}
				mf.add(m);
			}

		}

		// Sending as JSON String
		Gson gson = new Gson();
		return gson.toJson(mf);
	}

	@GET
	@Path("/{file}")
	@Produces(MediaType.APPLICATION_JSON)
	public MetaFile fileInfo(@PathParam("file") String file) {

		if (user.getGoogleToken() != null) {
			
			GoogleDriveFileRessource info = drive.fileInfo(user.getGoogleToken(), file);
			
			System.out.println(info.getTitle());
			MetaFile metafile = new MetaFile(info.getTitle(), new SimpleEntry<String, String>("google", info.getId()),
					info.getKind(), 0, info.getMimeType() );
			return metafile;
		}

		return null;
	}

}
