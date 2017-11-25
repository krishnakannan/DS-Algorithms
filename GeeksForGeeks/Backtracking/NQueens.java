import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/n-queen-problem/0

public class NQueens {

	List<List<Integer>> arrangements;
	char[][] chessboard;	
	public static void main(String args[]) {
		NQueens nQueens = new NQueens();
		nQueens.arrangements = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();		    
		    nQueens.chessboard = new char[n][n];		  
		    nQueens.placeQueens(n, 0, 0, new ArrayList<>());		    
		    nQueens.printArrangements();
		    nQueens.arrangements = new ArrayList<>();
 		}
 		
	}

	public boolean placeQueens(int n, int row, int col, List<Integer> currentArrangement) {		
		//END CONDITON FOR RECURSION		
		if (col == n - 1) {
			for (int i = 0; i < n; i++) {				
				chessboard[i][col] = 'Q';
				currentArrangement.add(i + 1);				
				if (isSafe(n, i, col)) {					
					arrangements.add(new ArrayList<>(currentArrangement));					
					currentArrangement.remove(currentArrangement.size() - 1);
					return true;
				} else {
					chessboard[i][col] = ' ';
					currentArrangement.remove(currentArrangement.size() - 1);
				}
			}
			return false;
		}		
		for (int i = 0; i < n; i++) {			
			chessboard[i][col] = 'Q';
			currentArrangement.add(i + 1);			
			if (isSafe(n, i, col)) {
				boolean canPlaceQueen = placeQueens(n, 0, col + 1, currentArrangement);				
				if (!canPlaceQueen) {
					chessboard[i][col] = ' ';
					currentArrangement.remove(currentArrangement.size() - 1);					
					continue;
				} else {	
					if (col == 0) {
						chessboard[i][col] = ' ';
						currentArrangement = new ArrayList<>();
						continue;
					} else {
						chessboard[i][col] = ' ';
						currentArrangement.remove(currentArrangement.size() - 1);
						continue;
						//return true;
					}					
				}
			} else {
				chessboard[i][col] = ' ';
				currentArrangement.remove(currentArrangement.size() - 1);				
			}
		}

		return false;

	}

	public boolean isSafe(int n, int x, int y) {
	
	//Print the state of Chessboard at each point
	
	//	 for (int i = 0; i < chessboard.length; i++) {
 	// 		for (int j = 0; j < chessboard[0].length; j++) {
 	// 			System.out.print(chessboard[i][j] + " , ");
 	// 		}
 	// 		System.out.println();
 	// 	}
 	// 	System.out.println(); 			 		


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

	public void printArrangements() {
		if (arrangements.isEmpty()) {
			System.out.println("-1");
		} else {
			for (List<Integer> arrangement : arrangements) {
		    	System.out.print("[");
		    	for (Integer val : arrangement) {
		    		System.out.print(val + " ");
		    	}		    	
		    	System.out.print("] ");
		    }
			System.out.println();
		}		
	}
}