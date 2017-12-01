import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/find-whether-path-exist/0

class PathExists {	
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		PathExists pathObj = new PathExists();
		while (--testcases >= 0) {
		    int n = in.nextInt();		    
		    int[][] arr = new int[n][n];
		    for (int i = 0; i < arr.length; i++) {
		    	for (int j = 0; j < arr[0].length; j++) {
		    		arr[i][j] = in.nextInt();	
		    	}		        
		    }			    
		    System.out.println(pathObj.hasPath(arr) ? "1" : "0");
 		}
	}


	public boolean hasPath(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
	    	for (int j = 0; j < arr[0].length; j++) {
	    		if (arr[i][j] == 1) {
	    			return tracePath(arr, i, j);	    			
	    		}
	    	}		        
	    }	
	    return false;	
	}

	public boolean tracePath(int[][] arr, int row, int col) {
		if (row < 0 || row >= arr.length || col < 0 || col >= arr[0].length)  {
			return false;
		}
		if (arr[row][col] == 0 || arr[row][col] == -1) {
			return false;
		}
		if (arr[row][col] == 2) {			
			return true;
		}
		arr[row][col] = -1;
		return tracePath(arr, row + 1, col) || tracePath(arr, row, col + 1) 
			|| tracePath(arr, row - 1, col) || tracePath(arr, row, col - 1);
	}
}