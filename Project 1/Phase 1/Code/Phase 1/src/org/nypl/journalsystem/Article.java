package org.nypl.journalsystem;

import java.util.ArrayList;

public class Article {
	private int ID;
	private String Title;
	private ArrayList<Integer> AuthorIDs;
	private String ISSN;
	private ArrayList<Author> authors = new ArrayList<Author>();
	
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
	public ArrayList<Author> getAuthorNames() {
		return authors;
	}

	public void addAuthor(Author newAuthor) {
		this.authors.add(newAuthor);
	}
	
	public String toString(){
		//Overrides String.toString method, to easily print contents of class Article
		return "\nTitle: " + Title + 
				", Authors: " + authors.toString();
	}	
}