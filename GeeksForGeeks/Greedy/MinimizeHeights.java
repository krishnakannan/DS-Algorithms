import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/minimize-the-heights/0

class MinimizeHeights {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MinimizeHeights mh = new MinimizeHeights();
		while (--testcases >= 0) {
			int k = in.nextInt();
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(mh.minHeight(arr, k));
 		}
	}

	public int minHeight(int[] arr, int k) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int median = 0;
		for (int i = 0; i < arr.length; i++) {
			min = min > arr[i] ? arr[i] : min;
			max = max < arr[i] ? arr[i] : max;
		}
		median = (max + min) / 2;
		if ((max - min) < k) {
			return max - min;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= median) {
				arr[i] += k;
			} else {
				arr[i] -= k;
			}
		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;		
		for (int i = 0; i < arr.length; i++) {
			min = min > arr[i] ? arr[i] : min;
			max = max < arr[i] ? arr[i] : max;
		}
		return max - min;
	}
}