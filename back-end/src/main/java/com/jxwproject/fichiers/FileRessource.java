package com.jxwproject.fichiers;

import java.util.Date;

import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

public class FileRessource {

	private FileType fileType;
	private String id;
	private String name;
	private Date modifiedByUser;
	
	public FileRessource(FileType fileType, String id, String name, Date modifiedByUser) {
		this.fileType = fileType;
		this.id = id;
		this.name = name;
		this.modifiedByUser = modifiedByUser;
	}
	
	public FileRessource() {
		
	}
	
	public FileType getFileType() {
		return fileType;
	}
	
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getModifiedByUser() {
		return modifiedByUser;
	}
	
	public void setModifiedByUser(Date modifiedByUser) {
		this.modifiedByUser = modifiedByUser;
	}

}
