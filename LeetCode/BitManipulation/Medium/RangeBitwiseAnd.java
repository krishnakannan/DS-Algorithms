import java.util.*;
import java.lang.*;
import java.io.*;

class RangeBitwiseAnd {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		RangeBitwiseAnd rba = new RangeBitwiseAnd();
		int m = in.nextInt();
		int n = in.nextInt();
		System.out.println(rba.rangeBitwiseAnd(m, n));
	}

	public int rangeBitwiseAnd(int m, int n) {
        
        if (m == n) {
            return m;
        } else if (n - m == 1) {
            return m & n;
        }
        
        int max = n;
        int bit = 0;
        int finalValue = 0;
        while (bit <= 31 && max >= m) {
        	int val = offNthBit(max, bit);
        	if (inRange(val, m, n)) {
        		bit++;
        	} else {
        		int nextMax = getNextMax(max);
        		if (nextMax < m) {
        			max = max - 1;
        		} else {
        			max = nextMax;
        		}
        	}        	
        	//System.out.println("MAX " + max);
        }
    
        finalValue = m;
    
        while (bit >= 0) {        	
        	bit--;
        	finalValue = offNthBit(finalValue, bit);
        }

        

        return finalValue;

    }

    public int getNextMax(int currentMax) {
    	int nextMax = 1;

    	while (nextMax < currentMax && nextMax <= Integer.MAX_VALUE) {
    		nextMax = nextMax | (nextMax << 1);    		
    	}

    	return (nextMax >> 1);
    }

    public int offNthBit(int val, int bit) {
    	int nthBit = 1 << bit;

    	val = val | nthBit;
    	val = val ^ nthBit;

    	return val;
    }

    public boolean inRange(int val, int m, int n) {
    	return val >= m && val <= n;
    }
}