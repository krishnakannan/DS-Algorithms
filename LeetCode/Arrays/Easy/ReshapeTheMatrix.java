public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
      int rows = nums.length;
    	int cols = nums[0].length;
    	if ( (rows * cols) != (r * c)) {
    		return nums;
    	}
    	int[][] output = new int[r][c];
    	int row = 0;
    	int col = 0;
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			if (col >= c ) {
    				col = 0;
    				row++;
    			}
    			output[row][col] = nums[i][j];
    			col++;
    		}
    	}
    	return output;  
    }
}