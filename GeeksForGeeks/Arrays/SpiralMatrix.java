import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix/0

class SpiralMatrix {
	public static void main (String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    //int n = in.nextInt();
		    int[][] matrix = new int[4][4];
		    for (int i = 0; i < 4; i++) {
		    	for (int j = 0; j < 4; j++) {
		    		matrix[i][j] = in.nextInt();		
		    	}		        
		    }		
		    sm.printMatrixSpirally(matrix);
		    System.out.println();
 		}
	}

	public void printMatrixSpirally(int matrix[][]) {	
		int iStart = 0;
		int jStart = 0;
		int iEnd = matrix.length - 1;
		int jEnd = matrix[0].length - 1;
		int x = 0; int y = 0;
		while (iStart <= iEnd && jStart <= jEnd) {
			x = jStart; 			
			while (x <= jEnd) {
				System.out.print(matrix[iStart][x] + " ");
				x++;
			}
			iStart++;
			x = iStart;
			while (x <= iEnd) {
				System.out.print(matrix[x][jEnd] + " ");
				x++;	
			}
			jEnd--;
			x = jEnd;
			while (x >= jStart) {
				System.out.print(matrix[iEnd][x] + " ");
				x--;	
			}
			iEnd--;
			x = iEnd;
			while (x >= iStart) {
				System.out.print(matrix[x][jStart] + " ");
				x--;	
			}
			jStart++;
		}
	}
}