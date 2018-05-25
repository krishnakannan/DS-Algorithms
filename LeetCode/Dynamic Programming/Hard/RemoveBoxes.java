class Solution {
    
    /*  First wrongly implemented using 2d dp. Referred official soln.
    */
    
    int[][][] dp;
    
    public int removeBoxes(int[] boxes) {
        dp = new int[boxes.length][boxes.length][boxes.length + 1];
        return getCount(boxes, 0, boxes.length - 1, 0);   
    }
    
    public int getCount(int[] boxes, int left, int right, int k) {
        //System.out.println("Left " + left + " Right " + right + " K " + k);
        if (k >= boxes.length) {
            return 0;
        }
        if (left > right) {
            return 0;
        }        
        if (dp[left][right][k] != 0) {
            return dp[left][right][k];
        }
        
        while (right > left && boxes[right] == boxes[right - 1]) {
            k += 1;
            right -= 1;
        }
        
        dp[left][right][k] = getCount(boxes, left, right - 1, 0) + ((k + 1) * (k + 1));
        
        for (int i = left; i < right; i++) {
            if (boxes[i] == boxes[right]) {
                int val = getCount(boxes, i + 1, right - 1, 0) + getCount(boxes, left, i, k + 1);
                dp[left][right][k] = val > dp[left][right][k] ? val : dp[left][right][k];
            }
        }
        
        return dp[left][right][k];
    }
}