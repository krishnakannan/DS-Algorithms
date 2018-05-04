import java.util.*;
import java.lang.*;   
import java.io.*;

class KthSmallestLexicographicalOrder {
	Scanner in;
	public static void main(String args[]) {
		KthSmallestLexicographicalOrder kslo = new KthSmallestLexicographicalOrder();
		kslo.in = new Scanner(System.in);
		int n = kslo.in.nextInt();
		int k = kslo.in.nextInt();
		
		
		System.out.println(kslo.findKthNumber(n, k));
	}

	public int findKthNumber(int n, int k) {
	    int current = 1;
	    k = k - 1;
	    while (k > 0) {
	        int steps = calculate(n, current, current + 1);
	        if (steps <= k) {
	            curr += 1;
	            k -= steps;
	        } else {
	            curr *= 10;
	            k -= 1;
	        }
	    }
	    return current;
	}
	
	public int calculate(int max, long curr, long next) {
	    int steps = 0;
	    while (curr <= max) {
	        steps += Math.min(max + 1, next) - curr;
	        curr *= 10;
	        next *= 10;
	    }
	    return steps;
	}
}