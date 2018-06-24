class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        //To find the minimum most.
        
        for (int[] operation : ops) {
            m = Math.min(m, operation[0]);
            n = Math.min(n, operation[1]);
        }
        return m * n;
    }
}