import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
/*
	For some weird reason the paths in GFG must be organized as
	1. Down
	2. Left
	3. Right
	4. Up
*/

class RatAndMaze{

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);		
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[][] maze = new int[n][n];
		    for (int i = 0; i < maze.length; i++) {
		    	for (int j = 0; j < maze[0].length; j++) {
		    		maze[i][j] = in.nextInt();
		    	}		        
		    }
			System.out.println(printPath(maze, maze.length));
 		}
	}
    
    public static ArrayList<String> printPath(int[][] m, int n) {
    	RatAndMaze ratMaze = new RatAndMaze();
		ArrayList<String> paths = new ArrayList<>();
		ratMaze.tracePath(m, 0, 0, paths, new StringBuilder());
		return paths;
	}

	public boolean tracePath(int[][] maze, int row, int col, ArrayList<String> paths, StringBuilder builder) {
		
		//BASE CASE
		if (row == maze.length - 1 && col == maze[0].length - 1) {			
			paths.add(builder.toString());
			//System.out.println(builder.toString());			
			return true;
		}		
		//Down
		if (row < maze.length - 1 && row >= 0 && maze[row + 1][col] == 1) {
			maze[row][col] *= -1;
			builder.append("D");
			//System.out.println(builder.toString());
			tracePath(maze, row + 1, col, paths, builder);
			maze[row][col] *= -1;			
			builder.setLength(builder.length() - 1);
			//System.out.println(builder.toString());
		}

		//Left
		if (col < maze[0].length  && col > 0 && maze[row][col - 1] == 1) {
			maze[row][col] *= -1;
			builder.append("L");
			//System.out.println(builder.toString());
			tracePath(maze, row, col - 1, paths, builder);
			maze[row][col] *= -1;
			builder.setLength(builder.length() - 1);
			//System.out.println(builder.toString());
		}

		//Right
		if (col < maze[0].length - 1  && col >= 0 && maze[row][col + 1] == 1) {
			maze[row][col] *= -1;
			builder.append("R");
			//System.out.println(builder.toString());
			tracePath(maze, row, col + 1, paths, builder);
			maze[row][col] *= -1;
			builder.setLength(builder.length() - 1);
			//System.out.println(builder.toString());
		}
		
		//UP
		if (row < maze.length  && row > 0 && maze[row - 1][col] == 1) {
			maze[row][col] *= -1;
			builder.append("U");
			//System.out.println(builder.toString());
			tracePath(maze, row - 1, col, paths, builder);
			maze[row][col] *= -1;
			builder.setLength(builder.length() - 1);
			//System.out.println(builder.toString());
		}
		
		return true;
	}
}