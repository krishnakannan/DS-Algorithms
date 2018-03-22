class Solution {
    public int[] nextGreaterElements(int[] nums) {
 		Stack<Integer> stack = new Stack<>();
 		int[] nextGreater = new int[nums.length];
        boolean[] filled = new boolean[nums.length];

 		for (int i = nums.length - 1; i >= 0; i--) {
 			if (stack.empty()) {
 				stack.push(nums[i]); 				
 			} else if (nums[i] < stack.peek()) {
 				nextGreater[i] = stack.peek();
                filled[i] = true;
 				stack.push(nums[i]);
 			} else {
 				while (!stack.empty() && nums[i] >= stack.peek()) {
 					stack.pop();
 				}
 				if (!stack.empty()) {
	 				nextGreater[i] = stack.peek(); 					
                    filled[i] = true;
	 			}
                stack.push(nums[i]);
 			}            
 		}
        
 		for (int i = nums.length - 1; i >= 0; i--) {
 			if (stack.empty() && !filled[i]) {
 				nextGreater[i] = -1;
                filled[i] = true;
 			} else {
 				if (!filled[i]) {
 					while (!stack.empty() && stack.peek() <= nums[i]) {
 						stack.pop();
 					}
 					if (!stack.empty()) {
 						nextGreater[i] = stack.peek();
                        filled[i] = true;
 					} else {
 						nextGreater[i] = -1;
                        filled[i] = true;
 					}
 				}
 			}
 		}
        return nextGreater;
    }
}