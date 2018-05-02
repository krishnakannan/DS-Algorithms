import java.util.*;
import java.lang.*;   
import java.io.*;

class ShortestDistanceFromAllBuildings {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();	
		int[][] grid = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				grid[i][j] = in.nextInt();
			}
		}]

		ShortestDistanceFromAllBuildings sdfab = new ShortestDistanceFromAllBuildings();
		System.out.println(sdfab.shortestDistance(grid));
	}

	long[][] distances;
	int[][] neighbors = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] grid) {
    	initDistances(grid);
    	long minDistance = Integer.MAX_VALUE;
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1) {
    				bfs(grid, i, j);
    			}
    		}
    	}

    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			minDistance = minDistance > distances[i][j] ? distances[i][j] : minDistance;
    		}
    	}
    	return minDistance == 0 || minDistance == Integer.MAX_VALUE  ? -1 : (int)minDistance;
    }


    public void bfs(int[][] grid, int row, int col) {
    	Queue<int[]> bfsQ = new LinkedList<>();
    	int[][] currentDistances = new int[grid.length][grid[0].length];
    	for (int i = 0; i < currentDistances.length; i++) {
    		Arrays.fill(currentDistances[i], Integer.MAX_VALUE);
    	}
    	bfsQ.add(new int[]{row, col});
    	int distance = 0;
        currentDistances[row][col] = distance;
    	while (!bfsQ.isEmpty()) {
    		int[] current = bfsQ.poll();
    		distance = currentDistances[current[0]][current[1]] + 1;
    		for (int[] neighbor : neighbors) {
    			int nextRow = current[0] + neighbor[0];
    			int nextCol = current[1] + neighbor[1];
    			if (nextRow >= 0 && nextRow < grid.length && nextCol >= 0 && nextCol < grid[0].length && grid[nextRow][nextCol] == 0) {
    				if ((distance) < currentDistances[nextRow][nextCol]) {
    					bfsQ.add(new int[]{nextRow, nextCol});
                        currentDistances[nextRow][nextCol] = distance;
    				}
    			}
    		}
    	}
        //System.out.println("From row = " + row + "  col = " + col);
    	for (int i = 0; i < currentDistances.length; i++) {
    		for (int j = 0; j < currentDistances[0].length; j++) {
                //System.out.print(currentDistances[i][j] + " ");
    			distances[i][j] += currentDistances[i][j];
    		}
            //System.out.println();
    	}
    }


    public void initDistances(int[][] grid) {
    	distances = new long[grid.length][grid[0].length];
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] > 0) {
    				distances[i][j] = Integer.MAX_VALUE;
    			}
    		}
    	}
    }
}