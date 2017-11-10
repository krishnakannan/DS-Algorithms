import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/rotate-bits/0

class BitRotation {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		BitRotation br = new BitRotation();
		while (--testcases >= 0) {
		    int n = in.nextInt();		    
		    int k = in.nextInt();		    
		    br.rotateBits(n, k);
 		}
	}

	public void rotateBits(int n, int k) {	
		int lRot = (n << k) | (n >> (16 - k));
		int rRot = (n >> k) | (n << (16 - k));
		System.out.println(lRot);
		System.out.println(rRot);	
	}
}