package org.nypl.journalsystem;

public class Author {
	private int ID;
	private String firstName;
	private String lastName;
	
	public Author(int iD, String firstName, String lastName) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String toString(){
		//Overrides String.toString method, to easily print contents of class Publisher
		return firstName + " " + lastName;
	}
}
