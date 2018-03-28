class Solution {
    private static final int mod = 1000000000 + 7;
    public int findDerangement(int n) {
        long prev = 0;
        if (n == 1) {
            return 0;
        }       
        long x = 2;
        long value = 0;
        while (x <= n) {
            value = x * prev;            
            if (x % 2 == 0) {
                value += 1;
            } else {
                value -= 1;
            }
            value %= mod;
            prev = value;
            x++;
        }
        return (int)value;
    }
}