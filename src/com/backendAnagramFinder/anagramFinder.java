package com.backendAnagramFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/findAnagrams")
public class anagramFinder {

	SpecificExceptionMapper specEx = new SpecificExceptionMapper();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	
	public Response InvalidPath()
	{
		String jsonString;
		 jsonString=specEx.RequestError("Please add the word to the URI");
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonString).build();
	
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) 
	@Path("/{param}")	
	public Response getMsg(@PathParam("param") String msg) throws IOException {
	 
		//Variables
		String jsonString;
		ArrayList<String> anagramList = new ArrayList<String>();
		Gson gson = new Gson();
		int product=1;
		ResponseBody returnValues= new ResponseBody();
		//Set Entered word into the response
		
		returnValues.SetEnteredWord(msg);
		//Loop to get product of entered word
		
		for (int k = 0; k<msg.length();k++)
		{
			product=product*initialization.hash.get(msg.charAt(k));
     	}
		     
		if(initialization.anagrams.get(product)==null)
		{
		    //jsonString="No Anagrams of " + msg + " were found.";
		   // throw new RuntimeException("Not a Valid Word");
		    jsonString=specEx.RequestError("No Anagrams were found for the word " + msg);
			return Response.status(Response.Status.BAD_REQUEST).entity(jsonString).build();
		}
		
		else
		{
		//find all anagrams		   
		anagramList=initialization.anagrams.get(product);     
		returnValues.SetAnagrams(anagramList); 		     
		jsonString = gson.toJson(returnValues);
		System.out.println(jsonString);
		return Response.status(Response.Status.OK).entity(jsonString).build();
        }

		
	}
}	