class Solution {
    public int maxA(int N) {
        int[] dp = new int[N + 1];        

        if (N <= 6) {
            return N;
        }
        
        //Base cases
        for (int i = 1; i <= 6; i++) {
        	dp[i] = i;
        }

        for (int i = 7; i <= N; i++) {
        	int searchIndex = i - 3;
        	int mulValue = 2;
        	int maxVal = 0;        	
        	while (maxVal <= (dp[searchIndex] * mulValue)) {
        		maxVal = dp[searchIndex] * mulValue;
				searchIndex--;
				mulValue++;
        	}
        	dp[i] = maxVal;
        }

        return dp[N];
    }
}