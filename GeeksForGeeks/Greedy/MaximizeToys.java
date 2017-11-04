import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/maximize-toys/0

class MaximizeToys {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MaximizeToys mt = new MaximizeToys();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int amount = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(mt.noOfToys(arr, amount));
 		}
	}

	public int noOfToys(int[] toys, int amount) {
		int toyCount = 0;
		Arrays.sort(toys);
		int amountRemaining = amount;
		for (int i = 0; i < toys.length && amountRemaining > 0; i++) {
			if (toys[i] < amountRemaining) {
				toyCount++;
				amountRemaining -= toys[i];
			}
		}	

		return toyCount;
	}
}