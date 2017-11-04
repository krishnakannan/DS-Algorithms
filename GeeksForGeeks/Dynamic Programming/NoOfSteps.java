import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/count-number-of-hops/0

class NoOfSteps {
	public static void main (String[] args) {
		NoOfSteps ns = new NoOfSteps();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = 0;
		    }
			System.out.println(ns.countSteps(arr, n - 1));
 		}	
	}

	public int countSteps(int[] stepsArr, int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			stepsArr[n] = 1;
			return stepsArr[n];
		} else if (n == 1) {
			stepsArr[n] = 2;
			return stepsArr[n];	
		} else if (n == 2) {
			stepsArr[n] = 4;
			return stepsArr[n];
		} else if (stepsArr[n] != 0) {
			return stepsArr[n];
		}
		stepsArr[n] = countSteps(stepsArr, n - 1) + countSteps(stepsArr, n - 2) + countSteps(stepsArr, n - 3);
		return stepsArr[n];
	}
}