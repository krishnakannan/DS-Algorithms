//This is not a DP solution complexity - O(R^2 * C);

class Solution {
    public int countCornerRectangles(int[][] grid) {
        int totalCount = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = i + 1; j < grid.length; j++) {
                int count = 0;                
                for (int k = 0; k < grid[0].length; k++) {
                    count += grid[i][k] & grid[j][k];
                }
                
                totalCount += count * (count - 1) >> 1;
            }
        }
        
        return totalCount;
    }
}