public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
		int minSoFar = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			minSoFar = minSoFar > prices[i] ? prices[i] : minSoFar;
			max = max < (prices[i] - minSoFar) ? (prices[i] - minSoFar) : max;
		}
		return max; 
    }
}