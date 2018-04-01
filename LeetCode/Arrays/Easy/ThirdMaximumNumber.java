public class Solution {
    int firstMax = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    long thirdMax = Long.MIN_VALUE;
    
    public int thirdMax(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                firstMax = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > secondMax && nums[i] < firstMax) {
                secondMax = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > thirdMax && nums[i] < firstMax && nums[i] < secondMax) {
                thirdMax = nums[i];
            }
        }
        
        return thirdMax == Long.MIN_VALUE ? firstMax : (int)thirdMax;
        
    }
}