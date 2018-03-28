class Solution {    

     public int smallestFactorization(int a) {
        if (a < 2)
            return a;
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int)res : 0;
    }
}


/*

	This is backtracking brute-force "Accepted" slower solution

class Solution {    
    
    long minValue = Long.MAX_VALUE;
    public int smallestFactorization(int a) { 		
        long val = factorize(a, 0l);
        return minValue == Long.MAX_VALUE ? 0 : (int)minValue;
    }
    
    
    public long factorize(long num, long formedNumber) {        
        if (formedNumber >= Integer.MAX_VALUE) {
            return 0;
        }
        if (num < 10) {
            long nextNum = formedNumber;
            nextNum *= 10;
            nextNum += num;   
            if (nextNum < Integer.MAX_VALUE) {
                minValue = minValue > nextNum ? nextNum : minValue;    
            }            
            return nextNum;
        }
        
        long nextNum = Long.MAX_VALUE;
        for (int i = 2; i <= 9; i++) {
            if (num % i == 0) {
                formedNumber *= 10;
                formedNumber += i;                
                num /= i;
                long tempNum = factorize(num, formedNumber);
                num *= i;
                formedNumber -= i;
                formedNumber /= 10;
                nextNum = nextNum > tempNum ? tempNum : nextNum;
            }
        }           
        return nextNum;        
    }
}

*/

