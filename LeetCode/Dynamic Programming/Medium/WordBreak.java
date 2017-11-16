class WordBreak {
	/*
		*	To fill a Upper Triangular Matrix.
		* https://leetcode.com/problems/word-break/description/
	*/
 public boolean wordBreak(String s, List<String> wordDict) {
        int iIndex = 0;
        int jIndex = 0;
        int sLength = s.length();
        boolean dp[][] = new boolean[sLength][sLength];
        int i = 0;
        int j = 0;
        System.out.println(s.substring(0,0));
        System.out.println(s.substring(0,1));
        while (jIndex < sLength) {
        	i = iIndex; 
        	j = jIndex;
        	while (j < sLength) {
        		if (wordDict.contains(s.substring(i, j + 1))) {
        			dp[i][j] = true;
        		} else {
        			int firstStart = 0;
        			int firstEnd = 0;
        			int secondStart = firstEnd + 1;
        			int secondEnd = j;
        			while (secondStart <= secondEnd) {
        				dp[i][j] = dp[firstStart][firstEnd] && dp[secondStart][secondEnd];
        				if (dp[i][j]) {
        					break;
        				}
        				firstEnd++;
        				secondStart = firstEnd + 1;
        			}
        		}
        		i++;
        		j++;
        	}
        	iIndex = 0;
        	jIndex++;
        }

        // for (int x = 0; x < dp.length; x++) {
        // 	for (int y = 0; y < dp[0].length; y++) {
        // 		System.out.print(dp[x][y] + " ");
        // 	}
        // 	System.out.println();
        // }

        return dp[0][sLength - 1];
    }
}