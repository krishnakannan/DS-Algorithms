import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/number-is-sparse-or-not/0

class SparseNumber {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		SparseNumber sn = new SparseNumber();
		while (--testcases >= 0) {
		    int n = in.nextInt();		    
		    System.out.println(sn.isSparseNumber(n) ? "1" : "0");
 		}
	}

	public boolean isSparseNumber(int n) {				
		return (n & (n << 1)) == 0 ? true : false;
	}
}