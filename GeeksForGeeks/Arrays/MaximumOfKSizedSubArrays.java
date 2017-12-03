import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k/0

class MaximumOfKSizedSubArrays {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MaximumOfKSizedSubArrays mssa = new MaximumOfKSizedSubArrays();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int k = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			mssa.printMaxOfKSizeSubarray(arr, k);
			System.out.println();
 		}
	}

	public void printMaxOfKSizeSubarray(int[] array, int k) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < array.length; i++) {
			//System.out.println(queue);
			if (queue.size() < k) {
				queue.add(array[i]);
			} else {
				int max = findMax(queue);
				System.out.print(max + " ");
				queue.poll();
				queue.add(array[i]);
			}
		}
		int max = findMax(queue);
		System.out.print(max + " ");
	}

	public int findMax(Queue<Integer> queue) {
		int max = Integer.MIN_VALUE;
		for (Integer val : queue) {
			max = max < val ? val : max;
		}
		return max;
	}
}