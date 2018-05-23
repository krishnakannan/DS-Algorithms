import java.util.*;
import java.lang.*;
import java.io.*;

class CherryPickup {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);		
		int n = in.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		CherryPickup cp = new CherryPickup();
		System.out.println(cp.cherryPickup(grid));
	}

	/*
		First implemented the Two Way DP (Greedy) approach. 

		Implementing official solution

	*/


	int[][][] dp;

    public int cherryPickup(int[][] grid) {

    	dp = new int[grid.length][grid.length][grid.length];
    	for (int i = 0; i < dp.length; i++) {
    		for (int j = 0; j < dp.length; j++) {
    			Arrays.fill(dp[i][j], Integer.MIN_VALUE);
    		}
    	}
    	int cherries = calculate(grid, 0,0,0);
    	return cherries < 0 ? 0 : cherries;
    }


    public int calculate(int[][] grid, int r1, int c1, int c2) {
    	int r2 = r1 + c1 - c2;

    	if (r1 >= grid.length || r2 >= grid.length || c1 >= grid.length || c2 >= grid.length) {
    		return -1000000;
    	}

    	if (grid[r1][c1] == -1 || grid[r2][c2] == -1) {
    		return -1000000;
    	}

    	if (r1 == grid.length - 1 && c1 == grid.length - 1) {
    		return grid[r1][c1];
    	}

    	if (dp[r1][c1][c2] != Integer.MIN_VALUE) {
    		return dp[r1][c1][c2];
    	}

    	int val = grid[r1][c1];
    	if (c1 != c2) {
    		val += grid[r2][c2];
    	}

    	int max = Math.max(Math.max(calculate(grid, r1, c1 + 1, c2), calculate(grid, r1 + 1, c1, c2)), 
    						Math.max(calculate(grid, r1, c1 + 1, c2 + 1), calculate(grid, r1 + 1, c1, c2 + 1)));

    	val += max;
    	dp[r1][c1][c2] = val;
    	return dp[r1][c1][c2];
    }
}