import java.util.*;
import java.lang.*;
import java.io.*;

class ReverseArrayInGroups {
	public static void main (String[] args) {
		ReverseArrayInGroups rag = new ReverseArrayInGroups();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			int k = in.nextInt();
			rag.reverseInGroups(arr, k);	
 		}
	}

	public void reverseInGroups(int arr[], int k) {
		int left = 0;
		int right = left + k - 1;
		int rVal = right;

		while (right < arr.length) {
			while (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;	
			}
			left = rVal + 1;
			right = left + k - 1;
			rVal = right;
 		}
 		right = arr.length - 1;
 		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;	
 		}

 		for (int i = 0; i < arr.length; i++) {
 			System.out.print(arr[i] + " ");
 		}
 		System.out.println();
	}


}