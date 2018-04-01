class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;        
        int count = 0;
        int sum = 0;
        int right = left;
        while (right < nums.length) {
        	//System.out.println("LEFT = " + left + " RIGHT = " + right + " COUNT = " + count + " SUM = " + sum);
        	if (right == 0) {
        		nums[left] = nums[right];
        		count++;
        		right++;
        		left++;
        		continue;
        	}
        	
        	if (nums[right - 1] == nums[right]) {        	
				if (count < 2) {
	    			nums[left] = nums[right];
	        		count++;
	        		right++;
	    			left++;
	        	} else {
	        		right++;
	        		
	        	} 		        				 
        	} else {
        		sum += count;
        		count = 1;        		        		
        		nums[left] = nums[right];
        		left++;
        		right++;
        	}


        	// if (right == nums.length - 1) {
	        // 	sum += count;
	        // }
        	
        }
        sum += count;
        return sum;
    }
}