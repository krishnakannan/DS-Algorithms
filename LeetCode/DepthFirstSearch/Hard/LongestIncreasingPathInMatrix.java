import java.util.*;
import java.lang.*;   
import java.io.*;

class LongestIncreasingPathInMatrix {

	public static void main(String args[]) {
		LongestIncreasingPathInMatrix lipm = new LongestIncreasingPathInMatrix();
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		System.out.println(lipm.longestIncreasingPath(matrix));
	}

	int[][] memo;
	int[][] neighborIndices = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        memo = new int[matrix.length][matrix[0].length];
        int longestIncreasingPath = 0;

        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		getLongestPath(matrix, i, j);
        	}
        }
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		//System.out.print(memo[i][j] + " ");
        		longestIncreasingPath = memo[i][j] > longestIncreasingPath ? memo[i][j] : longestIncreasingPath;
        	}
        	//System.out.println();
        }
        return longestIncreasingPath;
    }    

    //There is no need to check for Infinite recursion (Maintain Path) as the Path should be strictly increasing. 
    public int getLongestPath(int[][] matrix, int r, int c) {
    	if (memo[r][c] != 0) {
    		return memo[r][c];
    	}
    	List<int[]> neighbors = getNeighbors(matrix, r, c);    	
    	int maxAtCurrent = 1;
    	for (int[] neighbor : neighbors) {
    		int atCurrent = getLongestPath(matrix, neighbor[0], neighbor[1]) + 1;    		
    		maxAtCurrent = maxAtCurrent < atCurrent ? atCurrent : maxAtCurrent;
    	}
    	memo[r][c] = maxAtCurrent;
    	return memo[r][c];
    }

    public List<int[]> getNeighbors(int[][] matrix, int r, int c) {
    	List<int[]> neighbors = new ArrayList<>();
    	for (int[] neighborIndex : neighborIndices) {
    		if (r + neighborIndex[0] >= 0 && r + neighborIndex[0] < matrix.length && c + neighborIndex[1] >= 0 && c + neighborIndex[1] < matrix[0].length) {
    			if (matrix[r + neighborIndex[0]][c + neighborIndex[1]] > matrix[r][c]) {
    				neighbors.add(new int[]{r + neighborIndex[0], c + neighborIndex[1]});
    			}
    		}
    	}    	
    	 return neighbors;
    }
}