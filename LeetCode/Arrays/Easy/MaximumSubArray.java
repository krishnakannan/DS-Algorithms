public class Solution {
    public int maxSubArray(int[] nums) {
        int[] mem = new int[nums.length];
        int max = Integer.MIN_VALUE;
        mem[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	if (mem[i - 1] < 0) {
        		mem[i] = nums[i];
        	} else {
        		mem[i] = mem[i - 1] + nums[i];
        	}
        }

        for (int i = 0; i < mem.length; i++) {
        	System.out.print(mem[i] + ", ");
        	max = max < mem[i] ? mem[i] : max;
        }

        return max;    
    }
}