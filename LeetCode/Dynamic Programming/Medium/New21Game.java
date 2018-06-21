//Referred Solution
class Solution {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) {
          return 1d;
        }
        double[] dp = new double[N + 1];
        double sum = 1d;
        double res = 0d;
        dp[0] = 1d;
        for (int i = 1; i <= N; i++) {
            dp[i] = sum / W;
            if (i < K) {
                sum += dp[i];  
            } else {
                res += dp[i];   
            }            
            if (i - W >= 0) {
                sum -= dp[i - W];  
            } 
        }
        return res;   
    }
}