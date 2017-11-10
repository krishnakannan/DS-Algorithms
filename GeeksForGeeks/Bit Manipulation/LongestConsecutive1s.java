import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/longest-consecutive-1s/0

class LongestConsecutive1s {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LongestConsecutive1s lc1 = new LongestConsecutive1s();
		while (--testcases >= 0) {
		    int n = in.nextInt();		    
		    System.out.println(lc1.longestConsecutiveOnes(n));
 		}
	}

	public int longestConsecutiveOnes(int n) {				
		int count = 0;
		while (n > 0) {
			count++;
			n = n & n << 1;
		}
		return count;
	}
}