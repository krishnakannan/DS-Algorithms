class Solution {
    
    //Referred Soln
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n + 1][n + 1];
        return calculate(1, n);
        
    }
    
    public int calculate(int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int val = i + Math.max(calculate(start, i - 1), calculate(i + 1, end));
            res = Math.min(res, val);
        }
        dp[start][end] = res;
        return dp[start][end];
    }
}