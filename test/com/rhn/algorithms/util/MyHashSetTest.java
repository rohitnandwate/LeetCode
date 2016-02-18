package com.rhn.algorithms.util;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MyHashSetTest {

	Set<String> set;
	
	@Before
	public void setup() {
		set = new MyHashSet<String>();
	}
	
	@Test
	public void testDuplicateAdd() {
		assertTrue(set.isEmpty());
		set.add("Test");
		set.add("Test");
		assertEquals(1, set.size());
		assertTrue(set.contains("Test"));
	}
	
	@Test
	public void testAdd() {
		assertTrue(set.isEmpty());
		for(int i=0; i<10; ++i) {
			set.add("Test"+i);
		}
		assertEquals(10, set.size());
		for(int i=0; i<10; ++i) {
			assertTrue(set.contains("Test"+i));
		}
	}
	
	@Test
	public void testRemove() {
		
	}
	
	@Test
	public void testClear() {
		
	}
	
	@Test 
	public void testSameHashCodeScenario() {
		
	}
	
}
