class Solution {
    public int maxKilledEnemies(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] rSumAux = new int[grid.length][grid[0].length];
        int[][] cSumAux = new int[grid.length][grid[0].length];
        calculateRows(grid, rSumAux);
        calculateCols(grid, cSumAux);
        //print()
        
        int maxKilled = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '0') {
                    maxKilled = maxKilled < rSumAux[i][j] + cSumAux[i][j] ? rSumAux[i][j] + cSumAux[i][j] : maxKilled;
                }
            }
        }
        return maxKilled;
    }
    
    
    public void calculateRows(char[][] grid, int[][] rSumAux) {
        
        int count = 0;
        //Left to right;
        for (int i = 0; i < grid.length; i++) {
            count = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                }
                rSumAux[i][j] = rSumAux[i][j] < count ? count : rSumAux[i][j];
            }
        }
        
        //Right to left
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 2; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    continue;    
                }
                rSumAux[i][j] = rSumAux[i][j] < rSumAux[i][j + 1] ? rSumAux[i][j + 1] : rSumAux[i][j];
            }
        }                
    }
    
    public void calculateCols(char[][] grid, int[][] cSumAux) {
        
        int count = 0;
        //Top to bottom;
        for (int j = 0; j < grid[0].length; j++) {
            count = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 'E') {
                    count++;
                } else if (grid[i][j] == 'W') {
                    count = 0;
                }
                cSumAux[i][j] = cSumAux[i][j] < count ? count : cSumAux[i][j];
            }
        }
        
        //Bottom to top
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = grid.length - 2; i >= 0; i--) {
                if (grid[i][j] == 'W') {
                    continue;
                }
                cSumAux[i][j] = cSumAux[i][j] < cSumAux[i + 1][j] ? cSumAux[i + 1][j] : cSumAux[i][j];
            }
        }                
    }
    
    public void print(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}