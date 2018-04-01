public class Solution {
    public void rotate(int[] nums, int k) {
        k = k > nums.length ? k % nums.length : k;
        int n = nums.length - k;
        int[] tempArr = new int[n];
        for (int i = 0; i < n; i++) {
            tempArr[i] = nums[i];
        }
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            nums[index] = nums[i];
            index++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] +" ");
        }
        index = 0;
        for (int i = k; i < nums.length; i++) {
            nums[i] = tempArr[index];
            index++;
        }
    }
}