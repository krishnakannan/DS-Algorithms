import java.util.*;
import java.lang.*;   
import java.io.*;

class NumberOfDigitOne {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		NumberOfDigitOne ndo = new NumberOfDigitOne();
		System.out.println(ndo.countDigitOne(n));
	}

    public int countDigitOne(int n) {
    	int ones = 0;
        int digits = getDigits(n);
        int pow = (int) Math.pow(10, digits - 1);
        int num = 0;
        while (n > 0) {            
        	num = (n / pow) * pow;
        	ones += getOnes(num, n);        	
        	n %= pow;            
        	digits = getDigits(n);
        	pow = (int) Math.pow(10, digits - 1);
        }
        return ones;
    }

    public long getOnes(int num, int actualNum) {    	
    	if (num > 0 && num < 10) {
    		return 1l;
    	}
    	long n = 10l;
    	long val = 1;
    	while (n * 10 <= num && n < Integer.MAX_VALUE) {    		    		
    		val = (val * 10) + (n);
    		n *= 10;    		
    	}
        val += num == n ? 1 : 0;
    	val = val * (num / n);    	            
    	val += (actualNum - n) > n ? n: (actualNum - n);                
    	return val;
    }

    public int getDigits(int n) {
    	return n == 0 ? 1 : (int) (Math.log10(n) + 1);
    }
}