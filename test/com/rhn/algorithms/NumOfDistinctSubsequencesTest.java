package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumOfDistinctSubsequencesTest {

	private NumOfDistinctSubsequences n = new NumOfDistinctSubsequences();
	@Test
	public void test() {
		n.numDistinct("rabbbit", "rabbit");
	}

}
