import java.util.*;
import java.lang.*;
import java.io.*;

class FindKthSmallestPairDistance {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();			
		}
		int k = in.nextInt();
		FindKthSmallestPairDistance fkspd = new FindKthSmallestPairDistance();
		System.out.println(fkspd.smallestDistancePair(nums, k));
	}

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        //int min = Integer.MAX_VALUE;
        int max = nums[nums.length - 1] - nums[0];
        // for (int i = 1; i < nums.length; i++) {
        // 	min = nums[i] - nums[i - 1] < min ? nums[i] - nums[i - 1] : min;
        // }
        return search(nums, 0, max, k);
    }
    
    public int search(int[] nums, int min, int max, int k) {
    	//System.out.print("MIN " + min + " MAX " + max + " ");
    	if (min >= max) {
    		return max;
    	}
    	int mid = min + (max - min) / 2;

    	int pairs = count(nums, mid);

    	if (pairs >= k) {
    		return search(nums, min, mid, k);
    	} else {
    		return search(nums, mid + 1, max, k);
    	}
    }

    public int count(int[] nums, int k) {  
        //System.out.println("MID "  + k);  	
    	int pairCount = 0;
    	int left = 0;
    	int right = left + 1;
    	while (right < nums.length) {    		
    		if (nums[right] - nums[left] <= k) {
    			right += 1;
    		} else {
    			int chunk = right - left;
    			pairCount +=  ((chunk * (chunk - 1)) / 2);
    			while (left <= right && nums[right] - nums[left] > k) {
    				left += 1;
    			}
    			
    			while (left < right) {
    				if (nums[right] - nums[left] > k) {
    					left += 1;
    				} else {
    					break;
    				}  				
    			}
    			int minChunk = right - left;
    			pairCount -=  ((minChunk * (minChunk - 1)) / 2);
    		}    
    	}    	
    	while (left < right) {
    		if (nums[right - 1] - nums[left] > k) {
    			left += 1;
    		} else {
    			break;
    		}
    	}    	
    	int finalChunk = right - left;
    	pairCount +=  ((finalChunk * (finalChunk - 1)) / 2);
        //System.out.println("Pairs "  + pairCount);
    	return pairCount;
    }


}