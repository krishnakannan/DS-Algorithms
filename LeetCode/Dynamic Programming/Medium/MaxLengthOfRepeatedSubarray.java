//https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

//MaxLengthOfRepeatedSubarray
class MaxLengthOfRepeatedSubarray {
    public int findLength(int[] A, int[] B) {
    	int max = Integer.MIN_VALUE;
        int dp[][] = new int[A.length + 1][B.length + 1];
        for (int i = 1; i < dp.length; i++) {
        	for (int j = 1; j < dp[0].length; j++) {
        		if (A[i - 1] == B[j - 1]) {
        			dp[i][j] = 1 + dp[i - 1][j - 1];
        		}
        	}
        }

        for (int i = 1; i < dp.length; i++) {
        	for (int j = 1; j < dp[0].length; j++) {
        		max = max < dp[i][j] ? dp[i][j] : max;
        	}
        }
        return max;
    }
}