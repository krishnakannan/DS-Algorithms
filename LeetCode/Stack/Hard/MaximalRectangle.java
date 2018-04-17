class MaximalRectangle {


	public int maximalRectangle(char[][] matrix) {
     	int maxArea = 0;
     	int heights = new int[matrix[0].length];
     	for (int i = 0; i < matrix.length; i++) {
     		for (int j = 0; j < matrix[0].length; j++) {
     			if (matrix[i][j] == '0') {
     				heights[j] = 0;
     			} else {
     				heights[j]++;
     			}
     		}
     		int area = largestRectangleArea(heights);
     		maxArea = maxArea < area ? area : maxArea;	
     	}
     	return maxArea;
    }

	

	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();        
		int maxArea = 0;
		int area = 0;
		int length = heights.length;
		stack.push(0);
		int i = 1;
		for (; i < length; i++) {
			if (heights[stack.peek()] <= heights[i]) {
				stack.push(i);
			} else {
				while (!stack.empty() && heights[stack.peek()] > heights[i]) {
					int top = stack.pop();
					if (stack.empty()) {
						area = heights[top] * i;	
					} else {
						area = heights[top] * (i - 1 - stack.peek());
					}
					maxArea = maxArea < area ? area : maxArea;					
				}				
				stack.push(i);
			}
		}

		while (!stack.empty()) {
			int top = stack.pop();
			if (stack.empty()) {
				area = heights[top] * length;	
			} else {
				area = heights[top] * (length - 1 - stack.peek());
			}
			maxArea = maxArea < area ? area : maxArea;					
		}				
		maxArea = maxArea < area ? area : maxArea;
		return maxArea;
	}
}