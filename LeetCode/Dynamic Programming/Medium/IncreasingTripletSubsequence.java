class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
 		int[] dp = new int[nums.length];
 		Arrays.fill(dp, 1);
        int max = -1;
 		for (int i = 1; i < dp.length; i++) {
 			for (int j = 0; j < i; j++) {
 				if (nums[i] > nums[j]) {
 					dp[i] = dp[i] > dp[j] + 1 ? dp[i] : dp[j] + 1;
 				}
 			}
 		}
        
        for (int i = 0; i < dp.length; i++) {
            max = max < dp[i] ? dp[i] : max;
        }
        
 		return max >= 3;
    }
}

/*

	O(n) Soln
	
	public boolean increasingTriplet(int[] nums) {     
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for(int num : nums){
            if (num <= min) {
              min = num;  
            } else if (num < secondMin)  {
                secondMin = num;
            } else if (num > secondMin) {
                return true;  
            } 
        }
        return false;
    }

*/