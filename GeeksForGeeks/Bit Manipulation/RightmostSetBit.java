import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/rightmost-different-bit/0

class RightmostSetBit {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		RightmostSetBit rsb = new RightmostSetBit();
		while (--testcases >= 0) {
		    int m = in.nextInt();
		    int n = in.nextInt();
		    System.out.println(rsb.findRightMostSetBit(m, n));
 		}		 
	}

	public int findRightMostSetBit(int m, int n) {
		int x = m ^ n;

		return x == 0 ? 0 : (int) ((Math.log10(x & -x)) / (Math.log10(2))) + 1;
	}

}