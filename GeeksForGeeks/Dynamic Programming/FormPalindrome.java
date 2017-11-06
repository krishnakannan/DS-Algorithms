import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/form-a-palindrome/0

class FormPalindrome {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		FormPalindrome fp = new FormPalindrome();
		while (--testcases >= 0) {		    
		    String s = in.next();
		    System.out.println(fp.charactersRequired(s));		
 		}	
	}

	public int charactersRequired(String s) {
		char[] str = s.toCharArray();
		char[] strRev = new char[str.length];		
		for (int index = 0, i = str.length - 1; i >= 0; i--, index++) {
			strRev[index] = str[i];
		}		
		int commonSubsequence = longestCommonSubsequence(str, strRev);
		return s.length() - commonSubsequence;
	}

	public int longestCommonSubsequence(char[] s1, char[] s2) {
		int dp[][] = new int[s1.length][s2.length];

		for (int i = 0; i < s1.length; i++) {
			for (int j = 0; j < s2.length; j++) {				
				if (i == 0 && j == 0) {
					if (s1[i] == s2[j]) {
						dp[i][j] = 1;
					}
				} else if (i == 0 && j != 0) {
					if (s1[i] == s2[j]) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i][j] < dp[i][j - 1] ? dp[i][j - 1] : dp[i][j];
					}
				} else if (j == 0 && i != 0) {
					if (s1[i] == s2[j]) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i][j] < dp[i - 1][j] ? dp[i - 1][j] : dp[i][j];
					}
				} else {
					if (s1[i] == s2[j]) {
						dp[i][j] = dp[i - 1][j - 1] + 1;
					} else {
						dp[i][j] = dp[i - 1][j] < dp[i][j - 1] ? dp[i][j - 1] : dp[i - 1][j];
					}
				}
			} 		
		}
		return dp[s1.length - 1][s2.length - 1];
	}
}