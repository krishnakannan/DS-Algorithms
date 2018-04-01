public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	if (!numsMap.containsKey(nums[i])) {
        		numsMap.put(nums[i], i);
        	} else {
        		int temp = numsMap.get(nums[i]);
        		if (Math.abs(i - temp) <= k) {
        			return true;
        		} else {
        			numsMap.put(nums[i], i);
        		}
        	}
        }

        return false; 
    }
}