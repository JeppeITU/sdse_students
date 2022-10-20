package org.nypl.journalsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class LibrarySystem {
	
	public LibrarySystem() {
		//TODO: Initialize system with default journals.
		
		//Making publishers first
		Publisher springer = new Publisher("Springer", "Germany");
		Publisher elsevier = new Publisher("Elsevier", "Netherlands");
		Publisher natureResearch = new Publisher("Nature Research", "Great Britain");
		
		//Journals
		Journal higherEducation = new Journal("Higher Education", springer, "0018-1560");
		Journal system = new Journal("System", elsevier, "0346-2511");
		Journal chem = new Journal("Chem", elsevier, "2451-9294");
		Journal nature = new Journal("Nature", natureResearch, "1476-4687");
		Journal Society = new Journal("Society", springer, "0147-2011");
	}
	
	public void load() throws FileNotFoundException, IOException {
		loadAuthors();
		loadArticles();
	}
	
	protected void loadAuthors() throws FileNotFoundException, IOException {
		Reader file = new FileReader("data/Authors.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(file);
		//Iterate over every row in Authors file
		for (CSVRecord currentRecord: records) {
			int currentID = convertToInt(currentRecord.get(0));
			String lastName = convertToString(currentRecord.get(1));
			String firstName = convertToString(currentRecord.get(2));
			
			Author currentPublisher = new Author(currentID, lastName, firstName);
			System.out.println(currentPublisher);
		}
		
		
		//TODO: Load authors from file 
	}
	
	protected void loadArticles() throws FileNotFoundException, IOException {
		Reader file = new FileReader("data/Articles.csv");
		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(file);
		//Iterate over every row in Articles file
		for (CSVRecord currentRecord: records) {			
			int currentID = convertToInt(currentRecord.get(0));
			String currentTitle = convertToString(currentRecord.get(1));
			ArrayList<Integer> currentAuthorIDs = convertToList(currentRecord.get(2));
			String currentISSN = convertToString(currentRecord.get(3));
			
			//Make article from a single row
			Article currentArticle = new Article(currentID, currentTitle, currentAuthorIDs, currentISSN);
			
			//System.out.println(currentArticle);
		}
		
		
		
		//TODO: Load articles from file and assign them to appropriate journal
	}
	
		public void listContents() {
		//TODO: Print all journals with their respective articles and authors to the console.
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
			rawValue = rawValue.replaceAll("^\"|\"$", "");
			/*if (rawValue.startsWith("\"") && rawValue.endsWith("\"")) {
				return rawValue.substring(1, rawValue.length() - 1);
			}*/
			
			return rawValue;
		}
		private ArrayList<Integer> convertToList(String rawValue) {
			rawValue = rawValue.replaceAll("\\[|\\]", "");
			ArrayList<Integer> finalList = new ArrayList<Integer>();
			ArrayList<String> tempList = new ArrayList<String>(Arrays.asList(rawValue.split(";")));
			for (String i: tempList) {
				finalList.add(convertToInt(i));
			}
			return finalList;
		}
		
		
	public static final void main(String[] args) throws Exception {
		LibrarySystem librarySystem = new LibrarySystem();
		
		librarySystem.load();
		librarySystem.listContents();
	}
}
