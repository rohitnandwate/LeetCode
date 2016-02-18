package com.rhn.algorithms;

import java.util.Arrays;

import org.junit.Test;

import com.rhn.algorithms.util.Interval;

public class InsertIntervalTest {
	
	private InsertInterval in = new InsertInterval();

	@Test
	public void test() {
		System.out.println(in.insert(
				Arrays.asList(	new Interval(1, 5 )), 
				new Interval(2,3)));
		
		System.out.println(in.insert(
				Arrays.asList(	new Interval(1, 5 ),
						 		new Interval(6,7),
						 		new Interval(8,11),
						 		new Interval(13,16)), 
				new Interval(2,3)));
		
		System.out.println(in.insert(
				Arrays.asList(	new Interval(1, 5 ),
						 		new Interval(6,7),
						 		new Interval(8,11),
						 		new Interval(13,16)), 
				new Interval(2,7)));
		
		
		System.out.println(in.insert(
				Arrays.asList(	new Interval(1, 5 ),
						 		new Interval(6,7),
						 		new Interval(8,11),
						 		new Interval(13,16)), 
				new Interval(4,10)));
		
		System.out.println(in.insert(
				Arrays.asList(	new Interval(1, 5 ),
						 		new Interval(6,7),
						 		new Interval(8,11),
						 		new Interval(13,16)), 
				new Interval(5,12)));
		
		System.out.println(in.insert(
				Arrays.asList(	new Interval(1, 5 )), 
				new Interval(6,8)));
		
		System.out.println(in.insert(
				Arrays.asList(	new Interval(2, 5 ),
						new Interval(6,7),
				 		new Interval(8,11),
				 		new Interval(13,16)), 
				new Interval(0,1)));
		
	}

}
