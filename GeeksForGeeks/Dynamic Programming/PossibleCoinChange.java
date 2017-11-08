import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/coin-change/0

class PossibleCoinChange {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		PossibleCoinChange pcc = new PossibleCoinChange();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			int k = in.nextInt();
			System.out.println(pcc.getMaxWays(arr, k));
 		}
	}

	public int getMaxWays(int[] coin, int total) {		
		int[][] dp = new int[coin.length][total + 1];
		//init DP
		for (int i = 0; i < dp[0].length; i++) {			
			dp[0][i] = i % coin[0] == 0 ? 1 : 0;
		}
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
 		}

 		//Calculate for others
 		for (int i = 1; i < dp.length; i++) {
 			for (int j = 1; j < dp[i].length; j++) {
 				dp[i][j] = j >= coin[i] ? dp[i - 1][j] + dp[i][j - coin[i]] : dp[i - 1][j];
 			}
 		}

 		return dp[coin.length - 1][total];
	}
}