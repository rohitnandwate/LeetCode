package com.rhn.algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class CombinationSumTest {

	private CombinationSum2 sum = new CombinationSum2();
	
	@Test
	public void test() {
		int[] c = {10,1,2,7,6,1,5};
		System.out.println(sum.combinationSum2(c, 8));
	}

}
