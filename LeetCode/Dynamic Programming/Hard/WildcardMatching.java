class Solution {
	public boolean isMatch(String s, String p) {
		char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();   
		boolean[][] dp = new boolean[string.length + 1][pattern.length + 1];

		dp[0][0] = true;

		//First Row
		for (int i = 1; i < dp[0].length; i++) {
			if (pattern[i - 1] == '*') {
				dp[0][i] = dp[0][i - 1];
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (string[i - 1] == pattern[j - 1] || pattern[j - 1] == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
				} else {
					dp[i][j] = false;
				}
			}
		}

		return dp[string.length][pattern.length];
	}
}