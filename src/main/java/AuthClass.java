package main.java;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
 
 
 
public class AuthClass extends ResourceConfig 
{
    public AuthClass() 
    {
        packages("com.backendAnagramFinder");
        register(LoggingFilter.class);
        register(GsonMessageBodyHandler.class);
 
        //Register Auth Filter here
        register(AuthenticationFilter.class);
    }
}