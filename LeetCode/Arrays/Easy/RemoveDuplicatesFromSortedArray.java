public class Solution {
    public int removeDuplicates(int[] nums) {
        int length = 0;
        for (int i = 1; i < nums.length; i++) {
        	if (nums[length] == nums[i]) {
        		continue;
        	} else {
        		length++;
        		nums[length] = nums[i];
        	}
        }
        return ++length;    
    }
}