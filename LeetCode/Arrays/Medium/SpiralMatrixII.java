import java.util.*;
import java.lang.*;
import java.io.*;

class SpiralMatrixII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		SpiralMatrixII sm = new SpiralMatrixII();
		int n = in.nextInt();
		int[][] mat = sm.generateMatrix(n);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");		
			}
			System.out.println();
		}
		
	}

    public int[][] generateMatrix(int n) {
     
    	int[][] matrix = new int[n][n];

    	int rStart = 0;
    	int rEnd = n - 1;
    	int cStart = 0;
    	int cEnd = n - 1;

    	int index = 1;
    	int limit = n * n;

    	int i = 0;
    	int j = 0;

    	while (index <= limit) {

    		i = rStart;
    		j = cStart;

    		while (j <= cEnd) {
    			matrix[i][j] = index;
    			index++;
    			j++;
    		}

    		rStart++;

    		i = rStart;
    		j = cEnd;

    		while (i <= rEnd) {
    			matrix[i][j] = index;
    			index++;
    			i++;
    		}

    		cEnd--;

    		i = rEnd;
    		j = cEnd;

    		while (j >= cStart) {
    			matrix[i][j] = index;
    			j--;
    			index++;
    		}

    		rEnd--;

    		i = rEnd;
    		j = cStart;

    		while (i >= rStart) {
    			matrix[i][j] = index;
    			index++;
    			i--;
    		}

    		cStart++;
    	}

    	return matrix;

    }
}