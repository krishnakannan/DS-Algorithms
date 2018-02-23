import java.util.*;
import java.lang.*;
import java.io.*;

/*
    Not exactly Binary Search. But in this algorithm 
    The divisor is doubled each time.
    The complexity is O(Log n) ^ 2;
*/

class Divide {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int dividend = in.nextInt();
        int divisor = in.nextInt();
        Divide d = new Divide();
        System.out.println(d.divide(dividend, divisor));
    }

    long cDivisor = 0l;
    
    public int divide(int dividend, int divisor) {
        
        long lDividend = dividend;
        long lDivisor = divisor;
        if (Math.abs(lDividend) < Math.abs(lDivisor)) {
            return 0;
        }
        
        long quotient = 0l;            
        
        while (Math.abs(lDividend) >= Math.abs(lDivisor) && lDividend >= Integer.MIN_VALUE && lDividend <= Integer.MAX_VALUE) {
            long tempQuotient = getQuotient(lDividend, lDivisor, divisor, dividend); 
            quotient += tempQuotient;
            //System.out.println("FULL QUOTIENT " + quotient);
            if (Math.abs(lDividend) <= Math.abs(lDivisor)) {
                break;
            }
            lDividend = quotient < 0 ? lDividend + cDivisor : lDividend - cDivisor;
            
        }
  
        return (int)quotient;
        
    }
    
    public long getQuotient(long lDividend, long lDivisor, int divisor, int dividend) {
        long quotient = divisor < 0 && dividend < 0 ? 1l : (divisor < 0 && dividend >= 0) || (dividend < 0 && divisor >= 0) ? -1l : 1l ;
        while (Math.abs(lDivisor) < Math.abs(lDividend)) {            
            //System.out.println("Divisor " + lDivisor + " Dividend " + lDividend + " Quotient " + quotient);
            lDivisor = lDivisor << 1;
            quotient = quotient << 1;            
            
        }  
        
        if (Math.abs(lDivisor) == Math.abs(lDividend)) {
            cDivisor = lDivisor;
            return quotient > Integer.MAX_VALUE ? Integer.MAX_VALUE : quotient;
        } else {
            quotient = quotient >> 1; 
            lDivisor = lDivisor >> 1;
        }
        cDivisor = lDivisor;
        return quotient;
    }
}