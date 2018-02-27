import java.util.*;
import java.lang.*;
import java.io.*;

class DiagonalTraverse {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		DiagonalTraverse dt = new DiagonalTraverse();
		int rows = in.nextInt();
		int cols = in.nextInt();
		int[][] matrix = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		int[] returnVal = dt.findDiagonalOrder(matrix);
		for (int i = 0; i < returnVal.length; i++) {
			System.out.print(returnVal[i] + " ");
		}		
	}

    public int[] findDiagonalOrder(int[][] matrix) {
    	if (matrix.length == 0) {
            int[] arr = new int[0];    
            return arr;
        }
        
        if (matrix[0].length == 0) {
            int[] arr = new int[0];
            return arr;
        }
        int length = matrix.length * matrix[0].length;
        int[] dtArray = new int[length];
        int dtIndex = 0;

        int row = 0;
        int col = 0;

        boolean goingDown = false;

        for (int i = 0; i < length;) {
        	int tempR = row;
        	int tempC = col;
        	while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {        		
        		if (goingDown) {
        			dtArray[i] = matrix[row][col];
        			row++;
        			col--;        			
        		} else {
        			dtArray[i] = matrix[row][col];
        			col++;
        			row--;
        		}        		        		
        		i++;

        		if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {
        			if (row < 0) {
        				row++;
        				if (col > 0) {
        					col--;	
        				}
        				
        			}

        			if (row >= matrix.length) {
        				row--;
        				if (col < matrix[0].length) {
        					col++;	
        				}        				
        			}

        			if (col < 0) {        				
        				col++;
        				if (row > 0) {
        					row--;	
        				}        				
        			}

        			if (col >= matrix[0].length) {
        				col--;
        				if (row < matrix.length) {
        					row++;	
        				}        				
        			}   
        			break;
        		}
        	}   


        	if (goingDown) {
        		if (row + 1 < matrix.length) {
        			row += 1;
        		} else {
        			col += 1;
        		}
        	} else {
        		if (col + 1 < matrix[0].length) {
        			col += 1;        			
        		} else {
        			row += 1;
        		}
        	}

        	goingDown = !goingDown;
        }

        return dtArray;
    }
}