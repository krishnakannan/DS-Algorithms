public class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int add = 0;
        for (int i = 0; i < nums.length; i +=2) {
            add += nums[i];
        }
        return add;
    }
}