import java.util.*;
import java.lang.*;   
import java.io.*;

class PaintHouseII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		PaintHouseII ph2 = new PaintHouseII();
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] costs = new int[n][k];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				costs[i][j] = in.nextInt();
			}
		}
		System.out.println(ph2.minCostII(costs));
	}

	/*
		Not needed to use MinTwoCost Array. We can store it in two variables and rotate the values.
	*/

    public int minCostII(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        if (costs[0].length == 1) {
            if (costs.length == 1) {
                return costs[0][0];
            }
            return Integer.MAX_VALUE;
        }
        int dp[][] = new int[costs.length][costs[0].length];
        int minTwoCost[][][] = new int[costs.length][2][2];
        int minCost = Integer.MAX_VALUE;
        int frCheapest = Integer.MAX_VALUE;
        int frNextCheapest = Integer.MAX_VALUE;
        
        for (int j = 0; j < costs[0].length; j++) {
            if (costs[0][j] <= frCheapest) {
                frNextCheapest = frCheapest;
                minTwoCost[0][1][0] = minTwoCost[0][0][0];
                minTwoCost[0][1][1] = minTwoCost[0][0][1];

                frCheapest = costs[0][j];
                minTwoCost[0][0][0] = 0;
                minTwoCost[0][0][1] = j;

            } else if (costs[0][j] <= frNextCheapest) {
                frNextCheapest = costs[0][j];
                minTwoCost[0][1][0] = 0;
                minTwoCost[0][1][1] = j;
            }
        }
        //System.out.println(dp[minTwoCost[0][0][0]][minTwoCost[0][0][1]] + " " +  dp[minTwoCost[0][1][0]][minTwoCost[0][1][1]]);
        for (int j = 0; j < costs[0].length; j++) {
        	dp[0][j] = costs[0][j];
        }

        for (int i = 1; i < dp.length; i++) {
            int cheapest = Integer.MAX_VALUE;
        	int nextCheapest = Integer.MAX_VALUE;
        	for (int j = 0; j < dp[0].length; j++) {
        		if (minTwoCost[i - 1][0][0] == (i - 1) && minTwoCost[i - 1][0][1] == j) {
        			dp[i][j] = dp[minTwoCost[i - 1][1][0]][minTwoCost[i - 1][1][1]] + costs[i][j];
        		} else {
        			dp[i][j] = dp[minTwoCost[i - 1][0][0]][minTwoCost[i - 1][0][1]] + costs[i][j];
        		}
                
                if (dp[i][j] <= cheapest) {   
        			nextCheapest = cheapest;
                    minTwoCost[i][1][0] = minTwoCost[i][0][0];
                    minTwoCost[i][1][1] = minTwoCost[i][0][1];
                                    
        			cheapest = dp[i][j];
                    minTwoCost[i][0][0] = i;
                    minTwoCost[i][0][1] = j;
                    
        		} else if (dp[i][j] <= nextCheapest) {
                    nextCheapest = dp[i][j];
                    minTwoCost[i][1][0] = i;
                    minTwoCost[i][1][1] = j;
                }
        	}
            //System.out.println(dp[minTwoCost[i][0][0]][minTwoCost[i][0][1]] + " " + dp[minTwoCost[i][1][0]][minTwoCost[i][1][1]]);
        }
        
//         for (int i = 0; i < dp.length; i++) {
//         	for (int j = 0; j < dp[0].length; j++) {
//                 System.out.print(costs[i][j] + "\t");
//         	}
//             System.out.println();
//         }
//         System.out.println();
        
//         for (int i = 0; i < dp.length; i++) {
//         	for (int j = 0; j < dp[0].length; j++) {
//                 System.out.print(dp[i][j] + "\t");
//         	}
//             System.out.println();
//         }
//         System.out.println();

        for (int j = 0; j < dp[0].length; j++) {
        	minCost = minCost > dp[dp.length - 1][j] ? dp[dp.length - 1][j] : minCost;
        }

        return minCost;
    }
}
}