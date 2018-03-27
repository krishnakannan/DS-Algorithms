class Solution {

	int count = 0;
	int[][] dp;

    public int findTargetSumWays(int[] nums, int S) {
        dp = new int[nums.length][2001];
        for (int[] r : dp) {
            Arrays.fill(r, Integer.MIN_VALUE);
        }
        int ways = findWays(nums, 0, S, 0);                
        return ways;
    }



    public int findWays(int[] nums, int index, int target, int currentSum) {

    	if (index == nums.length) {
    		if (target == currentSum) {
    			return 1;
    		}    		
    		return 0;    		
    	}

    	if (dp[index][currentSum + 1000] != Integer.MIN_VALUE) {
    		return dp[index][currentSum + 1000];
    	}

    	int nextPositiveSum = findWays(nums, index + 1, target, currentSum + nums[index]);

    	int nextNegativeSum = findWays(nums, index + 1, target, currentSum + (-nums[index]));

        
    	dp[index][currentSum + 1000] = nextPositiveSum + nextNegativeSum;

    	return dp[index][currentSum + 1000];

    }

}