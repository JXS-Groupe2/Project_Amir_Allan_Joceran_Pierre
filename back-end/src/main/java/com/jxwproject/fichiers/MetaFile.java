package com.jxwproject.fichiers;

import java.util.AbstractMap.SimpleEntry;

import org.apache.commons.io.FilenameUtils;

import com.jxwproject.fichiers.dropbox.DropboxFileRessource;
import com.jxwproject.fichiers.googledrive.GoogleDriveFileRessource;

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
	
	public static MetaFile dropboxToMetaFile(DropboxFileRessource d) {
		assert(d!=null);
		MetaFile m = new MetaFile();
		m.setName(d.getName());
		m.setFileType(d.getFileType());
		m.setOrigin(new SimpleEntry<String, String>("dropbox", d.getId()));
		if(m.getFileType() == "file") {
			m.setSize(d.getSize());
			m.setMimeType(FilenameUtils.getExtension(d.getName()));
		}
		return m;
	}
	
	public static MetaFile googleToMetaFile(GoogleDriveFileRessource g) {
		assert(g!=null);
		MetaFile m = new MetaFile();
		m.setName(g.getName());
		m.setFileType(g.getKind());
		m.setOrigin(new SimpleEntry<String, String>("googledrive", g.getId()));
		if(m.getFileType() == "file") {
			m.setMimeType(g.getMimeType());
		}
		return m;
	}
	
}
