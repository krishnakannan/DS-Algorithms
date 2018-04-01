public class Solution {
    public int findMin(int[] nums) {
        int minIndex = 0;
        int maxIndex = nums.length - 1;        
        while (minIndex < maxIndex) { 
        	int mid = (minIndex + maxIndex)/2;       	
        	if (nums[mid] > nums[maxIndex]) {
        		minIndex = mid + 1;        		
        	} else {
        		maxIndex = mid;
        		
        	}
        }
        return nums[minIndex];
    }
}