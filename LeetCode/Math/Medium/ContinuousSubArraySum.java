class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > 0){
                break;
            }
        }
        if (k == 0 && sum != 0) {
            return false;
        } else if (k == 0 && sum == 0 && nums.length > 1) {
            return true;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            int val = 0;
            for (int j = i + 1, temp = 0; j < nums.length; j++, temp++) {
                if (temp == 0) {
                    val = nums[i] + nums[j];
                } else {
                    val = nums[j] + val;
                }                
                if (val % k == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}