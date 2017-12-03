import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array/0

class KthTwoSortedArray {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		KthTwoSortedArray ktsa = new KthTwoSortedArray();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int m = in.nextInt();
		    int k = in.nextInt();
		    int[] arr1 = new int[n];
		    for (int i = 0; i < arr1.length; i++) {
		        arr1[i] = in.nextInt();
		    }		    
		    int[] arr2 = new int[m];
		    for (int i = 0; i < arr2.length; i++) {
		        arr2[i] = in.nextInt();
		    }
			System.out.println(ktsa.getKth(arr1, arr2, k));
 		}
	}

	public int getKth(int[] a1, int[] a2, int k) {
		int currentIndex = 0;
		int i = 0;
		int j = 0;

		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				currentIndex++;				
				i++;
				if (currentIndex == k) {
					return a1[i - 1];
				}
				
				
			} else {
				currentIndex++;
				j++;
				if (currentIndex == k) {
					return a2[j - 1];
				}
				
				
			}			
		}

		while (i == a1.length && j < a2.length) {
			currentIndex++;
			if (currentIndex == k) {
				return a2[j];
			}
			j++;
		}

		while (i < a1.length && j == a2.length) {
			currentIndex++;			
			if (currentIndex == k) {
				return a1[i];
			}
			i++;
		}

		return -1;
	}
}