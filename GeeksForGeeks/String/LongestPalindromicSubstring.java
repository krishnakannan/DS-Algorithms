import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string/0

class LongestPalindromicSubstring {
	public static void main (String[] args) {
		LongestPalindromicSubstring lp = new LongestPalindromicSubstring();
 		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    String str = in.next();		
		    System.out.println(lp.getLPS(str));
 		}
	}

	public String getLPS(String str) {	
		char[] sArr = str.toCharArray();
		char[] rArr = new char[sArr.length];
		for (int i = rArr.length - 1, j = 0; i >= 0 && j < sArr.length; i--, j++) {
			rArr[i] = sArr[j];			
		}
		int[][] dp = new int[sArr.length][sArr.length];
		
		//Populate DP
		for (int i = 0; i < sArr.length; i++) {
			for (int j = 0; j < rArr.length; j++) {				
				if (i == 0 || j == 0) {
					if (sArr[i] == rArr[j]) {
						dp[i][j] = 1;
					}
				} else {
					if (sArr[i] == rArr[j]) {

						dp[i][j] = 1 + dp[i - 1][j - 1];
					}
				}
			}
		}
		// System.out.print("  ");
		// for (int i = 0; i < rArr.length; i++) {
		// 	System.out.print(rArr[i] + " ");
		// }
		// System.out.println();
		// for (int i = 0; i < sArr.length; i++) {
		// 	System.out.print(sArr[i] + " ");
		// 	for (int j = 0; j < rArr.length; j++) {				
		// 		System.out.print(dp[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }


		int maxLength = 1;
		String palindrome = Character.toString(sArr[0]);
		String rStr = new StringBuilder(str).reverse().toString();
		//Exhaustively searching & Determining a potential palindrome candidate.
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {				
				if (dp[i][j] > maxLength) {					
					if (isPalindrome(rStr, j - dp[i][j] + 1, j + 1)) {						
						palindrome = rStr.substring(j - dp[i][j] + 1, j + 1);
						//System.out.println("Pali Candidate " + palindrome);
						maxLength = dp[i][j];
					}
				}
			}
		}
		//Potential Candidate found;

		




		return palindrome;
	}

	public boolean isPalindrome(String string, int startIndex, int maxLength) {
		//System.out.println("Start Index = " + startIndex + " End Index " + maxLength);
		String str = string.substring(startIndex, maxLength);
		String rStr = new StringBuilder(str).reverse().toString();
		//System.out.println(str + " " + rStr);
		return str.equals(rStr);
	}
}