public class Solution {
    public boolean find132pattern(int[] nums) {
      if (nums.length < 3) {
            return false;
        }                
        
        int low = 0;
        int high = 0;
        int x = 0;
        while (low < nums.length - 2) {

            while (low < nums.length - 2 && nums[low] >= nums[low + 1]) {
                low++;
            }

            high = low + 1;

            while (high < nums.length - 1 && nums[high] <= nums[high + 1]) {
                high++;
            }

            x = high + 1;

            while (x < nums.length) {
                if ( nums[x] > nums[low] && nums[x] < nums[high]) {
                    return true;                
                }
                x++;
                
            }
            low = high + 1;
        }

        
        return false;
    }
}