package test.java;



//import javax.ws.rs.GET;
//import javax.ws.rs.Path;


import org.glassfish.jersey.test.JerseyTest;
import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.glassfish.jersey.server.ResourceConfig;
 
import javax.ws.rs.core.Application;

public class SimpleTest extends JerseyTest {
	 
	
	 @Override
	    protected Application configure() {
	        return new ResourceConfig(main.java.anagramFinder.class);
	    }
	 
	 
    @Test
    public void HappyPath() {
    	try {
    		
       final String data = target("findAnagrams/cat").request().get(String.class);
       System.out.println(data);
       //assertEquals("Hello World!", "Hello World!");
    	//JSONObject data = target("findAnagrams/cat").request().get(String.class);
    	//String expected = "{friends:[{id:123,name:\"Corby Page\"},{id:456,name:\"Carter Page\"}]}";
    	String expected = "{\"EnteredWord\":\"cat\",\"Anagrams\":[\"act\",\"cat\"]}";
    	
			JSONAssert.assertEquals(expected, data, false);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}   	
    }

    
      
}
