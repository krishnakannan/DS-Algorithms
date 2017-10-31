import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/pythagorean-triplet/0

class PythogoreanTriplet {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		PythogoreanTriplet pt = new PythogoreanTriplet();
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(pt.isPTPresent(arr));
 		}
	}

	public String isPTPresent(int arr[]) {
		if (arr.length < 3) {
			return "No";
		}
		int j = 0; 
		int k = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr[i];
		}
		Arrays.sort(arr);
		for (int i = arr.length - 1; i >= 2; i--) {
			j = 0;
			k = i - 1;
			while (j < k) {				
				if (arr[j] + arr[k] == arr[i]) {
					return "Yes";
				} else if (arr[j] + arr[k] > arr[i]) {
					k--;
				} else {
					j++;
				}
			}
		}
		return "No";
	}
}