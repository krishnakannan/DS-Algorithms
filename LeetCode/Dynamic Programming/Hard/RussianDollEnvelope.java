import java.util.*;
import java.lang.*;
import java.io.*;

class RussianDollEnvelope {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[][] envelopes = new int[num][2];
		for (int i = 0; i < envelopes.length; i++) {
			envelopes[i][0] = in.nextInt();
			envelopes[i][1] = in.nextInt();
		}
		RussianDollEnvelope rde = new RussianDollEnvelope();
		System.out.println(rde.maxEnvelopes(envelopes));
	}


	class Solution {
    int[] dp;
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0 || envelopes[0].length == 0) {
            return 0;
        }
        dp = new int[envelopes.length];
        //printEnvelopes(envelopes);
        Arrays.sort(envelopes, new Comparator<int[]>(){
        	public int compare(int[] a, int[] b) {
        		if (a[0] == b[0]) {
        			if (a[1] == b[1]) {
        				return 0;
        			}
        			return a[1] - b[1];
        		}
        		return a[0] - b[0];
        	}
        });  
        //printEnvelopes(envelopes);
        Arrays.fill(dp, 1);

        for (int i = 1; i < dp.length; i++) {
        	for (int j = 0; j < i; j++) {
        		if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
        			dp[i] = dp[i] < dp[j] + 1 ? dp[j] + 1 : dp[i];
        		} 
        	}            
        }
        int max = 0;
        // System.out.println(Arrays.toString(dp));
        for (int i = 0; i < dp.length; i++) {
        	max = max < dp[i] ? dp[i] : max;
        }

        return max;
    }
    
    public void printEnvelopes(int[][] envelopes) {
        for (int[] envelope : envelopes) {
            System.out.print("[" + envelope[0] + "," + envelope[1] + "] ");
        }
        System.out.println();
    }
}