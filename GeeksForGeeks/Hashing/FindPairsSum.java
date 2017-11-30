import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x/0

class FindPairsSum {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		FindPairsSum fps = new FindPairsSum();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int m = in.nextInt();
		    int sum = in.nextInt();
		    Integer[] arr1 = new Integer[n];
		    Integer[] arr2 = new Integer[m];
		    for (int i = 0; i < arr1.length; i++) {
		        arr1[i] = in.nextInt();
		    }
		    for (int i = 0; i < arr2.length; i++) {
		        arr2[i] = in.nextInt();
		    }
			fps.printPairs(arr1, arr2, sum);
 		}
	}

	public void printPairs(Integer[] arr1, Integer[] arr2, int sum) { 		
		int[] hashtable = new int[2001];		
		boolean isFirst = true;
		
		for (int i = 0; i < arr1.length; i++) {
			hashtable[getHashedIndex(arr1[i])] = 1;
		}

		Arrays.sort(arr2, new Comparator<Integer>() {			
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});

		for (int i = 0; i < arr2.length; i++) {						
			if (hashtable[getHashedIndex(sum - arr2[i])] > 0) {
				if (!isFirst) {				
					System.out.print(", ");
				}
				isFirst = false;
				System.out.print((sum - arr2[i]) + " " + arr2[i]);
			}
		}
		if (isFirst) {
			System.out.print("-1");
		}
		System.out.println();
	}

	public int getHashedIndex(int index) {
		return index + 1000;
	}


}