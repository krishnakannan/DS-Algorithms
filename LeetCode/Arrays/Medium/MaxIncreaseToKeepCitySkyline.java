class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] rMax = new int[grid.length];
        int[] cMax = new int[grid[0].length];
        int value = 0;
        
        for (int i = 0; i < grid.length; i++) {
            rMax[i] = Integer.MIN_VALUE;
            for (int j = 0; j < grid[0].length; j++) {
                rMax[i] = grid[i][j] > rMax[i] ? grid[i][j] : rMax[i];
            }
        }
        for (int j = 0; j < grid[0].length; j++) {
            cMax[j] = Integer.MIN_VALUE;
            for (int i = 0; i < grid.length; i++) {
                cMax[j] = grid[i][j] > cMax[j] ? grid[i][j] : cMax[j];
            }
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {                
                value += rMax[i] < cMax[j] ? rMax[i]  - grid[i][j] : cMax[j] - grid[i][j];
            }
        }
        
        return value;
        
    }
}