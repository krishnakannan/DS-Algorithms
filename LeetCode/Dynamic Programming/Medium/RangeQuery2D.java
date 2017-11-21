class NumMatrix {

	int[][] dp;

    public NumMatrix(int[][] matrix) {        
        dp = new int[matrix.length + 2][matrix[0].length + 2];
        for (int i = 1; i <= matrix.length; i++) {
        	int rowSum = 0;
        	for (int j = 1; j <= matrix[0].length; j++) {        		
        		rowSum += matrix[i - 1][j - 1];
        		dp[i][j] = dp[i][j - 1] + rowSum;
        	}
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
     	return dp[row2][col2] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1] - dp[row2][col1 - 1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */