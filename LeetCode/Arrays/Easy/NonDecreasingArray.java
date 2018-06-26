class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int decreaseCount = 0;                
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i > 0 && nums[i + 1] < nums[i - 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];  
                } 
                decreaseCount += 1;
            }
            
            if (decreaseCount > 1) {
                return false;
            }
        }        
        return decreaseCount <= 1;
    }
}