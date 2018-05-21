package com.jxwproject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.jxwproject.apisrest.DriveREST;
import com.jxwproject.apisrest.DropboxREST;
import com.jxwproject.fichiers.MetaFile;
import com.jxwproject.fichiers.dropbox.DropboxFileRessource;
import com.jxwproject.fichiers.googledrive.GoogleDriveFileRessource;
import com.jxwproject.fichiers.googledrive.GoogleDriveFilesList;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("files")
public class API {
	
	private User user;
	private DropboxREST dropbox;
	private DriveREST drive;
	
	public API() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		this.user = new Gson().fromJson(new FileReader("comptedev.json"), User.class);
		System.out.println("Dropbox Token : "+user.getDropboxToken());
		System.out.println("Google Token : "+user.getGoogleToken());
		
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
	 * @throws FileNotFoundException 
	 * @throws JsonIOException 
	 * @throws JsonSyntaxException 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String listFiles(/*String path*/) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
    	GoogleDriveFilesList gdfr;
    	List<DropboxFileRessource> dfr;
    	Gson gson = new Gson();
    	List<MetaFile> mf = new ArrayList<MetaFile>();
    	
    	if((user.getDropboxToken() != null) || (user.getDropboxToken() != ""))
    	{
    		System.out.println("Récupération des fichiers Dropbox !");
    		dfr = dropbox.getContent(user.getDropboxToken());
    		System.out.println("Nombre de fichiers Dropbox récupérés : "+dfr.size());
    		MetaFile m = null;
    		for(DropboxFileRessource d : dfr) {
    			m = new MetaFile();
    			m.setName(d.getName());
    			m.setFileType(d.getFileType());
    			m.setOrigin(new SimpleEntry<String, String>("dropbox", d.getId()));
    			if(m.getFileType() == "file") {
    				m.setSize(d.getSize());
    				m.setMimeType(FilenameUtils.getExtension(d.getName()));
    			}
    			mf.add(m);
    		}
    		
    	}
    	
    	//Deuxième condition pour le compte dev
    	if((user.getGoogleToken() != null) || (user.getGoogleToken() != ""))
    	{
    		System.out.println("Récupération des fichiers Google Drive !");
    		gdfr = drive.getFilesList(user.getGoogleToken());
    		//gdfr = gson.fromJson(new FileReader("reponse.json"), GoogleDriveFilesList.class);
    		System.out.println("Nombre de fichiers Drive récupérés : "+gdfr.getFiles().length);
    		MetaFile m = null;
    		GoogleDriveFileRessource[] files = gdfr.getFiles();
    		for(int i = 0; i < files.length; i++) {
    			m = new MetaFile();
    			m.setName(files[i].getName());
    			m.setFileType(files[i].getKind());
    			m.setOrigin(new SimpleEntry<String, String>("googledrive", files[i].getId()));
    			if(m.getFileType() == "file") {
    				m.setMimeType(files[i].getMimeType());
    			}
    			mf.add(m);
    		}
    	}
    	
    	//Sending as JSON String
    	return gson.toJson(mf);
    }
}
