import java.util.*;
import java.lang.*;
import java.io.*;

public class NumberOfIslands {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		NumberOfIslands numOfIslands = new NumberOfIslands();
	    int n = in.nextInt();
	    char[][] arr = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};	    
	    numOfIslands.numIslands(arr);
	}

	public int numIslands(char[][] grid) {
		int counter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (parseGrid(grid, i, j)) {
					//printGrid(grid);
					counter++;
				}
			}
		}
		return counter;
	}

	public boolean parseGrid(char[][] grid, int i, int j) {


		if (grid[i][j] == '0') {
			return false;
		}

		if (grid[i][j] == 'X') {
			return false;
		}

		grid[i][j] = 'X';

		//Top
		if (i > 0 && grid[i - 1][j] == '1') {
			parseGrid(grid, i - 1, j);
		}
		//Bottom
		if (i < grid.length - 1 && grid[i + 1][j] == '1') {
			parseGrid(grid, i + 1, j);
		}
		//Left
		if (j > 0 && grid[i][j - 1] == '1') {
			parseGrid(grid, i, j - 1);
		}
		//Right
		if (j < grid[0].length - 1 && grid[i][j + 1] == '1') {
			parseGrid(grid, i, j + 1);
		}
		return true;
	}

	public void printGrid(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
	    	for (int j = 0; j < arr[0].length; j++) {
	    		System.out.print(arr[i][j] + " ");
	    	}
	    	System.out.println();
	    }
	    System.out.println();
	}
}