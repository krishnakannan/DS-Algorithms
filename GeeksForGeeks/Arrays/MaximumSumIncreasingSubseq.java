import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0

class MaximumSumIncreasingSubseq {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MaximumSumIncreasingSubseq maxSIS = new MaximumSumIncreasingSubseq();	
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(maxSIS.maxSumIncreasingSubseq(arr));
 		}
	}


	public int maxSumIncreasingSubseq(int[] arr) {

		int[] dp = Arrays.copyOf(arr, arr.length);		
		int max = dp[0];
 		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = (dp[j] + arr[i]) > dp[i] ? (dp[j] + arr[i]) : dp[i];
				} 
			}
			max = max < dp[i] ? dp[i] : max;
		}

		// for (int i = 0; i < dp.length; i++) {
		// 	System.out.print(dp[i] + " ");
		// }
		// System.out.println();

		return max;
	}
}