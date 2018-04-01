class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
        int leftmost = 0;
        int left = leftmost + 1;
        int center = left + 1;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length - 3; i++) {
        	leftmost = i;        
        	if (i > 0) {
        		if (nums[i] == nums[i -1]) {
        			continue;
        		}
        	}
            if (leftmost == 0 || (leftmost > 0 && nums[leftmost] != nums[leftmost - 1])) { 
                for (int j = leftmost + 1; j < nums.length - 2; j++) {
                    left = j;
                    center = left + 1;
                    right = nums.length - 1;
                    if(j > i + 1 && nums[j] == nums[j-1])continue;
                        while (center < right) {
                            if (nums[leftmost] + nums[left] + nums[center] + nums[right] == target) {
                                result.add(Arrays.asList(nums[leftmost], nums[left], nums[center], nums[right]));
                                while (center < right && nums[center] == nums[center + 1]) center++;
                                while (center < right && nums[right] == nums[right - 1]) right--;
                                center++;
                                right--;
                            } else if (nums[leftmost] + nums[left] + nums[center] + nums[right] < target) {
                                center++;
                            } else {
                                right--;
                            }
                        }
                    
                }
            }
        }
        return result;      
    }
}