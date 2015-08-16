package com.rhn.algorithms;

class BinarySearch {
	
	/**
	 * Find the index  of largest number in the given arr that is less than or equal to the key
	 * @param arr input array
	 * @param key value we are looking for
	 */
	public static int largestNumLessThanOrEqualsToKey(int[] arr, int key) {
		int start = 0;
		int end = arr.length-1;
		return largestNumLessThanOrEqualToKeyHelper(arr, start, end, key);
	}

	private static int largestNumLessThanOrEqualToKeyHelper(int[] arr, int start,
			int end, int key) {
		if (start > end) {
			return -1;
		}
		if(start == end) {
			return arr[start] <= key ? start : -1;
		}
		int mid = (start+end)/2;
		if(arr[mid] <= key) {
			if (arr[mid+1] > key) {
				return mid;
			} else {
				return largestNumLessThanOrEqualToKeyHelper(arr, mid+1, end, key);
			}
		} else {
			return largestNumLessThanOrEqualToKeyHelper(arr, start, mid-1, key);
		}
	}
	
	/**
	 * Find the insertion point of an input value in a sorted arr
	 * @param sortedArr
	 * @param val
	 * @return index after which the input value must be inserted. 
	 * If the input value is the smaller than all the numbers in the array, then return -1.
	 */
	public static int findInsertionPoint (int[] sortedArr, int val) {
		if(sortedArr.length == 0) {
			return -1;
		}
		return insertionPointHelper(sortedArr, 0, sortedArr.length-1, val);
	}

	private static int insertionPointHelper(int[] arr, int start, int end, int val) {
		if(start == end) {
			return arr[start] > val ? -1 :start;
		}
		if(end - start == 1) {
			if(val >= arr[start]){
				return val < arr[end] ? start : end;
			} else { 
				return start-1;
			}
		}
		int mid = (start+end)/2;
		if(arr[mid] > val) {
			return insertionPointHelper(arr, 0, mid-1, val);
		}
		
		return insertionPointHelper(arr, mid, end, val);
	}
	
}
