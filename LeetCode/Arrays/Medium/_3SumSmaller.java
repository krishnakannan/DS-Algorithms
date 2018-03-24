class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int triplets = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    triplets += right - left;
                    left++;
                } else {
                    right--;
                }   
            }            
        }   
        
        return triplets;
    }
}