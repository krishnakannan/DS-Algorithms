import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/kadanes-algorithm/0

class Kadanes {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		Kadanes kd = new Kadanes();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
		    System.out.println(kd.getMax(arr));
 		}
	}
	
	public int getMax(int[] arr) {
		int maxVal = Integer.MIN_VALUE;
	    if (arr.length == 0) {
	        return 0;
	    }
	    if (arr.length == 1) {
	        return arr[0];
	    }
	    for (int i = 1; i < arr.length; i++) {
	     	if (arr[i] + arr[i - 1] > arr[i]) {
	     		arr[i] = arr[i] + arr[i - 1];
	     	}   
	    }

	    for (int i = 0; i < arr.length; i++) {
		 	maxVal = maxVal < arr[i] ? arr[i] : maxVal;
	    }
	    return maxVal;
	}
}