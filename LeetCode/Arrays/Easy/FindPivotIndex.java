class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int[] prefixSum = new int[nums.length + 2];
        int[] suffixSum = new int[nums.length + 2];
        prefixSum[1] = nums[0];
        suffixSum[nums.length] = nums[nums.length - 1];
        
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            suffixSum[j + 1] = suffixSum[j + 2] + nums[j];
            //System.out.println(Arrays.toString(prefixSum) + "\n" + Arrays.toString(suffixSum) + "\n" + Arrays.toString(nums));
        }
        
        for (int i = 1; i < prefixSum.length - 1; i++) {
            if (prefixSum[i] == suffixSum[i]) {
                return i - 1;
            }
        }
        return -1;
    }
}