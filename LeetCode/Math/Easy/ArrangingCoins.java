public class Solution {
    public int arrangeCoins(int n) {
        long x = 0l;
        int tot = 0;
        int index = 0;
        while (x < n) {
        	// System.out.println("x  = " + x +  " index = " + index);
        	x += index + 1;
        	index++;
        }
        // System.out.println("x  = " + x +  " index = " + index);
        return x == n ? index : --index;
    }
}