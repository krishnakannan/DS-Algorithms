import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/toggle-bits-given-range/0

class ToggleBits {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		ToggleBits tb = new ToggleBits();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int from = in.nextInt();
		    int to = in.nextInt();
		    System.out.println(tb.toggleBits(n, from, to));
 		}
	}

	public int toggleBits(int n, int from, int to) {		
		/*
			Usually for Toggling we use XOR. 
		*/
		for (int i = from; i <= to; i++) {
			//Bit is indexed from 1 so we subtract 1;
			int x = 1 << i - 1;
			n = n ^ x;
		}
		return n;
	}
}