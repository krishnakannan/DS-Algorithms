import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/longest-common-subsequence/0

class LongestCommonSubsequence {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LongestCommonSubsequence ls = new LongestCommonSubsequence();
		while (--testcases >= 0) {
		    int aLen = in.nextInt();
		    int bLen = in.nextInt();
		    String a = in.next();
		    String b = in.next();
		    System.out.println(ls.lcs(a.toCharArray(), b.toCharArray()));
 		}	
	}

	public int lcs(char[] a, char[] b) {
		int[][] dp = new int[b.length][a.length];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (i == 0 && j == 0) {
					if (b[i] == a[j]) {
						dp[i][j]++;
					}
				} else if (i == 0 && j != 0) {
					if (b[i] == a[j]) {
						dp[i][j]++;
					} else {
						dp[i][j] = dp[i][j - 1];
					}
				} else if (j == 0 && i != 0) {
					if (b[i] == a[j]) {
						dp[i][j]++;
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				} else { 
					if (b[i] == a[j]) {
						dp[i][j] = dp[i - 1][j - 1] + 1 > dp[i][j] ? dp[i - 1][j - 1] + 1 : dp[i][j];
					} else {
						dp[i][j] = dp[i - 1][j] + 1 > dp[i][j - 1] ? dp[i - 1][j]: dp[i][j - 1];
					}
				}
			}
		}

		// for (int i = 0; i < b.length; i++) {
		// 	for (int j = 0; j < a.length; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }

		return dp[b.length - 1][a.length - 1];
	}

}