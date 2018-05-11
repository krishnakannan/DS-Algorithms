import java.util.*;
import java.lang.*;   
import java.io.*;

class NearestPalindrome {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String n = in.next();
		NearestPalindrome np = new NearestPalindrome();
		System.out.println(np.nearestPalindromic(n));
	}

	public String nearestPalindromic(String n) {
    
        int length = n.length();
        int i = length % 2 == 0 ? length / 2 - 1 : length / 2;
        long left = getLong(n.substring(0, i + 1));
        
        
        Set<Long> candidates = new HashSet<>();
        candidates.add(getPalindrome(left, length % 2 == 0)); 
        candidates.add(getPalindrome(left + 1, length % 2 == 0));
        candidates.add(getPalindrome(left - 1, length % 2 == 0));
        candidates.add((long)Math.pow(10, length - 1) - 1);
        candidates.add((long)Math.pow(10, length) + 1);
        
        long diff = Long.MAX_VALUE;
        long output = 0;
        long longN = getLong(n);
        
        for (long candidate : candidates) {
            if (candidate == longN) {
                 continue;   
            }
            if (diff(candidate, longN) < diff) {
                diff = diff(candidate, longN);
                output = candidate;
            } else if (diff(candidate, longN) == diff) {
                output = min(output, candidate);
            }
        }
        
        return Long.toString(output);

    }
    
    public long min(long a, long b) {
        return a < b ? a : b; 
    }

    public long diff(long a, long b) {
    	return a > b ? a - b : b - a;
    }

    public long getLong(String s) {
    	char[] c = s.toCharArray();
    	long val = 0;
    	for (int i = 0; i < c.length; i++) {
    		val *= 10;
    		val += c[i] - '0';
    	}
    	return val;
    }

     public long getPalindrome(long left, boolean isEven) {
        long value = left;
        if (!isEven) {
            left /= 10;  
        } 
        while (left > 0) {
            value = value * 10 + left % 10;
            left /= 10;
        }
        return value;
    }
}