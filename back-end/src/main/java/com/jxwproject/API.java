package com.jxwproject;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
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
	
	public API(User user) {
		this.setUser(user);
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
    @Produces(MediaType.TEXT_PLAIN)
    public String listFiles(String path) {
    	List<GoogleDriveFileRessource> gdfr;
    	List<DropboxFileRessource> dfr;
    	
    	List<MetaFile> mf = new ArrayList<MetaFile>();
    	
    	if(user.getGoogleToken() != null)
    	{
    		gdfr = DriveREST.getFilesList(user.getGoogleToken());
    		Iterator<GoogleDriveFileRessource> it = gdfr.listIterator();
    		MetaFile m = null;
    		while(it.hasNext()) {
    			GoogleDriveFileRessource g = it.next();
    			m = new MetaFile();
    			m.setName(g.getTitle());
    			m.setFileType(g.getKind());
    			m.setOrigin(new SimpleEntry<String, String>("googledrive", g.getId()));
    			if(m.getFileType() == "file") {
    				m.setSize(g.getFileSize());
    				m.setMimeType(g.getMimeType());
    			}
    		}
    		mf.add(m);
    	}
    	
    	if (user.getDropboxToken() != null)
    	{
    		dfr = DropboxREST.getContent(user.getDropboxToken());
    		Iterator<DropboxFileRessource> it = dfr.listIterator();
    		MetaFile m = null;
    		while(it.hasNext()) {
    			DropboxFileRessource d = it.next();
    			m = new MetaFile();
    			m.setName(d.getName());
    			m.setFileType(d.getFileType());
    			m.setOrigin(new SimpleEntry<String, String>("dropbox", d.getId()));
    			if(m.getFileType() == "file") {
    				m.setSize(d.getSize());
    				m.setMimeType(FilenameUtils.getExtension(d.getName()));
    			}
    		}
    		mf.add(m);
    	}
    	
    	//Sending as JSON String
    	Gson gson = new Gson();
    	return gson.toJson(mf);
    }
}
