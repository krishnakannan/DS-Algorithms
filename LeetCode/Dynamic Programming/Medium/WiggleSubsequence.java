//https://leetcode.com/problems/wiggle-subsequence/

class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
 		if (nums.length <= 0) {
 			return 0;
 		}
 		int[] diff = new int[nums.length - 1];
 		int[] dp = new int[nums.length];
 		
 		dp[0] = 1;
 		for (int i = 1; i < dp.length; i++) {
 			if (nums[i] - nums[i - 1] > 0) {
 				if (i == 1) {
 					diff[i - 1] = 1;
 					dp[i] = dp[i - 1] + 1;
 				} else {
 					diff[i - 1] = 1;
 					if (diff[i - 1] != diff[i - 2]) {
 						dp[i] = dp[i - 1] + 1;
 					} else {
 						dp[i] = dp[i - 1];
 					}
 				}
 			} else if (nums[i] - nums[i - 1] < 0) {
 				if (i == 1) {
 					diff[i - 1] = -1;
 					dp[i] = dp[i - 1] + 1;
 				} else {
 					diff[i - 1] = -1;
 					if (diff[i - 1] != diff[i - 2]) {
 						dp[i] = dp[i - 1] + 1;
 					} else {
 						dp[i] = dp[i - 1];
 					}
 				} 				
 			} else {
                if (i == 1) {
                    diff[i - 1] = 0;    
                } else {
                    diff[i - 1] = diff[i - 2];
                }
                
                dp[i] = dp[i - 1]; 
            }
 		}

 		// for (int i = 0; i < diff.length; i++) {
 		// System.out.print(diff[i] + " ");
 		// }
 		// System.out.println();
 		// for (int i = 0; i < dp.length; i++) {
 		// System.out.print(dp[i] + " ");
 		// }
 		// System.out.println();

 		return dp[dp.length - 1];
    }
}