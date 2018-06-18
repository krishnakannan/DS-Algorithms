
// References
// https://www.youtube.com/watch?v=CWDQJGaN1gY
// https://www.geeksforgeeks.org/two-dimensional-segment-tree-sub-matrix-sum/
// https://leetcode.com/problems/range-sum-query-2d-mutable/discuss/75870/Java-2D-Binary-Indexed-Tree-Solution-clean-and-short-17ms


/*
		Better than Segment Tree

		Get Parent - For SUM
		new index = curr_index - (2's complement & curr_index);

		Get Next - For UPDATE
		new index = curr_index + (2's complement & curr_index);
*/

class NumMatrix {

	int[][] grid;
	int[][] fenwickTree;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.grid = new int[matrix.length][matrix[0].length];
        this.fenwickTree = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		update(i, j, matrix[i][j]);
        	}
        }
    }
    
    public void update(int row, int col, int val) {
    	if (grid.length == 0 || grid[0].length == 0) {
    		return;
    	}
    	int difference = val - grid[row][col];
        grid[row][col] = val;
        for (int i = row + 1; i <= grid.length; i = i + (i & (-i))) {
        	for (int j = col + 1; j <= grid[0].length; j = j + (j & (-j))) {
        		fenwickTree[i][j] += difference;
        	}
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (grid.length == 0 || grid[0].length == 0) {
    		return 0;
    	}
    	return getSum(row2 + 1, col2 + 1) + getSum(row1, col1) - getSum(row2 + 1, col1) - getSum(row1, col2 + 1);
    }

    public int getSum(int row, int col) {    	
    	int sum = 0;    	
    	for (int i = row; i > 0; i = i - (i & (-i))) {
        	for (int j = col; j > 0; j = j - (j & (-j))) {
        		sum += fenwickTree[i][j];
        	}
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */