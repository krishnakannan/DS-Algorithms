public class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            } else if (target < nums[i]) {
                return i;
            }
            index = i;
        }
        
        return index + 1;
    }
}