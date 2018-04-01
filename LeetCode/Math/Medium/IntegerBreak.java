class Solution {
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }        
        long[] imax = n > 4 ? new long[n + 1] : new long[5];
        imax[2] = 2;        
        imax[3] = 3;
        imax[4] = 4;
        
        for (int i = 5; i <= n; i++) {
            imax[i] = 3 * imax[i - 3];
        }
        
        return (int)imax[n];
    }
}