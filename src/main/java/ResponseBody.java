package main.java;

import java.util.ArrayList;
//import java.util.List;

public class ResponseBody {

	String EnteredWord;
	ArrayList<String> Anagrams ;
	
	void SetEnteredWord(String msg) {
	this.EnteredWord=msg;
	}
	public void SetAnagrams(ArrayList<String> value) {
		this.Anagrams = value;
	}

	 
}
