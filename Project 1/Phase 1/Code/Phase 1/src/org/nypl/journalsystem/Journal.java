package org.nypl.journalsystem;

import java.util.ArrayList;

public class Journal {
	private String name;
	private Publisher publisher;
	private String ISSN;
	private ArrayList<Article> articleList = new ArrayList<Article>();

	public Journal(String name, Publisher publisher, String iSSN) {
		super();
		this.name = name;
		this.publisher = publisher;
		ISSN = iSSN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public String getISSN() {
		return ISSN;
	}

	public void setISSN(String iSSN) {
		ISSN = iSSN;
	}

	public ArrayList<Article> getArticleList() {
		return articleList;
	}

	public void setArticleList(ArrayList<Article> articleList) {
		this.articleList = articleList;
	}
	//Test to add article to list
	public void addToArticleList(Article newArticle) {
		this.articleList.add(newArticle);
	}
	public String toString() {
		String returnString = "Journal: " + name + ", " + publisher + ", ISSN: " + ISSN + ", Articles: " + articleList + "\n";
		//Adds mark to journals that are not a full issue (less than 3 articles)
		if (articleList.size() < 3)
		returnString = "*" + returnString;
		return returnString;
	}
		
}
