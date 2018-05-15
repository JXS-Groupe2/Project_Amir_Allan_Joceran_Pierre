package com.jxwproject.fichiers;

public enum FileType {
	FILE("file"),
	FOLDER("folder");
	
	private final String type;
	
	FileType(final String type){
		this.type = type;
	}
	
	public String toString() {
		return type;
	}
}
