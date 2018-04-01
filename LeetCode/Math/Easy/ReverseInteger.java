public class Solution {
    public int reverse(int x) {
        long y = (long) x;
        long temp = rev(y);
        if (temp < Integer.MIN_VALUE || temp > Integer.MAX_VALUE) {
                return 0;
        } else {
            return (int) temp;
        }
    }
    
    public long rev (long y) {
        long temp = 0;
        while (y != 0) {
                temp = (temp * 10) + (y % 10);
                y = y/10;
            }
        return temp;
    }
}