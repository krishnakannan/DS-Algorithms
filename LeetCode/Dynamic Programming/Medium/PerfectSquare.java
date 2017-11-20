class PerfectSquare {
    public int numSquares(int n) {
 		 int[] nums = new int[n + 1];
 		 Integer[] squares = getSquares(n);
 		 int[] dp = new int[n + 1];
 		 for (int i = 0; i <= n; i++) {
 		 	nums[i] = i;
 		 	dp[i] = i;
 		 }

 		 for (int i = 1; i < squares.length; i++) {
 		 	for (int j = 1; j < nums.length; j++) {
 		 		if (nums[j] < squares[i]) {
 		 			continue;
 		 		} else {
 		 			int val = 1 + dp[j - squares[i]];                    
 		 			if (val < dp[j]) {                        
 		 				dp[j] = val;
 		 			}
 		 		}
 		 	}
 		 }
 		 return dp[n];
    }

    public Integer[] getSquares(int n) {
    	List<Integer> list = new ArrayList<>();
    	int i = 1;
    	while ((i * i) <= n) {
    		list.add(i * i);
    		i++;
    	}    	
    	return list.toArray(new Integer[list.size()]);
    }
}