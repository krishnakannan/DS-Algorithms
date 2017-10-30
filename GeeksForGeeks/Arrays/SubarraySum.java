import java.util.*;
import java.lang.*;
import java.io.*;

class SubarraySum {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		SubarraySum ss = new SubarraySum();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int target = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }		
		    ss.findSubarraySum(arr, target);
 		}
	}

	public void findSubarraySum(int arr[], int target) {
		
		int left = 0;
		int right = left + 1;
		int sum = 0;
		if (arr.length == 0) {
			System.out.println("-1");
			return;
		} 
		if (arr.length == 1) {			
			if (arr[0] == target) {
				System.out.println((arr[0] + 1) + " " + (arr[0] + 1));
			} else {
				System.out.println("-1");
			}
		}
		sum += arr[left] + arr[right];
		while (right < arr.length) {			
			if (sum == target) {
				System.out.println((left + 1) + " " + (right + 1));
				return;
			} else if (sum < target) {				
				right++;
				if (right < arr.length) {
					sum +=  arr[right];	
				}				
			} else {
				sum -= arr[left];
				left++;
				
			}
		}
		System.out.println("-1");
		return;
	}
}