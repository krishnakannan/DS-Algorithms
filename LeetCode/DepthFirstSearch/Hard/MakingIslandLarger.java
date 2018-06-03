import java.util.*;
import java.lang.*;
import java.io.*;

class MakingIslandLarger {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		MakingIslandLarger mil = new MakingIslandLarger();
		System.out.println(mil.largestIsland(grid));
	}

	int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	int[][] islandNumber;

    public int largestIsland(int[][] grid) {
    	islandNumber = new int[grid.length][grid[0].length];    
    	int iNumber = 1;
    	print(grid);
    	print(islandNumber);
    	int largestIsland = Integer.MIN_VALUE;

    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1) {
    				int sizeOfIsland = getSize(grid, i, j, iNumber);
    				largestIsland = size > largestIsland ? size : largestIsland;
    				mark(grid, i, j, sizeOfIsland);
    				iNumber += 1;
    			}
    		}
    	}
    	
    	print(grid);
    	print(islandNumber);

    	

    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 0) {
    				int currentIslandSize = 1;
    				Set<Integer> parsedIsland = new HashSet<>();
    				for (int[] dir : dirs) {
			    		int nx = i + dir[0];
			    		int ny = j + dir[1];
			    		if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] > 0) {
			    			if (!parsedIsland.contains(islandNumber[nx][ny])) {
			    				parsedIsland.add(islandNumber[nx][ny]);
			    				currentIslandSize += grid[nx][ny];
			    			}
			    		}
			    	} 
			    	largestIsland = largestIsland < currentIslandSize ? currentIslandSize : largestIsland;
    			}
    		}
    	}

    	return largestIsland;
    }

    public void mark(int[][] grid, int x, int y, int size) {
    	if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
    		return;
    	}
    	if (grid[x][y] == 0) {
    		return;
    	}
    	grid[x][y] = size;    	
    	for (int[] dir : dirs) {
    		int nx = x + dir[0];
    		int ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] != size) {
			    mark(grid, nx, ny, size);    
            }
    	}        	
    }

    public int getSize(int[][] grid, int x, int y, int iNumber) {
    	if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
    		return 0;
    	}
    	if (grid[x][y] == 0) {
    		return 0;
    	}
    	int count = 1;
    	islandNumber[x][y] = iNumber;

    	for (int[] dir : dirs) {
    		int nx = x + dir[0];
    		int ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && islandNumber[nx][ny] != iNumber) {
			    count += getSize(grid, nx, ny, iNumber); 
            }
    		
    	}    
    	return count;
    }

    public void print(int[][] grid) {
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			System.out.print(grid[i][j] + " ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
}