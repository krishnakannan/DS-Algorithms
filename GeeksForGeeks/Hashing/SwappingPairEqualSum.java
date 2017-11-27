import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/swapping-pairs-make-sum-equal/0

class SwappingPairEqualSum {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		SwappingPairEqualSum spes = new SwappingPairEqualSum();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int m = in.nextInt();
		    int[] arr1 = new int[n];
		    int[] arr2 = new int[m];
		    int total1 = 0;
			int total2 = 0;			
		    for (int i = 0; i < arr1.length; i++) {
		        arr1[i] = in.nextInt();
		        total1 += arr1[i];
		    }
		    for (int i = 0; i < arr2.length; i++) {
		        arr2[i] = in.nextInt();
		        total2 += arr2[i];
		    }
			System.out.println(spes.swapPairs(arr1, arr2, total1, total2) ? "1" : "-1");
 		}	
	}

	public boolean swapPairs(int[] arr1, int[] arr2, int total1, int total2) {
		int optimalSize = (total1 + total2) / 2;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr1.length; i++) {
			set.add(arr1[i]);
		}
		for (int i = 0; i < arr2.length; i++) {
			int diff = total2 - arr2[i];
			if (set.contains(optimalSize - diff)) {
				return true;
			}
		}
		return false;
	}


}