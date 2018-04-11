import java.util.*;
import java.lang.*;
import java.io.*;

class StockMaximizeWithCooldown {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StockMaximizeWithCooldown smwc = new StockMaximizeWithCooldown();
		int n = in.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = in.nextInt();
		}
		System.out.println(smwc.maxProfit(prices));
	}

    public int maxProfit(int[] prices) {
	    int sell = 0;
	    int pSell = 0;
	    int buy = Integer.MIN_VALUE;
	    int pBuy;

	    for (int price : prices) {
	        pBuy = buy;
	        buy = Math.max(pSell - price, pBuy);
	        pSell = sell;
	        sell = Math.max(pBuy + price, pSell);
	    }
	    return sell;
	}
}