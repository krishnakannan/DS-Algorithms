import java.util.*;
import java.lang.*;
import java.io.*;

	//http://practice.geeksforgeeks.org/problems/unsorted-array/0

class LeftSmallerRightBigger {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LeftSmallerRightBigger lsrb = new LeftSmallerRightBigger();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(lsrb.getElement(arr));
 		}
	}

	public long getElement(int[] arr) {
		int[] l2r = new int[arr.length];
		int[] r2l = new int[arr.length];
		int maxSoFar = Integer.MIN_VALUE;
		l2r[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			l2r[i] = arr[i] > l2r[i - 1] ? arr[i] : l2r[i - 1];
		}
		r2l[r2l.length - 1] = arr[arr.length - 1];
		for (int i =  arr.length - 2; i >= 0; i--) {
			r2l[i] = arr[i] < r2l[i + 1] ? arr[i] : r2l[i + 1];
		}

		// for (int i = 0; i < arr.length; i++) {
		// 	System.out.println("ARR = " + arr[i] + " L2R = " + l2r[i] + " R2L = " + r2l[i]);
		// }
		for (int i = 1; i <= arr.length - 2; i++) {
			if (arr[i] == l2r[i] && arr[i] <= r2l[i]) {
				return arr[i];
			}
		}

		return -1;
	}
}