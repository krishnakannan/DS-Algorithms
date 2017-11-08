import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/shortest-common-supersequence/0

class ShortestCommonSupersequence {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		ShortestCommonSupersequence scss = new ShortestCommonSupersequence();
		while (--testcases >= 0) {
		    String s1 = in.next();		
		    String s2 = in.next();
		    System.out.println(scss.getLCSupersequence(s1.toCharArray(), s2.toCharArray()));
 		}
	}

	public int getLCSupersequence(char[] s1, char[] s2) {
		int dp[][] = new int[s1.length + 1][s2.length + 1];
		for (int j = 0; j <= s2.length; j++) {
			dp[0][j] = j;
 		}
 		for (int i = 0; i <= s1.length; i++) {
			dp[i][0] = i;
 		}

 		for (int i = 1; i < dp.length; i++) {
 			for (int j = 1; j < dp[0].length; j++) { 				
 				if (s1[i - 1] == s2[j - 1]) { 					
 					dp[i][j] = dp[i - 1][j - 1] + 1;
 				} else {
 					dp[i][j] = min(dp[i - 1][j], dp[i][j - 1])+ 1;
 				}
 			}
 		}

 	// 	for (int i = 0; i < dp.length; i++) {
		// 	for (int j = 0; j < dp[0].length; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
 		return dp[s1.length][s2.length];
	}


	public int min(int a, int b) {
		return a < b ? a : b;
	}
}