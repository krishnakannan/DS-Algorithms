public class Solution {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
		int cols = grid[0].length;
		int out = 0;
		int temp = 0;
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < cols; j++) {
        		temp = 0;
        		if (grid[i][j] == 1) {
        			temp = 4;
        			if (i == 0) {
        				out++;
        				temp--;
        			} else if (grid[i-1][j] == 1) {        				
        				temp--;
        			} 
        			
        			if (i == rows - 1) {
        				out++;
        				temp--;
        			} else if (grid[i+1][j] == 1) {
        				temp--;
        			}

        			if (j == 0) {
        				out++;
        				temp--;
        			} else if (grid[i][j-1] == 1) {
        				temp--;
        			}

        			if (j == cols - 1) {
        				out++;
        				temp--;
        			} else if (grid[i][j+1] == 1) {
        				temp--;
        			}
        			out += temp;
        		}
        	}
        	
        }
        return out;
    }
}