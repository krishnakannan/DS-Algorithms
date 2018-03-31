class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
          return 0;                   
        } 
        int count = 0;
        int left = 0;
        int right = 0;
        int maxProduct = 1;
       
        for (right = 0; right < nums.length; right++) {                           
            maxProduct *= nums[right];
            while (maxProduct >= k) {
                maxProduct /= nums[left++];
            }
            count += right - left + 1;
        }
        return count;
    }
}