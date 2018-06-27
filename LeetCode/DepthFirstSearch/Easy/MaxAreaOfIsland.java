class Solution {
    
    public int[][] dirs = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = getIsland(grid, i, j);
                    maxArea = area > maxArea ? area : maxArea;
                }
            }
        }
        return maxArea;
    }
    
    public int getIsland(int[][] grid, int x, int y) {
        int size = 1;        
        grid[x][y] = 0;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                size += getIsland(grid, nx, ny);
            }
        }
        return size;
    }
}