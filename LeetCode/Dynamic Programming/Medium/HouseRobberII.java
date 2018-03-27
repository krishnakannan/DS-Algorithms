class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        
        
        int max = 0;
        int len = nums.length;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        max = max > dp[0] ? max : dp[0];
        dp[1] = nums[1] > nums[0] ? nums[1] : nums[0];            
        max = max > dp[1] ? max : dp[1];
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = (dp[i - 2] + nums[i]) > dp[i - 1] ? (dp[i - 2] + nums[i]) : dp[i - 1];
            max = max > dp[i] ? max : dp[i];
        }
        
        Arrays.fill(dp, 0);
        dp[nums.length - 1] = nums[nums.length -1];
        max = max > dp[nums.length - 1] ? max : dp[nums.length - 1];
        dp[nums.length - 2] = nums[nums.length - 1] > nums[nums.length - 2] ? nums[nums.length - 1] : nums[nums.length - 2];                             
        max = max > dp[nums.length - 2] ? max : dp[nums.length - 2];
        for (int i = nums.length - 3; i > 0; i--) {
            dp[i] = (dp[i + 2] + nums[i]) > dp[i + 1] ? (dp[i + 2] + nums[i]) : dp[i + 1];
            max = max > dp[i] ? max : dp[i];
            
            // dp[i % len] = (dp[(i - 2) % len] + nums[i % len]) > dp[(i - 1) % len] ? (dp[(i - 2) % len] + nums[i % len]) : dp[(i - 1) % len];
            //max = max > dp[i % len] ? max : dp[i % len];
        }
        return max;
    }
}