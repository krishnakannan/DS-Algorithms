public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> oList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
        	if (nums[Math.abs(nums[i]) - 1] > 0){
        		nums[Math.abs(nums[i]) - 1] = -(nums[Math.abs(nums[i]) - 1]);	
        	}
        }
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] > 0) {
        		oList.add(i + 1);
        	}
        }
        return oList;
    }
}