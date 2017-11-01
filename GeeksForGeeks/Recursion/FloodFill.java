import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/flood-fill-algorithm/0

class FloodFill {
	int[][] arr;
	public static void main (String[] args) {
		FloodFill ff = new FloodFill();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int rows = in.nextInt();
		    int cols = in.nextInt();
		    ff.arr = new int[rows][cols];
		    for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
		        	ff.arr[i][j] = in.nextInt();
		        }
		    }
		    int x = in.nextInt();
		    int y = in.nextInt();
		    int color = in.nextInt();
		    int existingColor = ff.arr[x][y];		    
			ff.fill(x, y, existingColor, color);
			for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
		        	System.out.print(ff.arr[i][j] + " ");
		        }
		        System.out.println();
		    }
 		}
	}

	public void fill(int x, int y, int existingColor, int color) {
		if (x < 0  || x >= arr.length || y < 0 || y >= arr[0].length || arr[x][y] == color) {
			return;
		} else if (arr[x][y] == existingColor) {
			arr[x][y] = color;	
			fill(x - 1, y, existingColor, color);
			fill(x + 1, y, existingColor, color);
			fill(x, y + 1, existingColor, color);
			fill(x, y - 1, existingColor, color);
			
		} 
		
	}
}