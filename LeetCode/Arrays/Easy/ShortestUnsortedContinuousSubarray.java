class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sNums);
        int left = -1;
        int right = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sNums[i]) {
                left = i;
                break;
            }
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] != sNums[j]) {
                right = j;
                break;
            }
        }
                
        
        return right != -1 && left != -1 ? right - left + 1 : 0;
    }
}