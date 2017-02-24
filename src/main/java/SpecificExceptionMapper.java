package main.java;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class SpecificExceptionMapper {
	
	String errorString;

	
	 public String RequestError(String reason) {
	        //Response.StatusType type = getStatusType(ex);

	        Error error = new Error(
	                400,
	                "Invalid Request",
	                reason);

	        return error.returnErrorMessage();
	       // return errorString;
	    }
	 
	
	 
	 
}
