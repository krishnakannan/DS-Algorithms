import java.util.*;
import java.lang.*;
import java.io.*;

class StockMaximizeIV {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StockMaximizeIV sm4 = new StockMaximizeIV();
		int n = in.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = in.nextInt();
		}
        int k = in.nextInt();
		System.out.println(sm4.maxProfit(prices, k));
	}

    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        // IF ALLOWED TRANSACTIONS EXCEED NUMBER OF DAYS - THIS IS EFFECTIVELY A GREEDY PROBLEM ELSE A DP PROBLEM
        if (k > prices.length) {            
            int x = 0;
            int y = 1;
            int profit = 0;
            while (y < prices.length) {
                if (prices[x] < prices[y]) {
                    profit += prices[y] - prices[x];
                }
                x++;
                y++;
            }
            return profit;
        }
        k = k + 1;
        int[][] dp = new int[k][prices.length + 1];
        for (int i = 1; i < dp.length; i++) {
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