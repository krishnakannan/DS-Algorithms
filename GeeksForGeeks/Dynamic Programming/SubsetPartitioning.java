import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/subset-sum-problem/0

class SubsetPartitioning {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		SubsetPartitioning sp = new SubsetPartitioning();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(sp.isPartitionPossible(arr) ? "YES" : "NO");
 		}
	}

	public boolean isPartitionPossible(int set[]) {		
		int sum = 0;
		for (int i = 0; i < set.length; i++) {
			sum += set[i];
		}
		if (sum % 2 != 0) {
			return false;
		}
		sum /= 2;
		boolean[][] dp = new boolean[set.length][sum + 1];
		for (int j = 0; j < set.length; j++) {
			dp[j][0] = true;
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					if (j < set[i]) {
						dp[i][j] = false;
					} else if (j == set[i]) {
						dp[i][j] = true;
					} else {
						dp[i][j] = false;
					}
				} else {
					if (j < set[i]) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = dp[i - 1][j] ? dp[i - 1][j] : dp[i - 1][j - set[i]];
					}
				}
			}
		}

		// for (int i = 0; i < dp.length; i++) {
		// 	for (int j = 0; j < dp[0].length; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		return dp[set.length - 1][sum];
	}
}