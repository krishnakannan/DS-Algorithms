class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
    	int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
    	for (int i = 0; i < dp.length; i++) {
    		dp[i] = 1;
    	}
    	for (int i = 1; i < nums.length; i++) {
    		for (int j = 0; j < i; j++) {
    			if (nums[i] > nums[j]) {
    				dp[i] = dp[j] + 1 > dp[i] ? dp[j] + 1  : dp[i];
    			}
    		}
    	}
        for (int i = 0; i < dp.length; i++) {
            max = max < dp[i] ? dp[i] : max;
        }
    	return max;
    }
}