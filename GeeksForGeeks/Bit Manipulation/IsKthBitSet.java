import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not/0

class IsKthBitSet {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		IsKthBitSet isk = new IsKthBitSet();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int k = in.nextInt();
		    System.out.println(isk.isKthBitSet(n, k) ? "Yes" : "No");
 		}
	}

	public boolean isKthBitSet(int n, int k) {		
		//Set nth bit and create a new number. And it with N. If the number is 0 then the bit is 0
		int nk = 1 << k ;
		return  (nk & n) == 0 ? false : true;
	}
}