import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0

class SimpleStockBuySell {
	public static void main (String[] args) {
		SimpleStockBuySell ssbs = new SimpleStockBuySell();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			ssbs.findDates(arr);
 		}
	}

	public void findDates(int[] prices) {
		int buy = 0;
		int sell = 0;
		int start = prices[0];

		for (int i = 1; i < prices.length; i++) {
			if (prices[i] < prices[i - 1]) {
				if (buy != sell) {
					System.out.print("(" + buy + " " + sell + ")" + " ");
				}
				buy = i;
				sell = i;
			} else {
				sell = i;
			}
		}
		if (buy != sell) {
			System.out.print("(" + buy + " " + sell + ")" + " ");
		}
		if (buy = 0 && sell == prices.length - 1) {
			System.out.print("No Profit");
		}
		System.out.println();
	}
}