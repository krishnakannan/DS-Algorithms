import java.util.*;
import java.lang.*;
import java.io.*;

class LongestPalindromicSubstring {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		LongestPalindromicSubstring lcs = new LongestPalindromicSubstring();
		System.out.println(lcs.longestPalindrome(str));
	}

    public String longestPalindrome(String s) {
    	if (s.isEmpty()) {
            return s;
        }
        char[] string = s.toCharArray();
        char[] rString = new StringBuilder(s).reverse().toString().toCharArray();
        int dp[][] = new int[string.length][string.length];
        //First Row
        for (int j = 0; j < dp[0].length; j++) {
        	dp[0][j] = string[0] == rString[j] ? 1 : 0;
        }

        //First Col
        for (int i = 0; i < dp.length; i++) {
        	dp[i][0] = string[i] == rString[0] ? 1 : 0;
        }

        for (int i = 1; i < dp.length; i++) {
        	for (int j = 1; j < dp[0].length; j++) {
        		dp[i][j] = string[i] == rString[j] ? dp[i - 1][j - 1] + 1 : 0;
        	}
        }

        int longestPalindrome = 0;
        String finalCandidate = "";
        for (int i = dp.length - 1; i >= 0; i--) {
        	for (int j = dp[0].length - 1; j >= 0; j--) {
        		if (dp[i][j] > longestPalindrome) {
        			//Candidate Found;
        			int len = dp[i][j];
        			String candidate = new String(rString, j - dp[i][j] + 1, dp[i][j]);
        			if (isPalindrome(candidate)) {
        				longestPalindrome = len;
        				finalCandidate = candidate;
        			}
        		}
        	}
        }

        return finalCandidate;

    }

    public boolean isPalindrome(String str) {
    	String rStr = new StringBuilder(str).reverse().toString();
    	return str.equals(rStr);
    }
}