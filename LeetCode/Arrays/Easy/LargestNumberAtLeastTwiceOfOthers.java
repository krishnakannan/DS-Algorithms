class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int largestIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                int temp = firstMax;
                firstMax = nums[i];
                secondMax = temp;
                largestIndex = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        
        if (secondMax == 0 || firstMax / secondMax > 1) {
            return largestIndex;
        }
        
        return -1;
    }
}