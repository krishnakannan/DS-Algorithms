import java.util.*;
import java.lang.*;
import java.io.*;

class MinimumWindowSubsequence {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String S = in.next();
		String T = in.next();
		MinimumWindowSubsequence mws = new MinimumWindowSubsequence();
		System.out.println(mws.minWindow(S, T));
	}


	//LCS BASED SOLUTION - SLOW (Because of Exhaustive search at last) BUT WORKS

    public String minWindow(String S, String T) {
        char[] sStr = S.toCharArray();
        char[] tStr = T.toCharArray();
        int[][] dp = new int[tStr.length + 1][sStr.length + 1];

        for (int i = 1; i < dp.length; i++) {
        	for (int j = 1; j < dp[0].length; j++) {
        		if (tStr[i - 1] == sStr[j - 1]) {
        			dp[i][j] = dp[i - 1][j - 1] + 1;
        		} else {
        			dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ?
        					 dp[i - 1][j] : dp[i][j - 1];
        		}
        	}
        }

        if (dp[dp.length - 1][dp[0].length - 1] != tStr.length) {
        	return "";
        } 

        return getWord(dp, sStr, tStr);

    }

    public String getWord(int[][] dp, char[] sStr, char[] tStr) {        
    	int i = dp.length - 1;
    	int j = 0;class Solution {
    public int minStickers(String[] stickers, String target) {
        
    }
}

    	for (; j < dp[0].length;) {
    		j++;            
    		if (dp[i][j] == tStr.length) {
    			break;
    		} 
    	}        
    	// i, j is the ending point of subseq that we are searching
    	StringBuilder builder = new StringBuilder();
        String formed = new String(sStr);
        for (; j < dp[0].length; j++) {
            int x = i;
            int y = j;    
            boolean isCandidate = true;
            if (tStr[x - 1] == sStr[y - 1]) {
                while (x > 0 && y > 0) {
                    builder.append(sStr[y - 1]);                                
                    if (builder.length() > formed.length()) {
                        isCandidate = false;
                        break;
                    }
                    if (sStr[y - 1] == tStr[x - 1]) {
                        y -= 1;
                        x -= 1;
                    } else {
                        y -= 1;
                    }                
                }    
                //System.out.println("Formed " + builder.reverse().toString());
                if (isCandidate && builder.length() < formed.length()) {
                    formed = builder.reverse().toString();                    
                }
                builder.setLength(0);   
            }            
        }    	
    	return formed;
    }
}