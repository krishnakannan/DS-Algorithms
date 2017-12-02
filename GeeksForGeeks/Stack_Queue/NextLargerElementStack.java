import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/next-larger-element/0

public class NextLargerElementStack {
	public static void main (String[] args) {		
		NextLargerElementStack ne = new NextLargerElementStack();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();		        
		    }		
		    int[] ret = ne.getNextLarger(arr);
		    for (int i = 0; i < ret.length; i++) {
		    	System.out.print(ret[i] + " ");		    	
		    }		    
		    System.out.println();
 		} 		
	}

	public int[] getNextLarger (int arr[]) {
		Stack<Integer> stack = new Stack<>();
		int currentInteger = -1;
		
		int[] result = new int[arr.length];
		int index = arr.length - 1;
		result[index] = -1;
		index--;
		stack.push(arr[arr.length - 1]);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (!stack.empty() && arr[i] <= stack.peek()) {
				result[index] = stack.peek();
				index--;
			} else {
				while(!stack.empty()) {
					if (arr[i] > stack.peek()) {
						stack.pop();
					} else {
						result[index] = stack.peek();
						index--;
						break;
					}	
				}
				if (stack.empty()) {
					result[index] = -1;
					index--;					
				}				
			}

			if (i > 0 && arr[i] > arr[i - 1]) {
				stack.push(arr[i]);
			}
		}
			
		return result;
	}
	

}