class NumberOfLIS {
	//https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
    public int findNumberOfLIS(int[] nums) {
    	if (nums.length <= 1) {
    		return nums.length;
    	}
        int dp[] = new int[nums.length];        
        int dpWays[] = new int[nums.length];
        int max = Integer.MIN_VALUE;        
        int count = 0;
        //Arrays.fill(dp, 1);
        Arrays.fill(dpWays, 1);

        for (int i = 0; i < nums.length; i++) {
        	for (int j = 0; j <= i; j++) {
        		if (nums[i] > nums[j]) {
        			if (dp[i] < dp[j] + 1) {
        				dp[i] = dp[j] + 1;
        				dpWays[i] = dpWays[j]
        			} else if (dp[i] == dp[j] + 1) {
        				dpWays[i] += dpWays[j]
        			}        			 
        		}
        	}
        }

        for (int i = 0; i < dp.length; i++) {
        	System.out.print(dp[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < dp.length; i++) {
        	System.out.print(dpWays[i] + " ");
        }

        for (int i = 0; i < dp.length; i++) {
        	max = max < dp[i] ? dp[i] : max;
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == max) {
                count += dpWays[i];
            }
        }

        return count;
    }


}