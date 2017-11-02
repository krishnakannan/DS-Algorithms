import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0

class LongestIncreasingSubsequence {
	public static void main (String[] args) {
		LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(ls.lis(arr));
 		}
	}

	public long lis(int[] arr) {
		if (arr.length == 0)  {
			return 0;
		}
		long maxVal = Long.MIN_VALUE;
		int dp[] = new int[arr.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;			
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= i; j++) {
				if (arr[i] > arr[j]) {
					dp[i] = dp[j] + 1 > dp[i] ? dp[j] + 1 : dp[i];
				}
			}
		}

		for (int i = 0; i < dp.length; i++) {
			maxVal = maxVal < dp[i] ? dp[i] : maxVal;		
		}

		return maxVal;
	}
}