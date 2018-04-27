import java.util.*;
import java.lang.*;   
import java.io.*;

class FirstMissingPositive {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		FirstMissingPositive fmp = new FirstMissingPositive();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		System.out.println(fmp.firstMissingPositive(nums));
	}

    public int firstMissingPositive(int[] nums) {

		if (nums.length == 1) {
			if (nums[0] == 1) {
				return 2; 
			} else {
				return 1;
			}
		}        

		boolean lastIndexNumPresent = false;

        for (int i = 0; i < nums.length; i++) {          	
        	if (nums[i] == nums.length) {        		
        		lastIndexNumPresent = true;
        	}
        	if (nums[i] < 0 || nums[i] >= nums.length) {
        		if (nums[i] < -1) {
        			nums[i] = 0;
        		}
        		continue;
        	}        	
    		int nextIndex = nums[i];    		
    		nums[i] = 0;    		        	
    		while (nextIndex != -1 && nextIndex != 0) {
    			if (nums[nextIndex] == nums.length) {        		
        			lastIndexNumPresent = true;
        		}
    			int content = nums[nextIndex];
    			nums[nextIndex] = -1;
    			nextIndex = content < nums.length ? content : 0;
    		}    		
    		if (nextIndex == 1) {
    			nums[1] = -1;
    		} else {
    			nums[0] = -1;
    		}    		
    		print(nums);
    		System.out.println("---");
        }
        print(nums);
    		System.out.println("---");

        int firstMissingPositive = 0;

        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] >= 0) {
        		firstMissingPositive = i;
        		break;
        	}
        }

        if (firstMissingPositive == 0) {
        	if (lastIndexNumPresent) {
        		firstMissingPositive = nums.length + 1;
        	} else {
        		firstMissingPositive = nums.length;
        	}
        }

        return firstMissingPositive;
    }

    public void print(int[] nums) {
    	for (int i = 0; i < nums.length; i++) {
    		System.out.print(nums[i] + " ");
    	}
    	System.out.println();
    }
}