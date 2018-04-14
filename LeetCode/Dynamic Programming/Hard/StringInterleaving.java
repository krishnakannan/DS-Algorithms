import java.util.*;
import java.lang.*;
import java.io.*;

class StringInterleaving {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();
		String s3 = in.next();
		StringInterleaving sil = new StringInterleaving();
		System.out.println(sil.isInterleave(s1, s2, s3));
	}

    public boolean isInterleave(String s1, String s2, String s3) {
        char[] string1 = s1.toCharArray();
        char[] string2 = s2.toCharArray();
        char[] string3 = s3.toCharArray();
        boolean[][] dp = new boolean[string1.length + 1][string2.length + 1];
        int x = 0;
        if (string1.length == 0 && string2.length == 0) {
            if (string3.length == 0) {
                return true;
            } else {
                dp[0][0] = false;	    
            }        	
        } else {
        	dp[0][0] = true;
        }
        //Fill First Row
        for (int j = 1, k = 0; j < dp[0].length && k < string3.length; j++, k++) {
        	if (string2[j - 1] == string3[k]) {
        		dp[0][j] = true && dp[0][j - 1];
        	}
            x = x < k ? k : x;
        }
        //Fill First Col
        for (int i = 1, k = 0; i < dp.length && k < string3.length; i++, k++) {
        	if (string1[i - 1] == string3[k]) {
        		dp[i][0] = true && dp[i - 1][0];
        	}
            x = x < k ? k : x;
        }
        
        for (int i = 1; i < dp.length; i++) {            
        	for (int j = 1, k = i; j < dp[0].length && k < string3.length; j++, k++) {
        		if (string1[i - 1] == string3[k] && string2[j - 1] == string3[k]) {
        			dp[i][j] = true && (dp[i - 1][j] || dp[i][j - 1]);
        		} else if (string1[i - 1] == string3[k]) {
        			dp[i][j] = true && dp[i - 1][j];
        		} else if (string2[j - 1] == string3[k]) {
        			dp[i][j] = true && dp[i][j - 1];
        		} else {
        			dp[i][j] = false;
        		}
                x = x < k ? k : x;
        	}
        }
        
//        System.out.println(x);

        return x == string3.length - 1 ? dp[dp.length - 1][dp[0].length - 1] : false;
    }
}