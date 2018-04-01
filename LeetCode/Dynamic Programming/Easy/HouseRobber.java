public class Solution {
    public int rob(int[] nums) {
        int maxVal = 0;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int[] mem = new int[nums.length];
        mem[0] = nums[0];
        mem[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for (int i = 2; i < nums.length; i++) {
            mem[i] = (mem[i - 2] + nums[i]) > mem[i - 1] ? (mem[i - 2] + nums[i]) : mem[i - 1];
        }
        
        for (int i = 0; i < mem.length; i++) {
            maxVal = maxVal < mem[i] ? mem[i] : maxVal;    
        }
        
        return maxVal;
    }
}