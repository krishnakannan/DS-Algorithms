import java.util.*;
import java.lang.*;
import java.io.*;

class StockMaximizeIII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StockMaximizeIII sm3 = new StockMaximizeIII();
		int n = in.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = in.nextInt();
		}
		System.out.println(sm3.maxProfit(prices));
	}

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[3][prices.length + 1];
        for (int i = 1; i < 3; i++) {
        	int pMax = dp[i - 1][0] - prices[0];
        	for (int j = 1; j < dp[0].length; j++) {
        		dp[i][j] = max(dp[i][j - 1], pMax + prices[j - 1]);
        		pMax = max(pMax, dp[i - 1][j] - prices[j - 1]);
        	}
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int max(int a, int b) {
    	return a > b ? a : b;
    }
}