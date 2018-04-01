public class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mIndex = nums.length > 0 ? nums.length / 2 : -1;
        int median = nums.length > 0 ? nums[mIndex] : Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += Math.abs(median - nums[i]);
        }
        
        return count; 
    }
}