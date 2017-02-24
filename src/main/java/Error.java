package main.java;

import org.codehaus.jackson.map.annotate.JsonRootName;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;


@JsonRootName(value = "error")
public class Error {

    private int statusCode;
    private String statusDescription;
    private String errorMessage;

    public Error(int statusCode, String statusDescription, String errorMessage) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
        this.errorMessage = errorMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String returnErrorMessage()
    {
    	Gson gson = new Gson();
    	String errorString;
    	errorString = gson.toJson(this);
    	return errorString;
    }
    	
    
    
}