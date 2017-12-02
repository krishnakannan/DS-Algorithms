import java.util.*;
import java.lang.*;
import java.io.*;

//Non Divide and Conquer solution

//https://practice.geeksforgeeks.org/problems/find-the-element-that-appears-once-in-sorted-array/0

class FindElementAppearsOnce {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		FindElementAppearsOnce findElementObj = new FindElementAppearsOnce();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(findElementObj.findElement(arr));
 		}
	}

	public int findElement(int[] array) {
		for (int i = 0; i < array.length - 1; i += 2) {
			if (array[i] != array[i + 1]) {
				return array[i];
			}
		}

		return array[array.length - 1];
	}
}