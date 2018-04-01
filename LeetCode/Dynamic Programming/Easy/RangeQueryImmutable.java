public class NumArray {
    int[] nums;
    int[] numSumSoFar;
    public NumArray(int[] nums) {
        this.nums = nums;
        this.numSumSoFar = new int[nums.length];
        if (nums.length > 0) {
            numSumSoFar[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                numSumSoFar[i] = nums[i] + numSumSoFar[i - 1];
            }    
        }
    }
    
    public int sumRange(int i, int j) {
        int val = 0;
        return numSumSoFar[j] - numSumSoFar[i] + nums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */