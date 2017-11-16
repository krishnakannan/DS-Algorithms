//https://leetcode.com/problems/coin-change/

class CoinChange {

     public int coinChange(int[] coins, int amount) {
    	int dp[] = new int[amount + 1];
    	dp[0] = 0;
    	for (int i = 1; i < dp.length; i++) {    		    			
    			dp[i] = Integer.MAX_VALUE;    		
    	}
    	for (int i = 0; i < coins.length; i++) {
    		for (int j = 1; j < dp.length; j++) {
    			int val = j - coins[i] >= 0 ? dp[j - coins[i]] : Integer.MAX_VALUE;
    			int totCoins = 1 + val;
    			if (totCoins != Integer.MIN_VALUE) {
    				dp[j] = dp[j] > totCoins ? totCoins : dp[j];
    			}    			
    		}
    	}
        
//     	for(int j = 0; j < dp.length; j++) {
//             System.out.print(dp[j] + " ");
//     	}
        
        
    	return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}