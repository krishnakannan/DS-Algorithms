import java.util.*;
import java.lang.*;   
import java.io.*;

class SplitArrayLargestSum {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SplitArrayLargestSum sals = new SplitArrayLargestSum();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		int m = in.nextInt();
		System.out.println(sals.splitArray(nums, m));
	}

	/*
		We can use 2D DP instead of 3D DP.
		dp[][] = new int[nums.length + 1][m + 1];
		We just keep track of start index and number of splits. 
		Do not need to track the end index(Below Soln);
		By this program can be made faster.
	*/


	int dp[][][];
	int[] fwd;
	int[] bwd;
	// int dped = 0;
    public int splitArray(int[] nums, int m) {
    	fwd = new int[nums.length];
    	bwd = new int[nums.length];
        dp = new int[nums.length][nums.length][m + 1];
        for (int i = 0; i < nums.length; i++) {
        	for (int j = 0; j < nums.length; j++) {
        		Arrays.fill(dp[i][j], -1);
        	}
        }
        // int val = split(nums, 0, nums.length - 1, m);
        // System.out.println("DPED " + dped);
        return split(nums, 0, nums.length - 1, m);
    }

    public int split(int[] nums, int startIndex, int endIndex, int splits) {

    	if (startIndex > endIndex) {
    		return Integer.MAX_VALUE;
    	}

    	//CANT HAPPEN BUT
    	if (startIndex == endIndex && splits > 1) {
    		return Integer.MAX_VALUE;
    	}

    	if (dp[startIndex][endIndex][splits] != -1) {
    		//dped += 1;
    		return dp[startIndex][endIndex][splits];
    	}		
    	//Base Cases
    	if (splits == 1) {
    		int sum = 0;
    		for (int i = startIndex; i <= endIndex; i++) {
    			sum += nums[i];    			
    		}
    		dp[startIndex][endIndex][splits] = sum;	
    		return dp[startIndex][endIndex][splits];
    	}
        
    	if (splits == 2) {
    		int max = getMax(nums, startIndex, endIndex);
    		dp[startIndex][endIndex][splits] = max;
    		return dp[startIndex][endIndex][splits];
    	}

    	int minimumMostMax = Integer.MAX_VALUE;
    	int current = 0;
    	for (int i = startIndex; i <= endIndex; i++) {
    		current += nums[i];
    		int max = split(nums, i + 1, endIndex, splits - 1);
    		//System.out.println("Current " + current + " MAX " + max);
    		max = max < current ? current : max;
    		minimumMostMax = max < minimumMostMax ? max : minimumMostMax;

    	}
    	dp[startIndex][endIndex][splits] = minimumMostMax;
    	return minimumMostMax;
    }

    public int getMax(int[] nums, int startIndex, int endIndex) {
    	int index = 0;
    	Arrays.fill(fwd, startIndex, endIndex + 1, 0);
    	Arrays.fill(bwd, startIndex, endIndex + 1, 0);    	    	
    	int fwdVal = 0;
    	int bwdVal = 0;
    	for (int i = startIndex, j = endIndex; i <= endIndex && j >= 0; i++, j--) {
    		fwdVal += nums[i];
    		bwdVal += nums[j];
    		fwd[i] = fwdVal;
    		bwd[j] = bwdVal;
    	}
    	//System.out.println("FWD " + Arrays.toString(fwd));
    	//System.out.println("BWD " + Arrays.toString(bwd));
    	int minimumMostMax = Integer.MAX_VALUE;
    	for (int i = startIndex; i < endIndex; i++) {
    		int max = fwd[i] > bwd[i + 1] ? fwd[i] : bwd[i + 1];
    		minimumMostMax = max < minimumMostMax ? max : minimumMostMax;
    	}
    	return minimumMostMax;
    }
}