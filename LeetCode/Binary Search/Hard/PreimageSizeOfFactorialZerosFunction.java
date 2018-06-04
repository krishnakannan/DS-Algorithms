import java.util.*;
import java.lang.*;
import java.io.*;

class PreimageSizeOfFactorialZerosFunction {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		PreimageSizeOfFactorialZerosFunction pisofzf = new PreimageSizeOfFactorialZerosFunction();
		System.out.println(pisofzf.preimageSizeFZF(k));
	}

    /*
        Trailing 0s in n! = Count of 5s in prime factors of n!
                          = floor(n/5) + floor(n/25) + floor(n/125) + ....
    */
    
    public int preimageSizeFZF(int k) {
        if (k == 0) {
        	return 5;
        }

        long oneLess = k - 1l;
        long oneMore = k + 1l;        

        long right = binarySearch(0, Long.MAX_VALUE, oneMore, true);
        long left = binarySearch(0, Long.MAX_VALUE, oneLess, false);
        // System.out.println( oneLess + " = " + left);
        // System.out.println( oneMore + " = " + right);
        return (int)(right - left);
    }

    public long binarySearch(long min, long max, long reqdZeros, boolean toFindFirstOf) {
    	//System.out.print("min " + min + " max " + max + "\n");
    	if (min >= max) {
    		return max;
    	}

    	long mid = min + ((max - min) / 2);
    	//System.out.print(" mid " + mid);
    	long zeros = getZeros(mid);
    	//System.out.println("  Zeros " + zeros + " reqdZeros " + reqdZeros);
    	if (zeros > reqdZeros) {
    		return binarySearch(min, mid, reqdZeros, toFindFirstOf);
    	} else if (zeros < reqdZeros) {
    		return binarySearch(mid + 1, max, reqdZeros, toFindFirstOf);
    	} else {
    		if (toFindFirstOf) {
    			return binarySearch(min, mid, reqdZeros, toFindFirstOf);
    		} else {
    			return binarySearch(mid + 1, max, reqdZeros, toFindFirstOf);
    		}
    	}
    }

    public long getZeros(long numerator) {    	
    	long denominator = 5;
    	long zeros = 0;
    	while (numerator / denominator > 0) {
    		zeros += (numerator / denominator);
    		denominator *= 5;
    	}
    	return zeros;
    }
}