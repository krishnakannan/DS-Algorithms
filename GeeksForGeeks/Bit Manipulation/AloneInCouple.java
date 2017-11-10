import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/alone-in-couple/0

class AloneInCouple {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		AloneInCouple aic = new AloneInCouple();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int arr[] = new int[n];
		    for (int i = 0; i < n; i++) {
		    	arr[i] = in.nextInt();
		    }
		    System.out.println(aic.findLoneNumber(arr));
 		}
	}

	public int findLoneNumber(int[] arr) {				
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			x ^= arr[i];
		}
		return x;
	}
}