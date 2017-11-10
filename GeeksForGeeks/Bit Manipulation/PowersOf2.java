import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/power-of-2/0

class PowersOf2 {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		PowersOf2 po = new PowersOf2();
		while (--testcases >= 0) {
		    long n = in.nextLong();		    
		    System.out.println(po.isPowerOf2(n) ? "YES" : "NO");
 		}
	}

	public boolean isPowerOf2(long n) {		
		if (n == 1) {
			return true;
		}
		
		long digits = (long)(((Math.log10(n) / Math.log10(2)) + 1));								
		long x = n == 0 ? 1 : 1L << digits - 1L;
		return (n ^ x) == 0 ? true : false;
	}
}