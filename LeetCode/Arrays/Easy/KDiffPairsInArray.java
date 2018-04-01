public class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        Map<Integer, Integer> vals = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
        	int diff = 0;
        	for (int j = i + 1; j < nums.length; j++) {
        		diff = findDiff(nums[i], nums[j]);
        		if (diff == k) {
        			vals.put(nums[i], nums[j]);
        		} else if (diff > k) {
        			break;
        		} else {
        			continue;
        		}
        	}
        }
        return vals.size();
    }

    public int findDiff (int a, int b) {
    	return a > b ? (a - b) : (b - a);
    }
}