package com.jxwproject.fichiers;

import java.util.AbstractMap.SimpleEntry;

public class MetaFile {
	private String name;
	private SimpleEntry<String, String> origin;
	private String fileType;
	private long size;
	private String mimeType;
	
	public MetaFile(String name, SimpleEntry<String, String> origin, String fileType, long size, String mimeType) {
		this.name = name;
		this.origin = origin;
		this.fileType = fileType;
		this.size = size;
		this.mimeType = mimeType;
	}

	public MetaFile() {
		
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public SimpleEntry<String, String> getOrigin() {
		return origin;
	}
	
	public void setOrigin(SimpleEntry<String, String> origin) {
		this.origin = origin;
	}
	
	public String getFileType() {
		return fileType;
	}
	
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	public long getSize() {
		return size;
	}
	
	public void setSize(long size) {
		this.size = size;
	}
	
	public String getMimeType() {
		return mimeType;
	}
	
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
}
