public class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            min = min > nums[i] ? nums[i] : min;
        }
        
        for (int i = 0; i < nums.length; i++) {
            ret += nums[i] - min;
        }
        
        return ret;
    }
}