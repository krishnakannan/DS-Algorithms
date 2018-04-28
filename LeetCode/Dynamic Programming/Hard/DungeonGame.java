import java.util.*;
import java.lang.*;   
import java.io.*;

class DungeonGame {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		DungeonGame dg = new DungeonGame();
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] dungeon = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dungeon[i][j] = in.nextInt();
			}
		}
		System.out.println(dg.calculateMinimumHP(dungeon));
	}

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length == 1 && dungeon[0].length == 1) {
            if (dungeon[0][0] < 0) {
                return -(dungeon[0][0]) + 1;
            }
            return 1;
        }
        
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        
        dp[dp.length - 1][dp[0].length - 1] = Math.max((-dungeon[dp.length - 1][dp[0].length - 1]) + 1, 1);
        
        //Last Col
        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i][dp[0].length - 1] = Math.max(dp[i + 1][dp[0].length - 1] - dungeon[i][dp[0].length - 1], 1);
        }
        //Last Row
        for (int j = dp[0].length - 2; j >= 0; j--) {
            dp[dp.length - 1][j] = Math.max(dp[dp.length - 1][j + 1] - dungeon[dp.length - 1][j], 1);
        }
        
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[0].length - 2; j >= 0; j--) {
                int bottom = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(bottom, right);
            }
        }
        return dp[0][0];
    }
}