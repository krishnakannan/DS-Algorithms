class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        boolean hasZero = false;
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right < nums.length) {
            if (nums[right] == 1) {
                right++;
            } else {
                if (!hasZero) {
                    hasZero = true;
                    right++;
                } else {
                    int length = right - 1 - left + 1;
                    while (left < right && nums[left] == 1) {
                        left++;
                    }
                    left++;
                    right++;
                    maxLength = maxLength < length ? length : maxLength;
                }
            }
            //System.out.println("Left " + left + " Right " + right); 
        }
        
        int length = right - 1 - left + 1;
        maxLength = maxLength < length ? length : maxLength;
        
        return maxLength;
    }
}