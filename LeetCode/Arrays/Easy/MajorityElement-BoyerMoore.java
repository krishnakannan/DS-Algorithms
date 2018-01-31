public class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count++;
            } else if (candidate == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        
        
            //Question assures that there exists a majority element;
            // No need for verification
            
            // count = 0;
            // for (int i = 0; i < nums.length; i++) {
            //     if (nums[i] == candidate) {
            //         count++;
            //     }
            // }         

        
        return candidate;
    }
}