import java.util.*;
import java.lang.*;
import java.io.*;

class LargestRectangleInHistogram {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		LargestRectangleInHistogram lsih = new LargestRectangleInHistogram();
		int n = in.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < heights.length; i++) {
			heights[i] = in.nextInt();
		}
		System.out.println(lsih.largestRectangleArea(heights));
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