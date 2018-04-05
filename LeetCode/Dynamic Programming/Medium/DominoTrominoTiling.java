class Solution {

//https://leetcode.com/problems/domino-and-tromino-tiling/discuss/116581/Detail-and-explanation-of-O(n)-solution-why-dpn2*dn-1+dpn-3

    public static final int MOD = 1000000000 + 7;
    public int numTilings(int N) {
        if (N <= 1) {
            return 1;
        }
        int dp[] = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (2 * dp[i - 1]) % MOD + dp[i - 3];
            dp[i] = dp[i] % MOD;
        }
        
        return dp[N];
    }
}