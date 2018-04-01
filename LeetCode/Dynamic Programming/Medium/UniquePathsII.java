class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (m == 1 && n == 1 && matrix[0][0] != 1) {
            return 1;
        } else if (m == 1 && n == 1 && matrix[0][0] == 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) {
                break;
            } else {
                matrix[0][i] = -1;    
                
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 1) {
                break;
            } else {
                matrix[i][0] = -1;    
            }
        }
        
        for (int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if (matrix[i][j] <= 0) {
                    if (matrix[i - 1][j] < 0 && matrix[i][j - 1] < 0) {
                        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];     
                    } else if (matrix[i - 1][j] >= 0 && matrix[i][j - 1] < 0) {
                        matrix[i][j] = matrix[i][j - 1];     
                    } else if (matrix[i - 1][j] < 0 && matrix[i][j - 1] >= 0) {
                        matrix[i][j] = matrix[i - 1][j];     
                    }   
                }
            }
        }
        
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(matrix[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return matrix[m - 1][n - 1] == 1 ? 0 : -matrix[m - 1][n - 1];    
    }
}