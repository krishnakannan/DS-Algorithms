class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = left + 1;
        int maxLength = 1;
        while (right < nums.length) {
            if (nums[right] > nums[right - 1]) {
                right += 1;
            } else {
                int length = right - left;
                maxLength = length > maxLength ? length : maxLength;
                left = right;
                right = left + 1;
            }
        }
        
        int finalLength = right - left;
        maxLength = finalLength > maxLength ? finalLength : maxLength;
        
        return maxLength;
    }
}