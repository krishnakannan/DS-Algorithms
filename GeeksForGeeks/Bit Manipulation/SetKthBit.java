import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/set-kth-bit/0

class SetKthBit {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		SetKthBit sk = new SetKthBit();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int k = in.nextInt();
		    System.out.println(sk.setKthBit(n, k));
 		}
	}

	public int setKthBit(int n, int k) {		
		//Bits indexed from 0
		int x = 1 << k;		
		return n | x;
	}
}