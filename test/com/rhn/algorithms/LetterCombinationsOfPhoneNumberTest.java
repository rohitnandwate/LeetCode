package com.rhn.algorithms;

import org.junit.Before;
import org.junit.Test;

public class LetterCombinationsOfPhoneNumberTest {

	private LetterCombinationsOfPhoneNumber com;
	
	@Before
	public void setup() {
		com = new LetterCombinationsOfPhoneNumber();
	}
	
	@Test
	public void test() {
		System.out.println(com.letterCombinations("23"));
	}

}
