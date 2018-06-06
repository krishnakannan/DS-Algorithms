import java.util.*;
import java.lang.*;
import java.io.*;

class SwimInRisingWater {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = in.nextInt();
			}
		}

		SwimInRisingWater sirw = new SwimInRisingWater();
		System.out.println(sirw.swimInWater(grid));
	}

	/*
		Implementing Dijkstra's. The Highest time in our path is answer.
	*/

	class Elevation {
		int x;
		int y;
		int elevation;
		public Elevation(int x, int y, int elevation) {
			this.x = x;
			this.y = y;			
			this.elevation = elevation;
		}
	}

	int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};	
	boolean[][] visited;
	Elevation[][] elevations;
	
    public int swimInWater(int[][] grid) {
    	int maxTime = Integer.MIN_VALUE;

    	Queue<Elevation> pQueue = new PriorityQueue<Elevation>(new Comparator<Elevation>(){
    		public int compare(Elevation a, Elevation b) {
    			return a.elevation - b.elevation;
    		}
    	});        
    	visited = new boolean[grid.length][grid.length];
    	elevations = new Elevation[grid.length][grid[0].length];    	
    	elevations[0][0] = new Elevation(0, 0, grid[0][0]);
    	pQueue.add(elevations[0][0]);

    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (i == 0 && j == 0) {
    				continue;
    			}	
    			elevations[i][j] = new Elevation(i, j, Integer.MAX_VALUE);
    			pQueue.add(elevations[i][j]);
    		}
    	}    	

    	while (!pQueue.isEmpty()) {
    		Elevation polled = pQueue.poll();    		
    		maxTime = polled.elevation > maxTime ? polled.elevation : maxTime;
    		//System.out.println("Polled => (" + polled.x + "," + polled.y + ")  Elevation " + polled.elevation);
    		if (polled.x == grid.length - 1 && polled.y == grid[0].length - 1) {
    			break;
    		}
    		visited[polled.x][polled.y] = true;    		
    		for (int[] dir : dirs) {
    			int nx = polled.x + dir[0];
    			int ny = polled.y + dir[1];
    			if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid.length && !visited[nx][ny]) {
    				pQueue.remove(elevations[nx][ny]);
    				int newElevation = grid[nx][ny];
    				if (newElevation < elevations[nx][ny].elevation) {
    					elevations[nx][ny].elevation = newElevation;    					
    				}    				
    				pQueue.add(elevations[nx][ny]);
    			}
    		}    		
    	}
    	return maxTime;
    }
}