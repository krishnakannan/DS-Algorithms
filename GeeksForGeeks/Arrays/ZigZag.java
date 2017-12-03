import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/convert-array-into-zig-zag-fashion/0


class ZigZag {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		ZigZag zz = new ZigZag();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			zz.arrangeZigZag(arr);
			for (int i = 0; i < arr.length; i++) {
		        System.out.print(arr[i] + " ");
		    }
 		}
	}

	public void arrangeZigZag(int[] arr) {
		boolean isSmaller = true;
		for (int i = 0; i < arr.length - 1; i++) {

			if (isSmaller) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
				isSmaller = false;
				continue;
			}

			if (!isSmaller) {
				if (arr[i] < arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;	
				}
				isSmaller = true;
				continue;
			}
		}
	}
}