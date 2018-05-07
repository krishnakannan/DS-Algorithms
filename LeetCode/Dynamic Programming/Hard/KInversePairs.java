class Solution {
    private static final int MOD = 1000000007;
    public int kInversePairs(int n, int k) {
 		int[][] dp = new int[n][k + 1];
 		int[][] countCache = new int[n][k + 1];

 		dp[0][0] = 1;
 		countCache[0][0] = 1;

 		//First Row
 		for (int j = 1; j < dp[0].length; j++) {
 			dp[0][j] = 0;
 			countCache[0][j] = 0;
 		}

 		//First Col
		for (int i = 1; i < dp.length; i++) {
 			dp[i][0] = 1;
 			countCache[i][0] = 1;
 		} 		

        if (k >= 1) {
            countCache[0][1] = 1;    
        }
 		

 		int count = 0;
 		long value = 0;
 		int size = 0;        
 		for (int i = 1; i < dp.length; i++) {
 			size = i + 2;
 			count = 0; 			
 			value = dp[i][0];
 			for (int j = 1; j < dp[0].length; j++) {
 				dp[i][j] = countCache[i - 1][j]; 	
 				count += 1;
 				value += dp[i][j];
                //value %= MOD;
 				if (count >= size) {
 					value -= dp[i][j - size];
 				}
                // value %= MOD;
 				countCache[i][j] = (int)(value % MOD);
                
 			}
 		}
        
        // for (int i = 0; i < dp.length; i++) {
        //     for (int j = 0; j < dp[0].length; j++) {
        //         System.out.print(dp[i][j] +"," + countCache[i][j] + "\t");
        //     }
        //     System.out.println();
        // }
        
 		return dp[dp.length - 1][dp[0].length - 1];
    }
}