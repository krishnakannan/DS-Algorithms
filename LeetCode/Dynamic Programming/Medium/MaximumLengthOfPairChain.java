class Solution {
    public int findLongestChain(int[][] pairs) {
        int max = -1;
        int[] dp = new int[pairs.length];
        //Populate arr with 1s
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        
        Arrays.sort(pairs, new java.util.Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    int temp = dp[j];
                    temp++;
                    dp[i] = temp > dp[i] ? temp : dp[i];
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            //System.out.print(dp[i] + " ");
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}