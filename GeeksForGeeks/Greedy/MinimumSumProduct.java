import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/minimize-the-sum-of-product/0

class MinimumSumProduct {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MinimumSumProduct msp = new MinimumSumProduct();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    Integer[] arr1 = new Integer[n];
		    Integer[] arr2 = new Integer[n];
		    for (int i = 0; i < arr1.length; i++) {
		        arr1[i] = in.nextInt();
		    }
			for (int i = 0; i < arr2.length; i++) {
		        arr2[i] = in.nextInt();
		    }
		    System.out.println(msp.getMinimumSumOfProduct(arr1, arr2));
 		}
	}

	public int getMinimumSumOfProduct(Integer[] arr1, Integer[] arr2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2, Collections.reverseOrder());
		int sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum += (arr1[i] * arr2[i]);
		}
		return sum;
	}
}