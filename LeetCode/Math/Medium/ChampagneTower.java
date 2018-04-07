import java.util.*;
import java.lang.*;
import java.io.*;

class ChampagneTower {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int poured = in.nextInt();
		int query_row = in.nextInt();
		int query_glass = in.nextInt();
		ChampagneTower ct = new ChampagneTower();
		System.out.println(ct.champagneTower(poured, query_row, query_glass));
		System.out.println();
		for (int i = 1; i <= query_row + 1; i++) {
			for (int j = 1; j <= i ; j++ ) {
				System.out.print(ct.tower[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	double[][] tower = new double[101][101];
    public double champagneTower(int poured, int row, int glass) {
    	if (row == 0) {
    		if (poured > 1) {
    			return 1d;
    		} else {
    			return poured;
    		}
    	}

 		
 		int currentRow = 1;
 		while (currentRow <= row + 1) {
 			int currentCol = 1;
 			if (currentRow == 1) {
 				tower[currentRow][currentCol] = poured; 				
 				currentRow++;
 				continue;
 			}
 			double filled = 0;
 			while (currentCol <= currentRow) {
 				if (currentCol == 1) { 					
 					tower[currentRow][currentCol] = tower[currentRow - 1][currentCol] > 1 ? (tower[currentRow - 1][currentCol] - 1) / 2 : 0;
 				} else if (currentCol == currentRow) {
					tower[currentRow][currentCol] = tower[currentRow - 1][currentCol - 1] > 1 ? (tower[currentRow - 1][currentCol - 1] - 1) / 2 : 0;
 				} else {
 					double currentVal = 0;
 					currentVal += tower[currentRow - 1][currentCol] > 1 ? (tower[currentRow - 1][currentCol] - 1) / 2 : 0;
 					currentVal += tower[currentRow - 1][currentCol - 1] > 1 ? (tower[currentRow - 1][currentCol - 1] - 1) / 2 : 0;
 					tower[currentRow][currentCol] = currentVal;
 				}
 				currentCol++;
 			}
 			if (currentRow == row + 1) {
				if (tower[currentRow][glass + 1] > 1) {
					return 1d;
				} else {
					return tower[currentRow][glass + 1];
				}
			}
			currentRow++;			
 		} 		
 		return 0d;
    }
}