import java.util.*;
import java.lang.*;
import java.io.*;

//https://leetcode.com/problems/n-queens/description/

public class NQueensII {

	int configurationCount;
	char[][] chessboard;	
	public int totalNQueens(int n) {    	
        configurationCount = 0;
        if (n == 0) {
            return 1;
        }
		chessboard = new char[n][n];        
		for (char[] ChessRow : chessboard) {
			Arrays.fill(ChessRow, '.');
		}        
        placeQueens(n, 0, 0);        
		return configurationCount;
    }

	public boolean placeQueens(int n, int row, int col) {		        
		//END CONDITON FOR RECURSION		
		if (col == n - 1) {
			for (int i = 0; i < n; i++) {	                
				chessboard[i][col] = 'Q';				
				if (isSafe(n, i, col)) {								
					configurationCount++;
                    chessboard[i][col] = '.';
					return true;
				} else {
					chessboard[i][col] = '.';				
				}
			}
			return false;
		}	
       
		for (int i = 0; i < n; i++) {	            
			chessboard[i][col] = 'Q';			
			if (isSafe(n, i, col)) {
				boolean canPlaceQueen = placeQueens(n, 0, col + 1);	
			}
			chessboard[i][col] = '.';				
		}
		return false;
	}


	public boolean isSafe(int n, int x, int y) {
	
	//Print the state of Chessboard at each point
	
		 // for (int i = 0; i < chessboard.length; i++) {
		 // for (int j = 0; j < chessboard[0].length; j++) {
		 // System.out.print(chessboard[i][j] + " , ");
		 // }
		 // System.out.println();
		 // }
		 // System.out.println(); 			 		


		//Horizontal. Check for the previous columns from existing column.
		for (int i = y - 1; i >= 0; i--) {
			if (chessboard[x][i] == 'Q') {
				return false;
			}
		}
		//Vertical
		for (int i = x - 1; i >= 0; i--) {
			if (chessboard[i][y] == 'Q') {
				return false;
			}
		}
		//Diagonal - UP
		int a = x - 1;
		int b = y - 1;
		while (a >= 0 && b >= 0){
			if (chessboard[a][b] == 'Q') {
				return false;
			}
			a--;
			b--;
		}
		//Diagonal - DOWN
		a = x + 1;
		b = y - 1;
		while (a >= 0 && b >= 0 && a < n && b < n){
			if (chessboard[a][b] == 'Q') {
				return false;
			}
			a++;
			b--;
		}

		return true;
	}
}