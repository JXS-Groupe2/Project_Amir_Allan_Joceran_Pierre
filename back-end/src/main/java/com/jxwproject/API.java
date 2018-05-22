package com.jxwproject;

import java.io.FileNotFoundException;
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

	@GET
	@Path("/{file: .*}")
	@Produces(MediaType.APPLICATION_JSON)
	public MetaFile fileInfo(@PathParam("file") String file) {

		if (user.getGoogleToken() != null) {
			file = "/"+file;
			
			GoogleDriveFileRessource[] files =drive.allFiles(user.getGoogleToken()).getFiles();
			
			for ( GoogleDriveFileRessource fichier : files) {
				if(drive.filePath(fichier.getId(), user.getGoogleToken()).equals(file)){
					GoogleDriveFileRessource info = drive.fileInfo(user.getGoogleToken(), fichier.getId());

					MetaFile metafile = new MetaFile(info.getName(), new SimpleEntry<String, String>("google", info.getId()),
							info.getKind(),0, info.getMimeType());
					return metafile;
				}
			}
			
		}
		
		if (user.getDropboxToken() != null) {
			String meta = dropbox.getFileMetadata(user.getDropboxToken(), file);
			Gson gson = new Gson();
			MetaFile mfile = gson.fromJson(meta, MetaFile.class);
			
			return mfile;
			
		}

		System.out.println("no file found");
		return null;
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
    	
    	//Deuxième condition pour le compte dev
    	// TODO : supprimer ça une fois les connexions réglés
    	if((user.getDropboxToken() != null) || (user.getDropboxToken() != ""))
    	{
    		System.out.println("Récupération des fichiers Dropbox !");
    		dfr = dropbox.getContent(user.getDropboxToken());
    		System.out.println("Nombre de fichiers Dropbox récupérés : "+dfr.size());
    		MetaFile m = null;
    		for(DropboxFileRessource d : dfr) {
    			m = MetaFile.dropboxToMetaFile(d);
    			mf.add(m);
    		}
    		
    	}
    	
    	//Deuxième condition pour le compte dev
    	// TODO : supprimer ça une fois les connexions réglés
    	if((user.getGoogleToken() != null) || (user.getGoogleToken() != ""))
    	{
    		System.out.println("Récupération des fichiers Google Drive !");
    		gdfr = drive.getFilesList(user.getGoogleToken());
    		//gdfr = gson.fromJson(new FileReader("reponse.json"), GoogleDriveFilesList.class);
    		System.out.println("Nombre de fichiers Drive récupérés : "+gdfr.getFiles().length);
    		MetaFile m = null;
    		GoogleDriveFileRessource[] files = gdfr.getFiles();
    		for(int i = 0; i < files.length; i++) {
    			m = MetaFile.googleToMetaFile(files[i]);
    			mf.add(m);
    		}
    	}
    	
    	//Sending as JSON String
    	return gson.toJson(mf);
    }
    
    /**
     * Suppression d'un fichier dans le dossier courant
     * @param filePath
     * @return le metadata du fichier supprimé
     * @throws FileNotFoundException 
     * @throws JsonIOException 
     * @throws JsonSyntaxException 
     */
    @GET
    @Path("{filePath}/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public String delete(@PathParam("filePath") final String filePath) throws JsonSyntaxException, JsonIOException, FileNotFoundException {

    	List<MetaFile> meta = new ArrayList<MetaFile>();
    	DropboxFileRessource dropboxRes = null;
    	if((user.getDropboxToken() != null) || (user.getDropboxToken() != "")) {
    		dropboxRes = dropbox.removeFile(user.getDropboxToken(), filePath);		
    	}
    	meta.add(MetaFile.dropboxToMetaFile(dropboxRes));
    	
    	Gson gson = new Gson();
    	
    	return gson.toJson(meta);
    	
    }
    
    /**
     * Créer un fichier dans le dossier courant
     * @param filePath
     * @return le metadata du fichier supprimé
     * @throws FileNotFoundException 
     * @throws JsonIOException 
     * @throws JsonSyntaxException 
     */
    @GET
    @Path("{filePath}/create")
    @Produces(MediaType.APPLICATION_JSON)
    public String create(@PathParam("filePath") final String filePath) throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		
    	List<MetaFile> meta = new ArrayList<MetaFile>();
    	DropboxFileRessource dropboxRes = null;
    	if((user.getDropboxToken() != null) || (user.getDropboxToken() != "")) {
    		dropboxRes = dropbox.createFile(user.getDropboxToken(), filePath);		
    	}
    	meta.add(MetaFile.dropboxToMetaFile(dropboxRes));
    	
    	Gson gson = new Gson();
    	
    	return gson.toJson(meta);
    	
    }
}
