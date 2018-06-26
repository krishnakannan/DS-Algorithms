class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] counts = new int[nums.length + 1];
        int missing = -1;
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            counts[nums[i]] += 1;
        }
        for (int i = 1; i < counts.length; i++) {
            if (counts[i] == 0) {
                missing = i;
            }
            if (counts[i] == 2) {
                duplicate = i;
            }
            if (missing != -1 && duplicate != -1) {
                break;
            }
        }
        
        return new int[]{duplicate, missing};
    }
}