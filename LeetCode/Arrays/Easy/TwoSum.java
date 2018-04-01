class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] + nums[j] == target) {                    
                    indices[0] = j;
                    indices[1] = i;
                    return indices;
                }
            }
        }
        
        indices[0] = 0;
        indices[1] = 0;
        return indices;
    }
}