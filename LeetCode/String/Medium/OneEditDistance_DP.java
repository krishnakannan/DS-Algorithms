class Solution {

	//Performing Edit Distance DP Algorithm

	public boolean isOneEditDistance(String s, String t) {
		//Edge cases
		if (s.isEmpty() && t.isEmpty()) {
			return false;
		} else if (s.isEmpty()) {
			return t.length() == 1;
		} else if (t.isEmpty()) {
			return s.length() == 1;
		}
		
		char[] sArr = s.toCharArray();
		char[] tArr = t.toCharArray();
		int dp[][] = new int[sArr.length][tArr.length];

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {

				//First Element
				if (i == 0 && j == 0) {
					if (sArr[i] != tArr[j]) {
						dp[i][j] = 1;
					}
					continue;
				}

				//First Row
				if (i == 0 && j != 0) {
					if (sArr[i] == tArr[j]) {
						dp[i][j] = j;
					} else {
						dp[i][j] = dp[i][j - 1] + 1;
					}
					continue;
				}

				//First Col
				if (j == 0 && i != 0) {
					if (sArr[i] == tArr[j]) {
						dp[i][j] = i;
					} else {
						dp[i][j] = dp[i - 1][j] + 1;
					}
					continue;
				}

				//Rest of the Matrix
				if (sArr[i] == tArr[j]) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = 1 + min(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1]);
				}
			}
		}        
		return dp[sArr.length - 1][tArr.length -1] == 1 ? true : false; 
	}

	public int min(int a, int b, int c) {
		return a < b ? (a < c ? a : c) : (b < c ? b : c); 
	}
}