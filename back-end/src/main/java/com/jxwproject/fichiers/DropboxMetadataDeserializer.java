package com.jxwproject.fichiers;

import java.text.SimpleDateFormat;
import java.util.TimeZone;


import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class DropboxMetadataDeserializer{

	public static DropboxFileRessource deserialize(JsonObject jsonObject)
			throws JsonParseException {
		//final JsonObject jsonObject = json.getAsJsonObject();
		DropboxFileRessource dropboxFile = new DropboxFileRessource();
		
		if(jsonObject.get(".tag").getAsString() == FileType.FILE.toString()) {
			dropboxFile.setFileType(FileType.FILE);
		} else {
			dropboxFile.setFileType(FileType.FOLDER);
		}
		
		dropboxFile.setId(jsonObject.get("id").getAsString());
		dropboxFile.setName(jsonObject.get("name").getAsString());
		
		String modifiedDate = jsonObject.get("client_modified").getAsString();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		try {
			dropboxFile.setModifiedByUser(formatter.parse(modifiedDate));
		} catch(Exception e) {
			
		}
		
		if(dropboxFile.getFileType() == FileType.FILE) {
			dropboxFile.setSize(jsonObject.get("size").getAsInt());
		}
		
		dropboxFile.setPath(jsonObject.get("path_lower").getAsString());
		
		return dropboxFile;
	}

}