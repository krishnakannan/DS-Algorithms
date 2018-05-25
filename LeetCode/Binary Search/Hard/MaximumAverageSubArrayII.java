class Solution {
    
    //Referred Solution
    
    public double findMaxAverage(int[] nums, int k) {
        double left = -10001;
        double right = 10001;
        while (left + 0.00001 < right) {
            double mid = left + (right - left) / 2;
            if (isLargerAvgPresent(nums, k, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public boolean isLargerAvgPresent(int[] nums, int k, double mid) {
        double[] sums = new double[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sums[i] = nums[i] - mid;
        }
        
        double currentVal = 0;
        double prevVal = 0;
        
        for (int i = 0; i < k; i++) {
            currentVal += sums[i];
        }
        if (currentVal >= 0) {
            return true;
        }
        
        for (int i = k; i < nums.length; i++) {
            prevVal += sums[i - k];
            currentVal += sums[i];            
            if (prevVal < 0) {
                currentVal -= prevVal;
                prevVal = 0;
            }
            
            if (currentVal >= 0) {
                return true;
            }            
        }
        return false;
    }
}