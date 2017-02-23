package com.backendAnagramFinder;


import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;
 
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
 
import org.glassfish.jersey.internal.util.Base64;
 
/**
 * This filter verify the access permissions for a user
 * based on username and passowrd provided in request
 * */
@Provider
public class AuthenticationFilter implements javax.ws.rs.container.ContainerRequestFilter
{
     
    @Context
    private ResourceInfo resourceInfo;
     
    private static final String AUTHORIZATION_PROPERTY = "Authorization";
    private static final String AUTHENTICATION_SCHEME = "Basic";
    private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED)
                                                        .entity("Please enter valid credentials").build();
    private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN)
                                                        .entity("Access blocked for all users !!").build();
      
    @Override
    public void filter(ContainerRequestContext requestContext)
    {
    	try{
        Method method = resourceInfo.getResourceMethod();
        //Access allowed for all
        if( ! method.isAnnotationPresent(PermitAll.class))
        {
            //Access denied for all
            if(method.isAnnotationPresent(DenyAll.class))
            {
            	
            	throw new NotAuthorizedException("Bearer");
            }
              
            //Get request headers
            final MultivaluedMap<String, String> headers = requestContext.getHeaders();
              
            //Fetch authorization header
            final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);
              
            //If no authorization information present; block access
            if(authorization == null || authorization.isEmpty())
            {
            	throw new NotAuthorizedException("Bearer");
               // requestContext.abortWith(ACCESS_DENIED);
               // return;
            }
              
                      	
            System.out.println(authorization.get(0));
            //Get encoded username and password
            
            final StringTokenizer findAuthenticationScheme = new StringTokenizer(authorization.get(0)," ");
            
            final String authType = findAuthenticationScheme.nextToken();
            final String encodedUserPassword = findAuthenticationScheme.nextToken();
            
            System.out.println(authType +"!");
           
            
            if(!authType.equals(AUTHENTICATION_SCHEME))
            {     
            	throw new NotAuthorizedException("Bearer");

            	//requestContext.abortWith(ACCESS_DENIED);
                //return;            	
            }
            
            //final String  = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");
            System.out.println(encodedUserPassword);
            //Decode username and password
            String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));;
  
            
            //Split username and password tokens
            final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
            final String username = tokenizer.nextToken();
            final String password = tokenizer.nextToken();
           
              
            //Verifying Username and password
            System.out.println(username);
            System.out.println(password);
              
            //Verify user access
            if(method.isAnnotationPresent(RolesAllowed.class))
            {
            	
                RolesAllowed rolesAnnotation = method.getAnnotation(RolesAllowed.class);
                Set<String> rolesSet = new HashSet<String>(Arrays.asList(rolesAnnotation.value()));
                  
                //Is user valid?
                if( ! isUserAllowed(username, password, rolesSet))
                {
                	throw new NotAuthorizedException("Bearer");

                    //requestContext.abortWith(ACCESS_DENIED);
                    //return;
                }
            }
        }
        
    } 
    	
    catch (NoSuchElementException nse)
      {
    	throw new NotAuthorizedException("Bearer");
       	//requestContext.abortWith(ACCESS_DENIED);
        //return;
        		
        }
    }
    private boolean isUserAllowed(final String username, final String password, final Set<String> rolesSet)
    {
        boolean isAllowed = false;
          
        //Step 1. Fetch password from database and match with password in argument
        //If both match then get the defined role for user from database and continue; else return isAllowed [false]
        //Access the database and do this part yourself
        //String userRole = userMgr.getUserRole(username);
         
        if(username.equals("megha") && password.equals("password"))
        {
            String userRole = "ADMIN";
             
            //Step 2. Verify user role
            if(rolesSet.contains(userRole))
            {
                isAllowed = true;
            }
        }
        return isAllowed;
    }
}