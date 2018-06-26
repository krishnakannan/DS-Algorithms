class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = -Double.MAX_VALUE;
        int kSum = 0;
        for (int i = 0; i < k; i++) {
            kSum += nums[i];
        }
        
        for (int i = k; i < nums.length; i++) {
            double avg = (double)kSum / (double)k;
            maxAverage = maxAverage < avg ? avg : maxAverage;
            kSum -= nums[i - k];
            kSum += nums[i];
        }
        double finalAvg = (double)kSum / (double)k;
        
        maxAverage = maxAverage < finalAvg ? finalAvg : maxAverage;
        
        return maxAverage;
    }
}