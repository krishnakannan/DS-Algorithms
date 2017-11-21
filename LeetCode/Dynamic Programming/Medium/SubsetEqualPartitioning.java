//https://leetcode.com/problems/partition-equal-subset-sum/description/

class SubsetEqualPartitioning {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];            
        }
        if (sum % 2 != 0) {
            //Partition not possible
            return false;
        }
        
        sum /= 2;
        boolean dp[][] = new boolean[nums.length][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            //We can form a sum of Zero with any given numbers.
            dp[i][0] = true;
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i == 0) {
                    if (j == nums[i]) {
                        dp[i][j] = true;
                    } else 
                } else {
                    if (j < nums[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (j == nums[i]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j] ? dp[i - 1][j] : dp[i - 1][j - nums[i]];
                    }
                }
            }
        }

        return dp[nums.length - 1][sum];
    }
}