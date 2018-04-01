class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] sArr = s.toCharArray();
        char[] rArr = new StringBuilder(s).reverse().toString().toCharArray();
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < sArr.length; i++) {
        	for (int j = 0; j < sArr.length; j++) {
        		if (i == 0) {
        			if (sArr[i] == rArr[j]) {
        				dp[i][j] = 1;
        			} else {
                        if (j > 0) {
                            dp[i][j] = dp[i][j - 1];
                        }
                    }
        		} else if (j == 0) {
        			if (sArr[i] == rArr[j]) {
        				dp[i][j] = 1;
        			} else {
                        if (i > 0) {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
        		} else {
        			if (sArr[i] == rArr[j]) {
        				dp[i][j] = dp[i - 1][j - 1] + 1;
        			} else {
        				dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        			}
        		}
        	}
        }
        return dp[sArr.length - 1][sArr.length - 1];
    }

    public int max(int a, int b) {
    	return a > b ? a : b;
    }
}