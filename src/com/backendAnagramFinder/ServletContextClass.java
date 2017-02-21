package com.backendAnagramFinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


public class ServletContextClass implements ServletContextListener
{
           
    public void contextInitialized(ServletContextEvent arg0) 
    {
    	String line;
    	InputStream inputStream;
    	
    	//Properties prop = new Properties();
		//String propFileName = "prod.properties";
		//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		
		try {
		//if (inputStream != null) {
			
			//	prop.load(inputStream);
			 
			//System.out.println("asdjhasjkLLAMALAJSD");
		//} 
		
		//else {
			//throw new RuntimeException("property file '" + propFileName + "' not found in the classpath");
			//throw new FileNotFoundException();
			
		//}
		
		
		//String pathToDictionary=prop.getProperty("dictionaryPath");
		
	 	
			BufferedReader	abc = new BufferedReader(new FileReader("/var/lib/tomcat8/webapps/ROOT/WEB-INF/resources/wordsEn.txt"));		
			ArrayList<String> lines = new ArrayList<String>();			 
			
			
			while((line = abc.readLine()) != null) {
					
					line=line.toLowerCase();
					line=line.replaceAll("[^\\w\\s]","");
				    lines.add(line);				    
			} 
		
		abc.close();
		// If you want to convert to a String[]
		String[] data = lines.toArray(new String[]{});
		System.out.println(data[0]);
			
		System.out.println("3");
	     
		initialization.hash.put('a', 2);initialization.hash.put('b', 3);initialization.hash.put('c', 5);initialization.hash.put('d', 7);
		 initialization.hash.put('e', 11);initialization.hash.put('f', 13);initialization.hash.put('g', 17);initialization.hash.put('h', 19);
		 initialization.hash.put('i', 23);initialization.hash.put('j', 29);initialization.hash.put('k', 31);initialization.hash.put('l', 37);
		 initialization.hash.put('m', 41);initialization.hash.put('n', 43);initialization.hash.put('o', 47);initialization.hash.put('p', 53);
		 initialization.hash.put('q', 59);initialization.hash.put('r', 61);initialization.hash.put('s', 67);initialization.hash.put('t', 71);
		 initialization.hash.put('u', 73);initialization.hash.put('v', 79);initialization.hash.put('w', 83);initialization.hash.put('x', 89);
		 initialization.hash.put('y', 91);initialization.hash.put('z', 97);
			
			     
			     
			     
	     for(int i = 0; i < data.length; i++) {
	    	 
	    	 int prod=1;
			 for (int j = 0; j < data[i].length(); j++) {
			    
				 prod= prod*initialization.hash.get(data[i].charAt(j));
			    	 
			 }
			   	 
			 if(initialization.anagrams.get(prod)==null) {
				
				 ArrayList<String> wordList = new ArrayList<String>();
			     wordList.add(data[i]);
			     initialization.anagrams.put(prod, wordList);
			  }
			    	
			 else {
			 
				 ArrayList<String> wordList = new ArrayList<String>();
			     wordList=initialization.anagrams.get(prod);
			   	 wordList.add(data[i]);
			     initialization.anagrams.put(prod, wordList);		    		
			   }		    	 
			}    
			
	     //System.out.println(initialization.anagrams.size()); 
			
	   
	    	        System.out.println(new java.io.File("").getAbsolutePath());
	    	        System.out.println(ServletContextClass.class.getClassLoader().getResource("").getPath());
	    	    
	     
	     
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 catch (IOException e) {
				// TODO Auto-generated catch block
			     e.printStackTrace();
				throw new RuntimeException("IO Exception encountered");

			}

        
   }//end contextInitialized method


    public void contextDestroyed(ServletContextEvent arg0) 
    {
    	 
    }//end constextDestroyed method


	 

}