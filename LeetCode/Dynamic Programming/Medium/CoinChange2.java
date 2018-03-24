class Solution {
    
    /*
        Given input size, Using 2D DP is extremely expensive. 2.5 million entries matrix is max space needed
    */
    
    public int change(int amount, int[] coins) {
        
        boolean isDP1 = true;
        int[] dp1 = new int[amount + 1];
        int[] dp2 = new int[amount + 1];
        dp1[0] = 1;
        dp2[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (isDP1) {
                    if (i == 0) {
                        dp1[j] = j % coins[i] == 0 ? 1 : 0;
                    } else {
                        dp1[j] = j >= coins[i] ? dp2[j] + dp1[j - coins[i]] : dp2[j];
                    }
                } else {
                    dp2[j] =  j >= coins[i] ? dp1[j] + dp2[j - coins[i]] : dp1[j];  
                }
            }
            isDP1 = !isDP1;
            // if (isDP1) {
            //     for (int x = 0; x < dp2.length; x++) {
            //         System.out.print(dp2[x] + " ");    
            //     }
            //     System.out.println();
            // } else {
            //     for (int x = 0; x < dp1.length; x++) {
            //         System.out.print(dp1[x] + " ");    
            //     }
            //     System.out.println();
            // }
        }
        
        if (isDP1) {
            return dp2[dp2.length - 1]; 
        } else {
            return dp1[dp1.length - 1];
        }
    }
}