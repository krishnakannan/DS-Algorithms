class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;        
        int col = matrix[0].length - 1;

        while (row < matrix.length) {
        	if (matrix[row][col] < target) {
        		row++;
        	} else if (matrix[row][col] == target) {
        		return true;
        	} else {
        		break;
        	}        	
        }

        for (int i = row; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == target) {
        			return true;
        		}
        	}
        }

        return false;
    }
}