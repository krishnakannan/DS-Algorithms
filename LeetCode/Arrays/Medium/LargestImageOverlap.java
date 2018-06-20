import java.util.*;
import java.lang.*;
import java.io.*;

class LargestImageOverlap {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] A = new int[n][n];
		int[][] B = new int[n][n];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = in.nextInt();
			}
		}

		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				B[i][j] = in.nextInt();
			}
		}

		LargestImageOverlap lio = new LargestImageOverlap();
		System.out.println(lio.largestOverlap(A, B));
	}

    public int largestOverlap(int[][] A, int[][] B) {
        int largestOverlap = 0;
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < A[0].length; j++) {
        		for (int m = i == 0 ? 0 : i - 1; m < B.length; m++) {
        			for (int n = j == 0 ? 0 : j - 1; n < B[0].length; n++) {
        				int overlap = overlap(A, B, i, j, m, n);
        				largestOverlap = Math.max(largestOverlap, overlap);
        			}
        		}
        	}
        }

        return largestOverlap;
    }

    public int overlap(int[][] A, int[][] B, int ar, int aCol, int br, int bCol) {
    	int ones = 0;
    	for (; ar < A.length && br < B.length; ar++, br++) {
    		for (int bc = bCol,  ac = aCol; ac < A[0].length && bc < B[0].length; ac++, bc++) {
    			if (A[ar][ac] + B[br][bc] == 2) {
    				ones += 1;
    			}
    		}
    	}    	
    	return ones;
    }	
}