class Solution {
    public boolean isMatch(String s, String p) {
    	char[] string = s.toCharArray();
    	char[] pattern = p.toCharArray();

    	boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

    	//Empty string and emtpy pattern always matches
    	dp[0][0] = true;
    	//Empty pattern and non empty string always don't match. So first column is always false;

    	//Patterns with * can become empty string 
    	for (int i = 1; i < dp[0].length; i++) {
    		if (pattern[i - 1] == '*') {
    			dp[0][i] = dp[0][i - 2];
    		}
    	}

    	for (int i = 1; i < dp.length; i++) {
    		for (int j = 1; j < dp[0].length; j++) {
    			if (string[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
    				dp[i][j] = dp[i - 1][j - 1];
    			} else if (pattern[j - 1] == '*') {
    				dp[i][j] = dp[i][j - 2];
    				if (pattern[j - 2] == '.' || pattern[j - 2] == string[i - 1]) {
    					dp[i][j] = dp[i][j] || dp[i - 1][j];
    				}
    			} else {
    				dp[i][j] = false;
    			}
    		}
    	}
    	return dp[s.length()][p.length()];
    }
}