import java.util.*;
import java.lang.*;
import java.io.*;

class BricksFallingWhenHit {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] grid = new int[m][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		int hlength = in.nextInt();
		int[][] hits = new int[hlength][2];
		for (int i = 0; i < hits.length; i++) {
			hits[i][0] = in.nextInt();
			hits[i][1] = in.nextInt();
		}
		BricksFallingWhenHit bfwh = new BricksFallingWhenHit();
		System.out.println(Arrays.toString(bfwh.hitBricks(grid, hits)));
	}

	int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};        

    // 0 - dead. 1 - alive. 2 - uncertain;
    
    public int[] hitBricks(int[][] grid, int[][] hits) {        
        int[] result = new int[hits.length];
        print(grid);
        for (int i = 0; i < hits.length; i++) {
        	int[] target = hits[i];
        	grid[target[0]][target[1]] = i;                	        	
            mark(target[0] - 1, target[1], grid, 2);
            mark(target[0] + 1, target[1], grid, 2);
            mark(target[0], target[1] + 1, grid, 2);
            mark(target[0], target[1] - 1, grid, 2);        	            
        }
        print(grid);
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] > 0) {
                mark(0, j, grid, 1);
            }
        }
        print(grid);
        for (int i = 0; i < hits.length; i++) {
            int[] target = hits[i];
            int x = target[0];
            int y = target[1];
            int count = 0;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                    count += sweep(grid, nx, ny);
                }
    	    }
            result[i] = count;
        }
        print(grid);
        return result;
    }

    public int sweep(int[][] grid, int x, int y) {        
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
    		return 0;
    	}        
        if (grid[x][y] == 0 || grid[x][y] == 1) {
            return 0;
        }
        grid[x][y] = 0;
        int count = 0;
        for (int[] dir : dirs) {
    		int nx = x + dir[0];
    		int ny = y + dir[1];
    		if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
    			count += sweep(grid, nx, ny);
    		}
    	}
        return count;
    }


    public void mark(int x, int y, int grid[][], int num) {
        
    	if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
    		return;
    	}    	
        
        if (grid[x][y] == 0 || grid[x][y] == num) {
            return;
        }
        
        grid[x][y] = num;
    	
    	for (int[] dir : dirs) {
    		int nx = x + dir[0];
    		int ny = y + dir[1];
    		if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
    			mark(nx, ny, grid, num);
    		}
    	}    	
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

	