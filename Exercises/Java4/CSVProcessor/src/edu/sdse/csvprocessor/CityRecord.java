package edu.sdse.csvprocessor;

public class CityRecord {
	//Values to store
	int id;
	int year;
	String city;
	int population;

	//Constructor
	public CityRecord(int id, int year, String city, int population) {
		super();
		this.id = id;
		this.year = year;
		this.city = city;
		this.population = population;
		
	}
	
	
	public String toString(){
		//Overrides String.toString method, to easily print contents of class CityRecord
		return "id: " + String.valueOf(id) + ", Year: " + String.valueOf(year) + 
				", City: " + city + ", Population: " + String.valueOf(population);
	}
	
	
}
