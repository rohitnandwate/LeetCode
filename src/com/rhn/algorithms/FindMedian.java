package com.rhn.algorithms;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * @author rohitnandwate
 *
 */
public class FindMedian {

	/**
	 * O(m+n) runtime performance 
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int middle = (m+n) % 2 == 0 ? ((m+n)/2)-1 : (m+n)/2;
        int i=0, j=0, cnt=0; 
        double med;
        while(i < nums1.length || j < nums2.length) {
            if(i < nums1.length && j < nums2.length) {
                if(nums1[i] <= nums2[j]) {
                    med = nums1[i];
                    i++;
                } else {
                    med = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                med = nums1[i];
                i++;
            } else {
                med = nums2[j];
                j++; 
            }
            
            if(cnt == middle) {
                if((m+n)%2 == 0) {
                    //even
                    return (med + nextMiddle(nums1, nums2, i ,j))/2;
                } else {
                    return med;
                }
            }
            cnt++;
        }
        return 0;
    }
    
    private static double nextMiddle(int[] nums1, int[] nums2, int i, int j) {
        if(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                return nums1[i];
            } else {
                return nums2[j];
            }
        } else if (i < nums1.length) {
            return nums1[i];
        } else {
            return nums2[j];
        }
    }
    
    public static double findMedianSortedArrays_fast(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	int medCnt = (m+n+1)/2; // size of the first half of the merged array including the median
    	if(n > m) {
    		return fastHelper(nums2, nums1, 0, n-1, medCnt);
    	} else {
    		return fastHelper(nums1, nums2, 0, m-1, medCnt);
    	}
    }

	private static double fastHelper(int[] big, int[] small, int start, int end, int medCnt) {
		if(start > end) {
			return 0;
		} 
		int mid = (start + end)/2;
		int smallContrib = BinarySearch.largestNumLessThanOrEqualsToKey(small, big[mid]);
		if(start == end && smallContrib == 0) {
			return (double)(big[mid] + small[smallContrib])/ 2l;
		}
		if(smallContrib < 0) {
			double med1 = big[mid];
			if((big.length + small.length ) % 2 ==0) {
				double med2;
				if(mid+1 < big.length && smallContrib+1 < small.length) {
					med2 = big[mid+1] < small[smallContrib+1] ? big[mid+1] : small[smallContrib+1];
				} else if(mid+1 < big.length) {
					med2 = big[mid+1];
				} else if(smallContrib+1 < small.length) {
					med2 = small[smallContrib+1];
				} else {
					med2 = big[mid] > small[smallContrib] ? small[smallContrib] : big[mid];
				}
				med1 = (med1+med2)/2;
			}
			return med1;
		}
		if(smallContrib+1 + mid+1 == medCnt) {
			double med1 = big[mid] > small[smallContrib] ? big[mid] : small[smallContrib];
			
			if((big.length + small.length ) % 2 ==0) {
				double med2;
				if(mid+1 < big.length && smallContrib+1 < small.length) {
					med2 = big[mid+1] < small[smallContrib+1] ? big[mid+1] : small[smallContrib+1];
				} else if(mid+1 < big.length) {
					med2 = big[mid+1];
				} else if(smallContrib+1 < small.length) {
					med2 = small[smallContrib+1];
				} else {
					med2 = big[mid] > small[smallContrib] ? small[smallContrib] : big[mid];
				}
				med1 = (med1+med2)/2;
			}
			return med1;
		} else if(smallContrib+1 + mid+1 < medCnt) {
			return fastHelper(big, small, mid+1, end, medCnt);
		} else {
			return fastHelper(big, small, start, mid-1, medCnt);
		}
	}
}
