import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/swap-all-odd-and-even-bits/0

class SwapBits {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		SwapBits sb = new SwapBits();
		while (--testcases >= 0) {
		    int n = in.nextInt();		    
		    System.out.println(sb.swapBits(n));
 		}
	}

	public int swapBits(int n) {				
		int n1 = n & 0xAAAAAAAA;
		int n2 = n & 0x55555555;

		return (n1 >> 1) | (n2 << 1);
	}
}