package org.nypl.journalsystem;

import java.util.ArrayList;

public class Article {
	private int ID;
	private String Title;
	private ArrayList<Integer> AuthorIDs;
	private String ISSN;
	
	public Article(int iD, String title, ArrayList<Integer> authorIDs, String iSSN) {
		super();
		ID = iD;
		Title = title;
		AuthorIDs = authorIDs;
		ISSN = iSSN;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public ArrayList<Integer> getAuthorIDs() {
		return AuthorIDs;
	}
	public void setAuthorIDs(ArrayList<Integer> authorIDs) {
		AuthorIDs = authorIDs;
	}
	public String getISSN() {
		return ISSN;
	}
	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}
	
	public String toString(){
		//Overrides String.toString method, to easily print contents of class Article
		return "ID: " + String.valueOf(ID) + ", Title: " + Title + 
				", AuthorIDs: " + String.valueOf(AuthorIDs) + ", ISSN: " + ISSN;
	}	
}