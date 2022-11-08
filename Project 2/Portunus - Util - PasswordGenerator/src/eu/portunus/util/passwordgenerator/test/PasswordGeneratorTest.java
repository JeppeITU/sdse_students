package eu.portunus.util.passwordgenerator.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import eu.portunus.util.passwordgenerator.CharacterSet;
import eu.portunus.util.passwordgenerator.PasswordGenerator;

public class PasswordGeneratorTest {
	//TODO: Write tests for the password generator.
	private PasswordGenerator g;
	@BeforeEach
	public void setup() {
		g = new PasswordGenerator();
	}
	
	@Test
	public void testEmptyPw() {
		String password = g.generatePassword(1, null);
		assertEquals("", password);
	}
	@Test
	public void testPwGen() {
		Collection<CharacterSet> bs = new ArrayList<CharacterSet>();
		bs.add(CharacterSet.DIGITS);
		bs.add(CharacterSet.UNDERSCORE);
		bs.add(CharacterSet.UPPER_CASE);
		
		String password = g.generatePassword(5, bs);
		System.out.println(password);
	}
	@Test
	public void testNegativeLength() {
		Collection<CharacterSet> bs = new ArrayList<CharacterSet>();
		bs.add(CharacterSet.UPPER_CASE);
		
		String password = g.generatePassword(-5, bs);
		System.out.println(password);
		assertEquals("", password);
		
	}
	
		
	
	
}
