class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
			return true;
		}
		boolean can = true;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] - 1 > nums[i] ? nums[i - 1] - 1  : nums[i];
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 0) {
				return false;
			}
		}
		return can; 
    }
}