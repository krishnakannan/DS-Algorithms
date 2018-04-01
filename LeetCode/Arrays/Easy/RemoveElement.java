public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length - 1;
        int first = 0;
        int last = nums.length - 1;
        int temp = 0;
       if (length < 0) {
           return 0;
       }
       if (length <= 0 &&  nums[0] != val) {
           return 1;
       }
       
        while (last >= first) {
        	if (nums[last] == val){
        		last--;
        		continue;
        	} else if (nums[first] == val) {
        		temp = nums[first];
        		nums[first] = nums[last];
        		nums[last] = temp;
        		first++;
        		last--;
        	} else {
        	    first++;
        	}
        } 
        return first;    
    }
}