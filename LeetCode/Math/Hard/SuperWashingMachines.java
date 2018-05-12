class Solution {
    public int findMinMoves(int[] machines) {
        int totalDresses = 0;
        for (int dresses : machines) {
            totalDresses += dresses;
        }
        
        if (totalDresses % machines.length != 0) {
            return -1;
        }
        
        int currentState = 0;
        int maxSwaps = 0;
        
        int reqdDresses = totalDresses / machines.length;
        
        for (int dresses : machines) {
            System.out.println(currentState + " " + maxSwaps);
            currentState += dresses - reqdDresses;
            maxSwaps = max(max(maxSwaps, abs(currentState)), dresses - reqdDresses);
        }
        return maxSwaps;
    }
    
    public int abs(int a) {
        return a < 0 ? -a : a;
    }
    
    public int max(int a, int b) {
        return a > b ? a : b;
    }
}