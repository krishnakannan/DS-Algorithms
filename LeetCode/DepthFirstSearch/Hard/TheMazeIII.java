import java.util.*;
import java.lang.*;
import java.io.*;

class TheMazeIII {

	public static void main(String args[]) {
		TheMazeIII tm3 = TheMazeIII();
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] maze = new int[m][n];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = in.nextInt();
			}
		}

		int ballx = in.nextInt();
		int bally = in.nextInt();
		int holex = in.nextInt();
		int holey = in.nextInt();

		System.out.println(tm3.findShortestWay(maze, new int[]{ballx, bally}, new int[]{holex, holey}));

	}

	class Solution {
    String[][] path;
	int[][] cost;	

    public String findShortestWay(int[][] origMaze, int[] ball, int[] hole) {
		int[][] newMaze = getNewMaze(origMaze);
		find(newMaze, ball[0] + 1, ball[1] + 1, "", 0, hole[0] + 1, hole[1] + 1);
		return path[hole[0] + 1][hole[1] + 1].startsWith("z") ? "impossible" : path[hole[0] + 1][hole[1] + 1];
    }


    public void find(int[][] maze, int r, int c, String currentPath, int currentCost, int hr, int hc) {
    	if (currentCost > cost[r][c]) {
    		return;
    	} else if (currentCost == cost[r][c] && compare(path[r][c], currentPath) <= 0) {
    		return;
    	}

    	if (maze[r][c] == 1) {
    		return;
    	}
        
    	path[r][c] = currentPath;
    	cost[r][c] = currentCost;

    	//Left
    	int j = c;
    	int tempCost = -1;
    	for (; j >= 1; j--) {    		
    		if (maze[r][j] == 1) {
    			break;
    		}
            tempCost += 1;
    		if (isHole(r, j , hr, hc)) {
    			if (currentCost + tempCost < cost[r][j]) {
    				path[r][j] = currentPath + "l";
                    cost[r][j] = currentCost + tempCost;
    			} else if (currentCost + tempCost == cost[r][j] && compare(path[r][j], currentPath + "l")  > 0) {
		    		path[r][j] = currentPath + "l";
                    cost[r][j] = currentCost + tempCost;
		    	}
    		}
    	}
    	find(maze, r, j + 1, currentPath + "l", currentCost + tempCost, hr, hc);


    	//Right
    	j = c;
    	tempCost = -1;
    	for (; j < maze[0].length - 1; j++) {    		
    		if (maze[r][j] == 1) {
    			break;
    		}
            tempCost += 1;
    		if (isHole(r, j , hr, hc)) {
    			if (currentCost + tempCost < cost[r][j]) {
    				path[r][j] = currentPath + "r";
                    cost[r][j] = currentCost + tempCost;
    			} else if (currentCost + tempCost == cost[r][j] && compare(path[r][j], currentPath + "r") > 0) {
		    		path[r][j] = currentPath + "r";
                    cost[r][j] = currentCost + tempCost;
		    	}
    		}
    	}
    	find(maze, r, j - 1, currentPath + "r", currentCost + tempCost, hr, hc);

    	//Top
		int i = r;
		tempCost = -1;
    	for (; i >= 1; i--) {    		
    		if (maze[i][c] == 1) {
    			break;
    		}
            tempCost += 1;
    		if (isHole(i, c , hr, hc)) {
    			if (currentCost + tempCost < cost[i][c]) {
    				path[i][c] = currentPath + "u";
                    cost[i][c] = currentCost + tempCost;
    			} else if (currentCost + tempCost == cost[i][c] && compare(path[i][c], currentPath + "u") > 0) {
		    		path[i][c] = currentPath + "u";
                    cost[i][c] = currentCost + tempCost;
		    	}
    		}
    	}
    	find(maze, i + 1, c, currentPath + "u", currentCost + tempCost, hr, hc);


    	//Bottom
    	i = r;
    	tempCost = -1;
    	for (; i < maze.length - 1; i++) {    		
    		if (maze[i][c] == 1) {
    			break;
    		}
            tempCost += 1;
    		if (isHole(i, c , hr, hc)) {
    			if (currentCost + tempCost < cost[i][c]) {
    				path[i][c] = currentPath + "d";
                    cost[i][c] = currentCost + tempCost;
    			} else if (currentCost + tempCost == cost[i][c] && compare(path[i][c], currentPath + "d") > 0) {
		    		path[i][c] = currentPath + "d";
                    cost[i][c] = currentCost + tempCost;
		    	}
    		}
    	}
    	find(maze, i - 1, c, currentPath + "d", currentCost + tempCost, hr, hc);
    }

    public boolean isHole(int r, int c, int hr, int hc) {
    	return r == hr && c == hc;
    }

    public int[][] getNewMaze(int[][] maze) {    	
    	int[][] newMaze = new int[maze.length + 2][maze[0].length + 2];
    	path = new String[newMaze.length][newMaze[0].length];
    	cost = new int[newMaze.length][newMaze[0].length];

    	for (int i = 0; i < newMaze.length; i++) {
    		Arrays.fill(newMaze[i], 1);
    		Arrays.fill(cost[i], Integer.MAX_VALUE);
    	}
    	char[] pathArray = new char[newMaze.length];
    	Arrays.fill(pathArray, 'z');
    	for (int i = 1; i < newMaze.length - 1; i++) {
    		for (int j = 1; j < newMaze[0].length - 1; j++) {
    			newMaze[i][j] = maze[i - 1][j - 1];
    			path[i][j] = new String(pathArray);
    		}
    	}
    	return newMaze;
    }

    public int compare(String a, String b) {    	
        return a.compareTo(b);	
    }
}