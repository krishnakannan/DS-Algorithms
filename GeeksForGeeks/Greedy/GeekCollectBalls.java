import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/geek-collects-the-balls/0

class GeekCollectBalls {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		GeekCollectBalls gcb = new GeekCollectBalls();
		while (--testcases >= 0) {
		    int n1 = in.nextInt();
		    int n2 = in.nextInt();
		    int[] arr1 = new int[n1];
		    int[] arr2 = new int[n2];
		    for (int i = 0; i < arr1.length; i++) {
		        arr1[i] = in.nextInt();
		    }
			for (int i = 0; i < arr2.length; i++) {
		        arr2[i] = in.nextInt();
		    }
		    System.out.println(gcb.totalBalls(arr1, arr2));
 		}
	}

	public long totalBalls(int arr1[], int arr2[]) {		
		//Arrays.sort(arr1);
		//Arrays.sort(arr2);				
		long path1 = 0l;
		long path2 = 0l;	
		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				path1 += arr1[i];
				i++;
			} else if (arr1[i] > arr2[j]) {
				path2 += arr2[j];
				j++;
			} else {
				path1 += arr1[i];
				path2 += arr2[j];
				if (path1 > path2) {
					path2 = path1;
				} else {
					path1 = path2;
				}
				i++;
				j++;
			}
		}

		while (i < arr1.length) {
			path1 += arr1[i];
			i++;
		}

		while (j < arr2.length) {
			path2 += arr2[j];
			j++;
		}
		
		return path1 > path2 ? path1 : path2;
	}
}