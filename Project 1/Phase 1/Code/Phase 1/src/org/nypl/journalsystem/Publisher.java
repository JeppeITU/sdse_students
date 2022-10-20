package org.nypl.journalsystem;

public class Publisher {
	private int ID;
	private String firstName;
	private String lastName;
	private String location;
	
	public Publisher(int iD, String firstName, String lastName) {
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String toString(){
		//Overrides String.toString method, to easily print contents of class Publisher
		String returnString = "ID: " + String.valueOf(ID) + ", Name: " + firstName + 
				" " + lastName;
		if (location != null) {
			returnString += ", Location: " + location;
		}
		return returnString;
	}

}
