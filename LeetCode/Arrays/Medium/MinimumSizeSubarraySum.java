class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = -1;
        int left = 0;
        int right = left + 1;
        int count = 1;
        int sum = nums[left];
        while (left <= right) {
        	
        	if (sum < s) {
        		if (right < nums.length) {
        			sum += nums[right];
	        		count++;	        			        		
	        		right++;
        		} else {
        			left++;
        		}
        		
        	} else {
                if (min == -1) {
                    min = count;
                }
        		if (count < min) {
        			min = count;
        		}
        		sum -= nums[left];
        		left++;
        		count--;
        	}
        	
        }

        return min == -1 ? 0 : min;    
    }
}