package com.rhn.algorithms;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SpiralMatrixTest {

	private SpiralMatrix spiral = new SpiralMatrix();
	
	@Test
	public void test_0() {
		int[][] matrix = {	{ 1}};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(2, cnt);
	}


	@Test
	public void test_1() {
		int[][] matrix = {	{ 1, 2, 3, 4, 5, 6, 7, 8 },
							{18,19,20,21,22,23,24, 9 },
							{17,16,15,14,13,12,11,10 }};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(25, cnt);
	}
	
	
	@Test
	public void test_2() {
		int[][] matrix = {	{ 1, 2, 3, 4, 5, 6, 7, 8 }};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(9, cnt);
	}
	
	
	@Test
	public void test_3() {
		int[][] matrix = {	{ 1},
							{ 2},
							{ 3},
							{ 4},
							{ 5},
							{ 6},
							{ 7},
							{ 8}};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(9, cnt);
	}
	
	@Test
	public void test_4() {
		int[][] matrix = {	{ 1, 2}};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(3, cnt);
	}
	
	
	@Test
	public void test_5() {
		int[][] matrix = {	{ 1},
							{ 2}};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(3, cnt);
	}
	
	@Test
	public void test_6() {
		int[][] matrix = {	{ 1, 2, 3, 4, 5},
							{ 10,9, 8, 7, 6}};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(11, cnt);
	}
	
	
	@Test
	public void test_7() {
		int[][] matrix = {	{ 1, 2},
							{ 4, 3}};
		int cnt=1;
		for (int i : spiral.spiralOrder(matrix)) {
			assertEquals(cnt, i);
			cnt++;
		}
		assertEquals(5, cnt);
	}
	
	@Test
	public void test_8() {
		int[][] matrix = {	{ 2, 3, 4},
							{ 5, 6, 7},
							{ 8, 9,10},
							{11,12,13},
							{14,15,16}};
		
		List<Integer> ans = Arrays.asList(2,3,4,7,10,13,16,15,14,11,8,5,6,9,12);
		assertEquals(ans, spiral.spiralOrder(matrix));
		
	}
	
	@Test
	public void test_9() {
		int[][] matrix = {	{ 1,11},
							{ 2,12},
							{ 3,13},
							{ 4,14},
							{ 5,15},
							{ 6,16},
							{ 7,17},
							{ 8,18},
							{ 9,19},
							{10,20}};
		
		List<Integer> ans = Arrays.asList(1,11,12,13,14,15,16,17,18,19,20,10,9,8,7,6,5,4,3,2);
		assertEquals(ans, spiral.spiralOrder(matrix));
		
	}
	
	@Test
	public void test_10() {
		int[][] matrix = {	{ 1,21,11},
							{ 2,22,12},
							{ 3,23,13},
							{ 4,24,14},
							{ 5,25,15},
							{ 6,26,16},
							{ 7,27,17},
							{ 8,28,18},
							{ 9,29,19},
							{10,30,20}};
		
		List<Integer> ans = Arrays.asList(1,21,11,12,13,14,15,16,17,18,19,20,30,10,9,8,7,6,5,4,3,2,22,23,24,25,26,27,28,29);
		assertEquals(ans, spiral.spiralOrder(matrix));
		
	}
}
