import java.util.*;
import java.lang.*;
import java.io.*;

class PalindromePartitioningII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String s = in.next();
		System.out.println(pp.minCut(s));
	}

    int[][] palindromeDP;
    public int minCut(String s) {                
    	int strLength = s.length();
        if (strLength == 0) {
            return 0;
        }
        int[] dp = new int[strLength];                        
        palindromeDP = new int[strLength][strLength];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[strLength - 1] = 0;
        char[] string = s.toCharArray();
        for (int i = strLength - 2; i >= 0; i--) {
        	for (int j = strLength - 1; j > i; j--) {              
                if (isPalindrome(string, i, j)) {        			
        			if (j == strLength - 1) {
        				dp[i] = 0; 
                        break;
        			} else {
        				dp[i] = dp[i] > dp[j + 1] + 1 ? dp[j + 1] + 1 : dp[i];                        
        			}        			
        		} else {
        			dp[i] = dp[i] > dp[i + 1] + 1 ? dp[i + 1] + 1 : dp[i];
        		}
        	}
        }            
        return dp[0];
    }

    public boolean isPalindrome(char[] string, int left, int right) {                                
        int l = left;
        int r = right;
    	while (left < right) {
            if (string[left] == string[right]) {
                if (palindromeDP[left][right] == 1) {
                    palindromeDP[l][r] = 1;                    
                    return true;
                } else if (palindromeDP[left][right] == -1) {
                    palindromeDP[l][r] = -1;                
                    return false;    
                }
                left++;
                right--;
            } else {                
                palindromeDP[l][r] = -1;                
                return false;
            }
        }
        palindromeDP[l][r] = 1;        
        return true;
    }
}