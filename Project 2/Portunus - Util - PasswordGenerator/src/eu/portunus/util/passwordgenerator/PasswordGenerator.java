package eu.portunus.util.passwordgenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class PasswordGenerator implements IPasswordGenerator {
	String upperCase;
	String lowerCase;
	String digits;
	String minus;
	String underscore;
	String space;
	HashMap<CharacterSet, String> charSets;
	
	public PasswordGenerator() {
		super();
		upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		lowerCase = "abcdefghijklmnopqrstuvwxyz";
		digits = "0123456789";
		minus =  "-";
		underscore = "_";
		space = " ";
		charSets = new HashMap<CharacterSet, String>();
		
		charSets.put(CharacterSet.UPPER_CASE, upperCase);
		charSets.put(CharacterSet.LOWER_CASE, lowerCase);
		charSets.put(CharacterSet.DIGITS, digits);
		charSets.put(CharacterSet.MINUS, minus);
		charSets.put(CharacterSet.UNDERSCORE, underscore);
		charSets.put(CharacterSet.SPACE, space);
	}	
	
	@Override
	public String generatePassword(int length, Collection<CharacterSet> characterSets) {
		if (characterSets == null || characterSets.isEmpty() || length <=0) {
			return "";
		}
		//TODO: Implement the password generator.
		
		//Idea: Add all sets of characters together, pick int uniformly at random from 0 to sum of characters (inc.)
		//Then add the character at that index to the password. Repeat n times.
		//...Or just choose collection randomly, and then choose one of the chars in that to add to password.
		Random random = new Random();
		String allSets = "";
		int rInt;
		String password = "";
		
		//Remove duplicate characterSets
		Set<CharacterSet> setCharacterSets = new HashSet<CharacterSet>(characterSets);
		
		//Concatenate all Strings from charactersets to one long string
		for(CharacterSet temp: setCharacterSets) {
			allSets += charSets.get(temp);
		}
		
		//Pick random int, add character at index rInt to password
		for(int i=0; i<length; i++) {
			rInt = random.nextInt(allSets.length());
			password += allSets.charAt(rInt); 
		}
		
		
		return password;
	}

	
}
