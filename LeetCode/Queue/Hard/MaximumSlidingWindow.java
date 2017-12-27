class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0) {
			return new int[0];
		}

		int[] output = new int[nums.length - k + 1];
		int oIndex = 0;
		
		Deque<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
		
			while (!queue.isEmpty() && queue.peek() < i - k + 1) {
				queue.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
				queue.pollLast();
			}
			// q contains index... r contains content
			queue.add(i);
			if (i >= k - 1) {
				output[oIndex++] = nums[queue.peek()];
			}
		}
		return output;        
    }
}