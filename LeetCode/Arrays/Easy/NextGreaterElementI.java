public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] list = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
        	int x = -1;
        	for (int j = 0; j < nums.length; j++) {
        		if (findNums[i] == nums[j]) {
        			for (int k = j + 1; k < nums.length; k++) {
        				if (nums[k] > nums[j]) {
        					x = nums[k];
        					break;
        				}
        			}
        			break;
        		} 
        	}
        	list[i] = x;
        }
        return list;
    }
}