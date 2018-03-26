class Solution {
    int[][][] dp;
    int dirs[][] = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};    
    private static final Integer MOD = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        dp = new int[m][n][N + 1];
        for (int x = 0; x < dp.length; x++) {
            for (int y = 0; y < dp[0].length; y++) {
                Arrays.fill(dp[x][y], Integer.MIN_VALUE);
            }
        }

        int totalCount = dfs(N, i, j, m, n);
        return totalCount;
    }

    public int dfs(int moves, int r, int c, int m, int n) {
        
        if (moves == 0) {
            return 0;
        }

        if (r < 0 || r >= m || c < 0 || c >= n) {
            return 0;
        }

        if (dp[r][c][moves] != Integer.MIN_VALUE) {
            return dp[r][c][moves];
        }

        if (moves == 1) {
            int count = getExitCount(r, c, m, n);
            dp[r][c][moves] = count;
            return count;
        }

        int totalCount = 0;
                
        int exitFromCurrent = getExitCount(r, c, m, n);
        
        totalCount += exitFromCurrent;
        
        for (int[] dir : dirs) {            
            totalCount = (totalCount + dfs(moves - 1, r + dir[0], c + dir[1], m, n)) % MOD;
        }
        //totalCount = totalCount % MOD;
        dp[r][c][moves] = totalCount;
        return totalCount;

    }

    public int getExitCount(int r, int c, int totalRows, int totalCols) {
        int count = 0;
        count = (r - 1) < 0 ? count + 1 : count;
        count = (r + 1) >= totalRows ? count + 1 : count;
        count = (c - 1) < 0 ? count + 1 : count;
        count = (c + 1) >= totalCols ? count + 1 : count;
        return count;
    }
}