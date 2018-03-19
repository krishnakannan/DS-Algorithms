class Solution {

	boolean[] visited;

    public int arrayNesting(int[] nums) {
    	visited = new boolean[nums.length];
    	int maxCount = 0;
    	for (int i = 0; i < nums.length; i++) {
    		int count = 0;
    		if (!visited[i]) {
    			count = mark(nums, i);
    		}
    		maxCount = maxCount < count ? count : maxCount;
    	}
    	return maxCount;
    }

    public int mark(int[] nums, int index) {

    	if (visited[index]) {
    		return 0;
    	}
    	int count = 0;
    	
    	while (!visited[index]) {
    		int nextIndex = nums[index];
    		visited[index] = true;
    		count++;
    		index = nextIndex;
    	}

    	return count;
    }
}