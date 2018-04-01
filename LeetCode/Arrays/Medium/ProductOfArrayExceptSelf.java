public class Solution {
    public int[] productExceptSelf(int[] nums) {
        long mul = 1l;
        boolean hasZero = false;
        boolean isMultipleZero = false;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && !hasZero) {
                hasZero = true;
                continue;
            } 
            if (hasZero && nums[i] == 0) {
                mul = 0l;
                isMultipleZero = false;
            }
            mul *= (long)nums[i];
        }            
        
        if (isMultipleZero) {
            for (int i = 0; i < nums.length; i++) {
                output[i] = 0;
            }
        } else if (hasZero && !isMultipleZero) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    output[i] = (int)mul;
                } else {
                    output[i] = 0;
                }
            } 
        } else {
            for (int i = 0; i < nums.length; i++) {
                output[i] = (int) (mul/(long)nums[i]);
            }
        }
        
        return output;
    }
}