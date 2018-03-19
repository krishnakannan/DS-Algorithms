import java.util.*;
import java.lang.*;
import java.io.*;

class DeleteOperationForString {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		DeleteOperationForString dos = new DeleteOperationForString();
		String w1 = in.next();
		String w2 = in.next();
		System.out.println(dos.minDistance(w1, w2));
	}

    public int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        int[][] dp = new int[w1.length + 1][w2.length + 1];

        // Fill first row
        for (int j = 0; j < dp[0].length; j++) {
        	dp[0][j] = j;
        }

        //Fill first col
        for (int i = 0; i < dp.length; i++) {
        	dp[i][0] = i;
        }

        for (int i = 1; i < dp.length; i++) {
        	for (int j = 1; j < dp[0].length; j++) {
        		if (w1[i - 1] == w2[j - 1]) {
        			dp[i][j] = dp[i - 1][j - 1];
        		} else {
        			dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1;
        		}
        	}
        }

        // for (int i = 0; i < dp.length; i++) {
        // 	for (int j = 0; j < dp[0].length; j++) {
        // 		System.out.print(dp[i][j] + " ");
        // 	}
        // 	System.out.println();
        // }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public int min(int a, int b) {
    	return a > b ? b : a;
    }
}