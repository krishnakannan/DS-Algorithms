import java.util.*;
import java.lang.*;
import java.io.*;

class StockMaximizeWithFee {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		StockMaximizeWithFee smwf = new StockMaximizeWithFee();
		int n = in.nextInt();
		int[] prices = new int[n];
		for (int i = 0; i < prices.length; i++) {
			prices[i] = in.nextInt();
		}
        int fee = in.nextInt();
		System.out.println(smwc.maxProfit(prices, fee));
	}

    public int maxProfit(int[] prices, int fee) {
        int profitAsCash = 0;
        int onHoldAsStock = -prices[0];        
        for (int i = 1; i < prices.length; i++) {
            //Selling
            profitAsCash = Math.max(profitAsCash, (prices[i] + onHoldAsStock) - fee);
            //Purchasing
            onHoldAsStock = Math.max(onHoldAsStock, profitAsCash - prices[i]);            
        }
        return profitAsCash;
    }
}
