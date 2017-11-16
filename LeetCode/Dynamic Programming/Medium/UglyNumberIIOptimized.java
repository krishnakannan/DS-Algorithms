class UglyNumberIIOptimized {

	//https://leetcode.com/problems/ugly-number-ii/description/
	

        public int nthUglyNumber(int n) {
        if(n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1]; 
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = min(2 * dp[p2], 3 * dp[p3], 5 * dp[p5]);
            if (dp[i] == 2 * dp[p2]) {
                p2++;
            }
            if (dp[i] == 3 * dp[p3]) {
                p3++;
            }
            if (dp[i] == 5 * dp[p5]) {
                p5++;
            }
        }
        return dp[n];
    }

    public int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
}