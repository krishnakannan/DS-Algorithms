import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/largest-number-possible/0

class LargestNumberPossible {
	public static void main (String[] args) {
		LargestNumberPossible lp = new LargestNumberPossible();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    int digits = in.nextInt();
		    int sum = in.nextInt();
		    System.out.println(lp.getLargestNumber(digits, sum));
 		}
	}

	public String getLargestNumber(int digits, int sum) {
		if (sum == 0 || digits == 0) { 
			return Integer.toString(-1);
		}
		StringBuilder lSum = new StringBuilder();
		if (Math.ceil((double)sum / (double)digits) >= 10d) {
			return Integer.toString(-1);
		} else {
			while (--digits >= 0) {
				if (sum >= 9) {
					lSum.append(9);				
					sum -= 9;
				} else {
					lSum.append(sum);
					sum = 0;
				}
				
			}
		}
		return lSum.toString();
	}
}