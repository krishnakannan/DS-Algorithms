import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/0-1-knapsack-problem/0

class _01Knapsack {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		_01Knapsack ks = new _01Knapsack();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int w = in.nextInt();
		    int[] wt = new int[n];
		    int[] val = new int[n];
		    for (int i = 0; i < n; i++) {
		        val[i] = in.nextInt();
		    }
		    for (int i = 0; i < n; i++) {
		        wt[i] = in.nextInt();
		    }
			System.out.println(ks.getMaxValue(wt, val, w));
 		}		
	}

	public int getMaxValue(int[] weights, int[] value, int maxWeight) {
		int[][] dp = new int[weights.length][maxWeight + 1];


		
			
		for (int i = 0; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {				
				if (i == 0) {
					if (weights[i] == j) {
						dp[i][j] = value[i];
					} else if (weights[i] < j) {
						dp[i][j] = dp[i][j - 1];
					}
				} else {
					if (weights[i] > j) {
						dp[i][j] = dp[i - 1][j];
					} else {
						dp[i][j] = max(value[i] + dp[i - 1][j - weights[i]], dp[i - 1][j]);
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

		return dp[weights.length - 1][maxWeight];
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}
}