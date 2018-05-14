import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSumOfThreeSubArrays {

	public static void main(String atgs[]) {
		Scanner in = new Scanner(System.in);
		MaxSumOfThreeSubArrays msotsa = new MaxSumOfThreeSubArrays();
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = in.nextInt();
		}
		int k = in.nextInt();
		int[] res = msotsa.maxSumOfThreeSubarrays(nums, k);
		for (int r : res) {
			System.out.print(r + " ");
		}
	}

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
        	prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int[] fwdBest = new int[nums.length];
        int[] revBest = new int[nums.length];

        int fBest = prefixSum[k - 1];
        int fBestIndex = 0;
        fwdBest[0] = fBestIndex;

        int rBest = 0;
        int rBestIndex = nums.length - 1;
        revBest[revBest.length - 1] = rBestIndex;

        for (int i = 1, j = revBest.length - 2; i < nums.length && j > 0; i++, j--) {
        	if (i + k - 1 < nums.length) {
        		int sumFromHere = prefixSum[i + k - 1] - prefixSum[i - 1];
        		if (fBest < sumFromHere) {
        			fBest = sumFromHere;
					fBestIndex = i;        			
        		}
        	} 
        	
        	if (j + k - 1 < nums.length) {
        		int sumFromHere = prefixSum[j + k - 1] - prefixSum[j - 1];
        		if (rBest < sumFromHere) {
        			rBest = sumFromHere;
        			rBestIndex = j;
        		}
        	}
        	fwdBest[i] = fBestIndex;
        	revBest[j] = rBestIndex;
        }        

        int x = 0;
        int y = x + k;
        int z = y + k;
        int maxSum = 0;
        //System.out.println(maxSum);
        int[] res = new int[]{x, y, z};        
        while (z + k - 1 < nums.length) {
        	int xVal = fwdBest[x] == 0 ? prefixSum[fwdBest[x] + k - 1] : prefixSum[fwdBest[x] + k - 1] - prefixSum[fwdBest[x] - 1];
        	int yVal = prefixSum[y + k - 1] - prefixSum[y - 1];
        	int zVal = prefixSum[revBest[z] + k - 1] - prefixSum[revBest[z] - 1];
        	int sum =  xVal + yVal + zVal;        	
        	//System.out.println("sum = " + xVal + " + " + yVal + " + " + zVal + " = " + sum);
        	if (sum > maxSum) {
        		res[0] = fwdBest[x];
        		res[1] = y;
        		res[2] = revBest[z]; 
        		maxSum = sum;        		
        	}        	
        	x += 1;
        	y += 1;
        	z += 1;
        }

        return res;
    }
}