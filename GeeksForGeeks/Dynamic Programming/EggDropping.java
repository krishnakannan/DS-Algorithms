import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0

class EggDropping {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		EggDropping ed = new EggDropping();
		while (--testcases >= 0) {
		    int egg = in.nextInt();
		    int floor = in.nextInt();
			System.out.println(ed.attempts(egg, floor));
 		}
	}

	public int attempts(int eggs, int floors) {
		int[][] dp = new int[eggs][floors];

		for (int i = 0; i < floors; i++) {
			dp[0][i] = i + 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i >= j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					int min = Integer.MAX_VALUE;					
					for (int k = 1; k <= j; k++) {
						if (k == 1) {
							min = min > dp[i  - 1][j - k - 1] ? dp[i][j - k - 1] : min;
						} else if (k == j) {
							min = min > dp[i][k - 1] ? dp[i][k - 1] : min;

						} else {
							int max = max(dp[i - 1][k - 1], dp[i][j - k - 1]);
							min = min > max ? max : min;
						}
					}
					dp[i][j] = 1 + min;
				}
			}
		}

		// for (int i = 0; i < dp.length; i++) {
		// 	for (int j = 0; j < dp[0].length; j++) {
		// 			System.out.print(dp[i][j] + " ");
		// 		}
		// 	System.out.println();
		// }
		

		return dp[eggs - 1][floors - 1];
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}
}