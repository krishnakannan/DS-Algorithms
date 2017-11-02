import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/path-in-matrix/0

class PathInMatrix {
	int path[][];
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		PathInMatrix pm = new PathInMatrix();
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[][] arr = new int[n][n];
		    pm.path = new int[n][n];
		    for (int i = 0; i < n; i++) {
		    	for (int j = 0; j < n; j++) {
		    		arr[i][j] = in.nextInt();	
		    	}		        
		    }
			System.out.println(pm.getPath(arr));
			//pm.printMatrix(pm.path);
 		}
	}

	public int getPath(int[][] arr) {
		int max = 0;
		for (int i = 0; i < arr[0].length; i++) {
			int longestPath = getLongestPath(arr, 0, i);			
			max = max < longestPath ? longestPath : max;
		}
		return max;
	}

	public int getLongestPath(int[][] arr, int i, int j) {

		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length) {
			return 0;
		}
		if (path[i][j] != 0) {
			return path[i][j];
		}
		if (i == arr.length - 1) {
			path[i][j] = arr[i][j];
			return path[i][j];
		}

		path[i][j] = arr[i][j] + getMax(getLongestPath(arr, i + 1, j), getLongestPath(arr, i + 1, j - 1), getLongestPath(arr, i + 1, j + 1));
		return path[i][j];
	}

	public int getMax(int a, int b, int c) {
		 return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}

	public void printMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
	    	for (int j = 0; j < arr[0].length; j++) {
	    		System.out.print(arr[i][j] + " ");
	    	}		        
	    	System.out.println();
	    }	
	}

}