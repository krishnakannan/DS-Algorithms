import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/-minimum-number-of-coins/0

class MinimumNoOfCoins {
	public static void main (String[] args) {
		MinimumNoOfCoins mn = new MinimumNoOfCoins();
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 500, 1000} ;
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    List<Integer> change = mn.getCoins(n, coins);
		    for (Integer coin : change) {
		    	System.out.print(coin + " ");	
		    }
			System.out.println();
 		}
	}

	public List<Integer> getCoins(int amount, int[] coins) {
		List<Integer> change = new ArrayList<>();

		int amountRemaining = amount;
		int coinIndex = coins.length - 1;
		while (amountRemaining > 0) {
			if (coins[coinIndex] > amountRemaining) {
				coinIndex--;
			} else {
				amountRemaining = amountRemaining - coins[coinIndex];
				change.add(coins[coinIndex]);	
			}			
		}	

		return change;
	}
}