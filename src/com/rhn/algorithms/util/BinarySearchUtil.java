package com.rhn.algorithms.util;


public class BinarySearchUtil {

	/**
	 * Find the rotation point in a sorted rotated array.
	 * The rotation point is index of the smallest element in the sorted array
	 * 
	 * @param arr
	 * @param start of sorted rotated array (inclusive)
	 * @param end of sorted rotated array (inclusive)
	 * @return index of the rotation point, i.e the index of the smallest element in the array
	 */
	public static int findRotationPoint(int[] arr, int start, int end) {
		if(start == end) {
			return start;
		}
		int mid = ((end-start)/2) + start;
		boolean leftSorted = arr[start] < arr[mid];
		boolean rightSorted = arr[mid+1] < arr[end];
		if((leftSorted && rightSorted) || start == mid ) {
			if(arr[mid] < arr[mid+1]) {
				return start;
			} else {
				return mid+1;
			}
		} else if(leftSorted) {
			return findRotationPoint(arr, mid+1, end);
		} else {
			return findRotationPoint(arr, start, mid);
		}
	}
	
	/**
	 * Search for target in the given sorted rotated array
	 * @param arr
	 * @param start
	 * @param end
	 * @param target
	 * @return index of target if found, -1 otherwise
	 */
	public static int rotatedSearch(int[] arr, int start, int end, int target) {
		if(start == end) {
			return arr[start] == target ? start : -1;
		}
		int mid = ((end-start)/2) + start;
		boolean leftSorted = arr[start] < arr[mid];
		boolean rightSorted = arr[mid+1] < arr[end];
		if((leftSorted && rightSorted) || start == mid ) {
			int leftSearch = binSearch(arr, start, mid, target);
	        if(leftSearch == -1) {
	        	return binSearch(arr, mid+1, end, target);
	        }
	        return leftSearch;
		} else if(leftSorted) {
			int leftSearch = binSearch(arr, start, mid, target);
			if(leftSearch == -1) {
				return rotatedSearch(arr, mid+1, end, target);
			}
			return leftSearch;
		} else {
			int rightSearch = binSearch(arr, mid+1, end, target);
			if(rightSearch == -1) {
				return rotatedSearch(arr, start, mid, target);
			}
			return rightSearch;
		}
	}
	
	public static int binSearch(int[] arr, int start, int end, int key) {
		if(start > end) {
			return -1;
		}
		int mid =  ((end-start)/2)+start;
		if(key == arr[mid]) {
			return mid;
		} else if(key > arr[mid]) {
			return binSearch(arr, mid+1, end, key);
		} else {
			return binSearch(arr, start, mid-1, key);
		}
	}
	
}
