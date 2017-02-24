package main.java;

import java.util.ArrayList;
import java.util.HashMap;

 
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class initialization {
 
	public static HashMap<Character, Integer> hash = new HashMap<Character,Integer>();
	public static HashMap<Integer, ArrayList<String>> anagrams= new HashMap<Integer, ArrayList<String>>();
	

  
	    public String InitializedVariables() 
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
			
				

				
				BufferedReader	abc = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/wordsEn.txt")));
				//BufferedReader	abc = new BufferedReader(new FileReader("C:/Users/mbet/workspace/AnagramFinder/AnagramFinder/src/wordsEn.txt"));		
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
		     
			hash.put('a', 2);hash.put('b', 3);hash.put('c', 5);hash.put('d', 7);
			 hash.put('e', 11);hash.put('f', 13);hash.put('g', 17);hash.put('h', 19);
			 hash.put('i', 23);hash.put('j', 29);hash.put('k', 31);hash.put('l', 37);
			 hash.put('m', 41);hash.put('n', 43);hash.put('o', 47);hash.put('p', 53);
			 hash.put('q', 59);hash.put('r', 61);hash.put('s', 67);hash.put('t', 71);
			 hash.put('u', 73);hash.put('v', 79);hash.put('w', 83);hash.put('x', 89);
			 hash.put('y', 91);hash.put('z', 97);
				
				     
				     
				     
		     for(int i = 0; i < data.length; i++) {
		    	 
		    	 int prod=1;
				 for (int j = 0; j < data[i].length(); j++) {
				    
					 prod= prod*hash.get(data[i].charAt(j));
				    	 
				 }
				   	 
				 if(anagrams.get(prod)==null) {
					
					 ArrayList<String> wordList = new ArrayList<String>();
				     wordList.add(data[i]);
				     anagrams.put(prod, wordList);
				  }
				    	
				 else {
				 
					 ArrayList<String> wordList = new ArrayList<String>();
				     wordList=anagrams.get(prod);
				   	 wordList.add(data[i]);
				     anagrams.put(prod, wordList);		    		
				   }		    	 
				}    
				
		     //System.out.println(anagrams.size()); 
				
		   
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
			return "done";

	        
	   }//end contextInitialized method


	    public void contextDestroyed(ServletContextEvent arg0) 
	    {
	    	 
	    }//end constextDestroyed method


		 

	}


