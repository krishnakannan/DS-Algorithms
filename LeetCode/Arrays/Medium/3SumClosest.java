class Solution {
    public int threeSumClosest(int[] nums, int target) {				
		int minVal = Integer.MAX_VALUE;
		int returnVal = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {					
			int left = i + 1;
			int right = nums.length - 1;
			int sum = 0;
			while (left < right) {				
				sum = (nums[i] + nums[left] + nums[right]);
				int diffVal = difference(sum, target);
				if (sum == target) {
					return sum;
				} else if (sum < target){
					if (diffVal < minVal) {
						minVal = diffVal;
						returnVal = sum;
					}
					left++;
					//while (left < right && nums[left] == nums[left + 1]) left++;
				} else {
					if (diffVal < minVal) {
						minVal = diffVal;
						returnVal = sum;
					}
					right--;
					//while (left < right && nums[right] == nums[right - 1]) right--;
				}
			}
		}
		return returnVal;
    }

    private int difference (int a, int b) {
    	return a > b ? a - b : b - a;
    }
}