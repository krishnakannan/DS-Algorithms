import java.util.*;
import java.lang.*;   
import java.io.*;

class DifferentPalindromicSubsequences {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		DifferentPalindromicSubsequences dps = new DifferentPalindromicSubsequences();
		System.out.println(dps.countPalindromicSubsequences(s));
	}
	List<String> palindromes = new ArrayList<>();
	int[][] dp;
	private static final int MOD = 1000000007;	
    public int countPalindromicSubsequences(String S) {
        dp = new int[S.length()][S.length()];
        int count = count(S.toCharArray(), 0, S.length() - 1);        
        return count;
    }

    public int count(char[] s, int startIndex, int endIndex) {  
    	if (startIndex > endIndex) {
    		return 0;
    	}

    	if (dp[startIndex][endIndex] != 0) {    		
    		return dp[startIndex][endIndex];
    	}


    	long palindromeCount = 0l;

    	if (startIndex == endIndex) {
    		dp[startIndex][endIndex] = 1;
    		return dp[startIndex][endIndex];
    	} else if (s[startIndex] != s[endIndex]) {    	
    		palindromeCount = count(s, startIndex, endIndex - 1) + count(s, startIndex + 1, endIndex) - count(s, startIndex + 1, endIndex - 1);
    	} else {    		

    		palindromeCount = 2 * count(s, startIndex + 1, endIndex - 1);
            
    		int tempStart = startIndex + 1;
    		int tempEnd = endIndex - 1;

    		while (tempStart <= tempEnd 
    			&& s[tempStart] != s[startIndex]) {
    			tempStart += 1;
    		}
    		while (tempEnd >= tempStart && s[tempEnd] != s[endIndex]) {
    			tempEnd -= 1;
    		}

    		if (tempStart > tempEnd) {
    			palindromeCount += 2;    			
    		} else if (tempStart == tempEnd) {
    			palindromeCount += 1;
    		} else {
    			palindromeCount -= count(s, tempStart + 1, tempEnd - 1);
    		}
			
    	}
    	
    	dp[startIndex][endIndex] = palindromeCount < 0 ? (int)(palindromeCount + MOD) : (int)(palindromeCount % MOD);

    	return dp[startIndex][endIndex];
    }
}