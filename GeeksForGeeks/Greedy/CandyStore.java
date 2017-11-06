import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/shop-in-candy-store/0

class CandyStore {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		CandyStore cs = new CandyStore();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int k = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
		    Arrays.sort(arr);
		    System.out.println(cs.findMinCost(arr, k)  + " " + cs.findMaxCost(arr, k));
			
 		}			
	}

	public int findMinCost(int arr[], int k) {
		int i = 0;
		int j = arr.length - 1;
		int cost = 0;
		while (i <= j) {			
			cost += arr[i];
			i++;
			j -= k;
		}
		return cost;
	}

	public int findMaxCost(int arr[], int k) {
		int i = 0;
		int j = arr.length - 1;
		int cost = 0;
		while (j >= i) {			
			cost += arr[j];
			j--;
			i += k;
		}
		return cost;
	}
}