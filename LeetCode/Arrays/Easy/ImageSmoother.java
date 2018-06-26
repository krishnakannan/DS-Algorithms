class Solution {
    int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public int[][] imageSmoother(int[][] M) {
        int[][] smoothed = new int[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                int total = M[i][j];
                int neighborCount = 1;
                for (int[] dir : dirs) {
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if (x >= 0 && x < M.length && y >= 0 && y < M[0].length) {
                        total += M[x][y];
                        neighborCount += 1;
                    }
                }
                smoothed[i][j] = total / neighborCount;
            }
        }
        return smoothed;
    }
}