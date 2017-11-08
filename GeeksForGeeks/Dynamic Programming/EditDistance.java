import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/edit-distance/0

class EditDistance {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		EditDistance ed = new EditDistance();
		while (--testcases >= 0) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
		    String s1 = in.next();		
		    String s2 = in.next();
		    System.out.println(ed.getEditDistance(s1, s2));
 		}
	}

	public int getEditDistance(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int[][] dp = new int[s1.length][s2.length];
		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				if (i == 0 && j == 0) {
					if (s1[i] != s2[j]) {
						dp[i][j] = 1;
					}
				} else if (i == 0 && j != 0) {					
					if (s1[i] == s2[j]) {
						dp[i][j] = j;
					} else {
						dp[i][j] = 1 + dp[i][j - 1];
					}
				} else if (j == 0 && i != 0) {
					if (s1[i] == s2[j]) {
						dp[i][j] = i;
					} else {
						dp[i][j] = 1 + dp[i - 1][j];
					}
				} else {
					if (s1[i] == s2[j]) {
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
					}
				}
			}
		}
		// for (int i = 0; i < s1.length; i++) {
		// 	for (int j = 0; j < s2.length; j++) {
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		return dp[s1.length - 1][s2.length - 1];
	}

	public int min(int... a) {
		int min = Integer.MAX_VALUE;
		for (int m : a) {
			min = min > m ? m : min;
		}
		return min;
	}
}