class MaximumProductSubArray {

  //https://leetcode.com/problems/maximum-product-subarray/description/
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
          return 0;
        } else if (nums.length == 1) {
          return nums[0];
        }
        int[] dp = new int[nums.length];
        int[] mulArr = new int[nums.length];
        int[] mulRev = new int[nums.length];
        int max = Integer.MIN_VALUE;                
        //init
        dp[0] = nums[0];
        mulArr[0] = nums[0];
        mulRev[mulRev.length - 1] = nums[nums.length - 1];
        for (int i = 1, j = nums.length - 2; i < nums.length && j >= 0; i++, j--) {
            dp[i] = nums[i];            
            mulArr[i] = nums[i] != 0 ? (mulArr[i - 1] != 0 ? nums[i] * mulArr[i - 1] : nums[i]) : 0;
            mulRev[j] = nums[j] != 0 ? (mulRev[j + 1] != 0 ? nums[j] * mulRev[j + 1] : nums[j]) : 0;
        }
        
        for (int i = 1; i < dp.length; i++) {          
            for (int j = i - 1; j >= 0; j--) {
              if ((dp[i] * nums[j]) > dp[i]) {
                dp[i] = dp[i] * nums[j];
              } else {
                break;
              }            
            }            
        }
        
        for (int i = 0; i < dp.length; i++) {
            //System.out.println(dp[i] + " | " + mulArr[i] + " | " + mulRev[i]);
            
            max = dp[i] > max ? dp[i] : max;          
            max = mulArr[i] > max ? mulArr[i] : max;  
            max = mulRev[i] > max ? mulRev[i] : max;  
            
        }
        return max ;  
    }
}
}