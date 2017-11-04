import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/longest-common-substring/0

class LongestCommonSubstring {
	public static void main (String[] args) {
		LongestCommonSubstring lcss = new LongestCommonSubstring();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
			int l1 = in.nextInt();
			int l2 = in.nextInt();
		    String s1 = in.next();	
		    String s2 = in.next();	
		    System.out.println(lcss.getLCSS(s1, s2));
 		}
	}

	public int getLCSS(String s1, String s2) {
		char[] s1Arr = s1.toCharArray();
		char[] s2Arr = s2.toCharArray();
		int[][] dp = new int[s1Arr.length][s2Arr.length];
		int max = 0;
		for (int i = 0; i < s1Arr.length; i++) {
			for (int j = 0; j < s2Arr.length; j++) {
				if (i == 0 || j == 0) {
					if (s1Arr[i] == s2Arr[j]) {
						dp[i][j] = 1;
					}
				} else {
					if (s1Arr[i] == s2Arr[j]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					}
				}
			}
		}		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				max = max < dp[i][j] ? dp[i][j] : max;
			}	
		}
		return max;
	}
}