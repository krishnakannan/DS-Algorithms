//https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/description/

class MinimumASCIIDelete {
    public int minimumDeleteSum(String s1, String s2) {
    	int s1Len = s1.length();
 		int s2Len = s2.length();
 		int s1Sum = 0;
 		int s2Sum = 0;
 		for (int i = 0; i < s1Len; i++) {
 			s1Sum += (int)s1.charAt(i);
 		}

 		for (int i = 0; i < s2Len; i++) {
 			s2Sum += (int)s2.charAt(i);
 		}
        int totalSum = s1Sum + s2Sum;

 		if (s1Len == 0) {
 			return s2Sum;
 		} else if (s2Len == 0) {
 			return s1Sum;
 		}

 		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
 		
 		//Get Longest Common ASCII Characters
 		for (int i = 1; i < dp.length; i++) {
 			for (int j = 1; j < dp[0].length; j++) {
 				if ((int)s1.charAt(i - 1) == (int)s2.charAt(j - 1)) {
 					dp[i][j] = (int)s1.charAt(i - 1) + dp[i - 1][j - 1];
 				} else {
 					dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
 				}
 			}
 		}
 		
 		return totalSum - (2 * dp[s1Len][s2Len]);
    }

    public int max (int a, int b) {
    	return a > b ? a : b;
    }
}