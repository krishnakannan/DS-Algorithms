import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/find-optimum-operation/0

class MinimumOperations {
	public static void main (String[] args) {
		MinimumOperations mo = new MinimumOperations();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    System.out.println(mo.findMinimum(n));
 		}
	}

	public int findMinimum(int n) {
		int count = 0;
		while (n > 0) {			
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n--;
			}
			count++;
		}
		return count;
	}

}