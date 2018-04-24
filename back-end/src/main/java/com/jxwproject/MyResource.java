package com.jxwproject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("files")
public class MyResource {
	
	private String id_client = "581304083749-f7fflm2rphclajee39dvbc0p9rvtke88.apps.googleusercontent.com";
	private String secret ="QDQVWvAK0Xpi6ZSXGkCX-C_R";
	private String token = "ya29.GlunBSw3Z5djuSsqRpfyr8QlZvRlJQgDsf3BgnBpk1fxZIq1eK8NtJ1F1Nnd2R4U1VuOufbc-QABtfIdjE50U-h9ZF695TUImVjp9xwXhOnKkVtyw9tW17pmZyq";

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        String targetUrl = "https://www.googleapis.com/upload/drive/v2/files?uploadType=multipart&access_token=" +token ;
        String url = "GET https://www.googleapis.com/drive/v3/files";

    	
        return "Got it!";
    }
}
