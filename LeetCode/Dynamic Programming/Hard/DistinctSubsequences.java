import java.util.*;
import java.lang.*;   
import java.io.*;

class DistinctSubsequences {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct(s, t));
	}

    public int numDistinct(String s, String t) {
        if (t.length() == 0) {
            return 1;
        } else if (s.length() == 0) {
            return 0;
        }
        
        char[] sString = s.toCharArray();
        char[] tString = t.toCharArray();
        int[][] dp = new int[tString.length][sString.length];

        dp[0][0] = sString[0] == tString[0] ? 1 : 0;

        // First Row
        for (int j = 1; j < sString.length; j++) {
        	if (tString[0] == sString[j]) {
        		dp[0][j] = dp[0][j - 1] + 1;
        	} else {
        		dp[0][j] = dp[0][j - 1];
        	}
        }

        for (int i = 1; i < tString.length; i++) {
        	for (int j = 1; j < sString.length; j++) {
        		if (j < i) {
        			dp[i][j] = 0;
        		} else {
        			if (tString[i] == sString[j]) {
        				dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        			} else {
        				dp[i][j] = dp[i][j - 1];
        			}
        		}
        	}
        }

        // print(dp);

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public void print(int[][] dp) {
    	for (int i = 0; i < dp.length; i++) {
    		for (int j = 0; j < dp[0].length; j++) {
    			System.out.print(dp[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}