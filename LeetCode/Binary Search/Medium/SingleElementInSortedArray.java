import java.util.*;
import java.lang.*;
import java.io.*;

class SingleElementInSortedArray {

	public static void main(String args[]) {
		SingleElementInSortedArray se = new SingleElementInSortedArray();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(se.singleNonDuplicate(nums));
	}

    public int singleNonDuplicate(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int start, int end) {
    	int middle = start + ((end - start) / 2);
    	//System.out.println("Start " + start + " End " + end + " Middle " + middle + " ELEMENT " + nums[middle]) ;

    	if (start == end || end - start == 1) {
    		return end % 2 == 0 ? nums[end] : nums[start];
    	}

    	
    	boolean isEvenIndex = false;
    	if (middle % 2 == 0) {
    		isEvenIndex = true;
    	}

    	if (isEvenIndex) {
    		if (middle > 0 && nums[middle] == nums[middle - 1]) {
    			return binarySearch(nums, start, middle - 1);
    		} else {
    			return binarySearch(nums, middle, end);
    		}
    	} else {
    		if (middle < nums.length - 1 && nums[middle] == nums[middle + 1]) {
    			return binarySearch(nums, start, middle - 1);
    		} else {
    			return binarySearch(nums, middle, end);	
    		}
    	}
    }
}