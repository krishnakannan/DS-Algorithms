class Solution {
    public int countPrimeSetBits(int L, int R) {
        int primeCount = 0;
        for (int i = L; i <= R; i++) {            
            int setBits = getSetBits(i);                        
            if (isPrime(setBits)) {
                primeCount += 1;
            }
        }
        return primeCount;
    }
    
    public int getSetBits(int num) {
        int count = 0;
        for (int i = 0; i < 32; i++) {                        
            if ((num & 1) == 1) {
                count += 1;
            }
            num = num >> 1;
        }
        
        return count;
    }
    
    public boolean isPrime(int num) {                
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        int sqrt = (int)Math.sqrt(num);
        for (int i = 2; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }        
        return true;
    }
}