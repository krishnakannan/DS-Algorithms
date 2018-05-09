import java.util.*;
import java.lang.*;   
import java.io.*;

//Inspired Solution - https://leetcode.com/problems/count-of-range-sum/discuss/77991/Short-and-simple-O(n-log-n)

class CountOfRangeSum {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		int lower = in.nextInt();
		int higher = in.nextInt();
		CountOfRangeSum crs = new CountOfRangeSum();
		System.out.println(crs.countRangeSum(nums, lower, higher));
	}

	int inRange = 0;

    public int countRangeSum(int[] nums, int lower, int upper) {
		
		long[] prefixSums = new long[nums.length];
		prefixSums[0] = nums[0];
		for (int i = 1; i < prefixSums.length; i++) {
			prefixSums[i] = prefixSums[i - 1] + nums[i];
		}        
        //System.out.println(Arrays.toString(prefixSums));
		split(prefixSums, lower, upper, 0, prefixSums.length - 1);
        //System.out.println(Arrays.toString(prefixSums));
        return inRange;
    }

    public void split(long[] prefixSums, int lowerRange, int upperRange, int left, int right) {

    	if (left > right) {
    		return;
    	}

        if (left == right) {
            if (prefixSums[left] >= lowerRange && prefixSums[left] <= upperRange) {
                inRange += 1;
            }
            return;
        }

    	int mid = left + ((right - left) / 2);

    	split(prefixSums, lowerRange, upperRange, left, mid);
    	split(prefixSums, lowerRange, upperRange, mid + 1, right);

    	int lIndex = mid + 1;
    	int hIndex = mid + 1;

    	for (int i = left; i <= mid; i++) {
    		while (lIndex <= right && prefixSums[lIndex] - prefixSums[i] < lowerRange) {
    			lIndex += 1;
    		}
    		while (hIndex <= right && prefixSums[hIndex] - prefixSums[i] <= upperRange) {
    			hIndex += 1;
    		}

    		inRange += hIndex - lIndex;
    	}
    	merge(prefixSums, left, right, mid);
    }

    public void merge(long[] prefixSums, int left, int right, int mid) {
    	long[] merged = new long[right - left + 1];
    	int lIndex = left;
    	int rIndex = mid + 1;
    	for (int i = 0; i < merged.length; i++) {
    		if (lIndex <= mid && rIndex <= right) {
    			if (prefixSums[lIndex] < prefixSums[rIndex]) {
    				merged[i] = prefixSums[lIndex];
    				lIndex += 1;	
    			} else {
    				merged[i] = prefixSums[rIndex];
    				rIndex += 1;
    			}    			 
    		} else if (lIndex <= mid) {
				merged[i] = prefixSums[lIndex];
				lIndex += 1;		
    		} else if (rIndex <= right) {
    			merged[i] = prefixSums[rIndex];
    			rIndex += 1;
    		}
    	}

    	for (int i = 0, j = left; i < merged.length && j <= right; i++, j++) {
    		prefixSums[j] = merged[i];
    	}
    }
}