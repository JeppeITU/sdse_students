package edu.sdse.csvprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class CityCSVProcessor {
	
	public void readAndProcess(File file) {
		//Try with resource statement (as of Java 8)
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			//Discard header row
			br.readLine();
			//Make list
			ArrayList<CityRecord> allRecords = new ArrayList<CityRecord>();
			//make Hashmap
			HashMap<String, ArrayList<CityRecord>> city_map = new HashMap<String, ArrayList<CityRecord>>();
			String line;
			
			while ((line = br.readLine()) != null) {
				// Parse each line
				String[] rawValues = line.split(",");
				
				int id = convertToInt(rawValues[0]);
				int year = convertToInt(rawValues[1]);
				String city = convertToString(rawValues[2]);
				int population = convertToInt(rawValues[3]);
				
				//Create new CityRecord and print it
				CityRecord current_record = new CityRecord(id, year, city, population);
				//System.out.println(current_record);
				
				//Put CityRecord in list
				allRecords.add(current_record);
				
				//Add to map
				if(city_map.containsKey(city)) {
					//if list already exists
					city_map.get(city).add(current_record);
				}
				else {
					//Create new list
					ArrayList<CityRecord> city_list = new ArrayList<CityRecord>();
					city_list.add(current_record);
					city_map.put(city, city_list);
				}
				
				//System.out.println("id: " + id + ", year: " + year + ", city: " + city + ", population: " + population);
				//TODO: Extend the program to process entries!
			}
			
			//For each key in HashMap
			for (Entry<String, ArrayList<CityRecord>> entry : city_map.entrySet()) {
				//entry = HashMap
				int total_entries = 0;
				int minimum_year = 3000; //high number to initialise variable
				int maximum_year = 0;
				int sum_population = 0;

				//Iterate over values in Hashmap (all CityRecords for a given city)
				for (CityRecord record : entry.getValue() ) {
					total_entries += 1;
					sum_population += record.population;
					if(record.year < minimum_year) {
						minimum_year = record.year;
					}
					if(record.year > maximum_year) {
						maximum_year = record.year;
					}
					
				}
				//Report for each City
				System.out.printf("Average population of %s (%d-%d; %d Entries): %d\n",
						entry.getKey(), minimum_year, maximum_year, total_entries,
						sum_population/total_entries);
				
			}
			
		} catch (Exception e) {
			System.err.println("An error occurred:");
			e.printStackTrace();
		} 
	}
	
	private String cleanRawValue(String rawValue) {
		return rawValue.trim();
	}
	
	private int convertToInt(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		return Integer.parseInt(rawValue);
	}
	
	private String convertToString(String rawValue) {
		rawValue = cleanRawValue(rawValue);
		
		if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {
			return rawValue.substring(1, rawValue.length() - 1);
		}
		
		return rawValue;
	}
	
	public static final void main(String[] args) {
		CityCSVProcessor reader = new CityCSVProcessor();
		
		File dataDirectory = new File("data/");
		File csvFile = new File(dataDirectory, "Cities.csv");
		
		reader.readAndProcess(csvFile);
		
	}
}
