public class Solution {
    public int maxProfit(int[] prices) {
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
}