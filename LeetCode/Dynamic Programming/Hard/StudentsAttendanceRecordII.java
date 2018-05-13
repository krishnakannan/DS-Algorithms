class Solution {
    public int checkRecord(int n) {
        if (n == 1) {
            return 3;  
        } else if (n == 2) {
            return 8;
        }
        int mod = 1000000007;
        int[] A = new int [n];
        int[] P = new int [n];
        int[] L = new int [n];
        
        P[0] = 1;
        L[0] = 1;
        L[1] = 3;
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;
        
        for(int i = 1; i < n; i++) {
            A[i - 1] %= mod;
            P[i - 1] %= mod;
            L[i - 1] %= mod;
            
            P[i] = ((A[i - 1] + P[i - 1]) % mod + L[i - 1]) % mod;
            
            if (i > 1) {
                L[i] = ((A[i - 1] + P[i - 1]) % mod + (A[i - 2] + P[i - 2]) % mod) % mod;
            }
            
            if (i > 2) {
                A[i] = ((A[i - 1] + A[i - 2]) % mod + A[i - 3]) % mod;
            }
        }
        
        return ((A[n - 1] % mod + P[n - 1] % mod) % mod + L[n - 1] % mod) % mod;       
    }
}