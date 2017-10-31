import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/equilibrium-point/0

class EquilibriumPoint {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		EquilibriumPoint ep = new EquilibriumPoint();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(ep.findEquilibriumPoint(arr));
 		}
	}

	public int findEquilibriumPoint(int[] arr) {
		if (arr.length == 0) {
			return -1;
		}
		if (arr.length == 1) {
			return 1;
		}
		int sum = 0;
		int lSum = 0;
		int rSum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		lSum = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			rSum = sum - arr[i] - lSum;
			if (lSum == rSum) {
				return i + 1;
			} else {
				lSum += arr[i];
			}
		}
		return -1;
	}
}