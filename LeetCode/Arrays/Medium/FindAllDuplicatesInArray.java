public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	
    	for (int i = 0; i < nums.length; i++) {
    		int index = abs(nums[i]);
    		if (nums[index - 1] < 0) {
    			res.add(abs(index));
    		} else {
    			nums[index - 1] = - nums[index - 1];	
    		}
    	}
    	return res;
    }
    

    public int abs(int a) {
    	return a >= 0 ? a : -a;
    }
}