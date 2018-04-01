class Solution {
    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1]; 
            }
        }
        return matrix[m - 1][n - 1];
    }
}