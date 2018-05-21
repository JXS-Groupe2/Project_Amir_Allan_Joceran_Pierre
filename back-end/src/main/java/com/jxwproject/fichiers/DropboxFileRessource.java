package com.jxwproject.fichiers;

import java.util.Date;

public class DropboxFileRessource extends FileRessource {

	private Integer size;
	private String path;
	
	public DropboxFileRessource(FileType fileType, String id, String name, Date modifiedByUser, Integer size, String path) {
		super(fileType, id, name, modifiedByUser);
		this.size = size;
		this.path = path;
	}
	
	public DropboxFileRessource() {
		super();
	}
	
	public Integer getSize() {
		assert(size != null);
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	

}
