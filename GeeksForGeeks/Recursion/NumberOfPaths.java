import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/number-of-paths/0

class NumberOfPaths {
	public static void main (String[] args) {
		NumberOfPaths np = new NumberOfPaths();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int i = in.nextInt();
		    int j = in.nextInt();		    
			System.out.println(np.count(i,j,0,0));
 		}
	}

	public int count(int iLen, int jLen, int i, int j) {

		if (i == iLen - 1 && j == jLen - 1) {
			return 1;			
		} else if (j == jLen) {
			return 0;
		} else if (i == iLen) {
			return 0;
		}
		
		return count(iLen, jLen, i + 1, j) + count(iLen, jLen, i, j + 1);
	}
}