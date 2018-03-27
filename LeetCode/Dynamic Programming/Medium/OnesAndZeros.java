class Solution {
    int[][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
 		dp = new int[strs.length][m + 1][n + 1];   
        
        for (int[][] dpMat : dp) {
            for (int[] dpEntry : dpMat) {
                Arrays.fill(dpEntry, Integer.MIN_VALUE);
            }
        }
        
 		return findMax(strs, 0, n, m);
    }

    public int findMax(String[] strings, int index, int onesRemaining, int zerosRemaining) {
    	
        if (index >= strings.length) {
            return 0;
        }
        
    	if (dp[index][zerosRemaining][onesRemaining] != Integer.MIN_VALUE) {
    		return dp[index][zerosRemaining][onesRemaining];
    	}

    	if (index == strings.length - 1) {
    		int ones = countOnes(strings[index]);
			int zeros = strings[index].length() - ones;
			if (onesRemaining >= ones && zerosRemaining >= zeros) {
				dp[index][zerosRemaining][onesRemaining] = 1;
			} else {
				dp[index][zerosRemaining][onesRemaining] = 0;
			} 		
			return dp[index][zerosRemaining][onesRemaining];
    	}

    	int max = 0;
        int addingCurrentString = -1;
        
        
        int ones = countOnes(strings[index]);
        int zeros = strings[index].length() - ones;        
        if (onesRemaining >= ones && zerosRemaining >= zeros) {
            addingCurrentString = findMax(strings, index + 1, onesRemaining - ones, zerosRemaining - zeros) + 1;
        }    		    	
        int notAddingCurrentString = findMax(strings, index + 1, onesRemaining, zerosRemaining);

    	dp[index][zerosRemaining][onesRemaining] = addingCurrentString > notAddingCurrentString ? addingCurrentString : notAddingCurrentString;
    	return dp[index][zerosRemaining][onesRemaining];

    }

    public int countOnes(String str) {
    	char[] string = str.toCharArray();
    	int ones = 0;
    	for (int i = 0; i < string.length; i++) {
    		if (string[i] == '1') {
    			ones++;
    		}
    	}
    	return ones;
    }

}