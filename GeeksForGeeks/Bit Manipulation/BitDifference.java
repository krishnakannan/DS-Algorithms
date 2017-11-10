import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/bit-difference/0

class BitDifference {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		BitDifference bd = new BitDifference();
		while (--testcases >= 0) {
		    int n1 = in.nextInt();		    
		    int n2 = in.nextInt();		    
		    System.out.println(bd.bitdifference(n1, n2));
 		}
	}

	public int bitdifference(int n1, int n2) {				
		int count = 0;
		int x = n1 ^ n2;
		while (x > 0) {
			x = x & (x - 1);
			count++;
		}
		return count;
	}
}