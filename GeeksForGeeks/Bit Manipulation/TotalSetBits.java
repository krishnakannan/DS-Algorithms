import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/count-total-set-bits/0

class TotalSetBits {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		TotalSetBits tsb = new TotalSetBits();
		while (--testcases >= 0) {
		    int n = in.nextInt();		    
		    System.out.println(tsb.totalSetBits(n));
 		}
	}

	public int totalSetBits(int n) {				
		int count = 0;
		for (int x = n; x > 0; x--) {
			int y = x;
			while (y > 0) {
				y = y & (y - 1);
				count++;
			}
		}			
		return count;
	}
}