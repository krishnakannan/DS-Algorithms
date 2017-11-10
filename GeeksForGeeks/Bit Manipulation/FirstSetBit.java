import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/find-first-set-bit/0

class FirstSetBit {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		FirstSetBit fsb = new FirstSetBit();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    System.out.println(fsb.findRightMostSetBit(n));
 		}
	}

	public int findRightMostSetBit(int n) {
		
		//Using change of base rule. 
		// Log base 2 is not available in java
		// The numerator will always be in powers of 2
		return n == 0 ? 0 : (int) ((Math.log2(n & -n)) / Math.log10(2)) + 1;

	}
}