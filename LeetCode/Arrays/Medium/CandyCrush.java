import java.util.*;
import java.lang.*;
import java.io.*;

class CandyCrush {

	public static void main(String args[]) {
		int[][] board = new int[][] { {110,5,112,113,114 }, {210,211,5,213,214 }, {310,311,3,313,314 }, {410,411,412,5,414 }, {5,1,512,3,3 }, {610,4,1,613,614 }, {710,1,2,713,714 }, {810,1,2,1,1 }, {1,1,2,2,2 }, {4,1,4,4,1014 } };
		CandyCrush cc = new CandyCrush();
		int[][] result = cc.candyCrush(board);
		cc.printMatrix(board);
	}


    public int[][] candyCrush(int[][] board) {

    	boolean marked = true;

    	while (marked) {
    		marked = searchAndMark(board);    	
    		deleteMarkedValues(board);
    		stablizeBoard(board);
    	}

        return board;
    }


    public void stablizeBoard(int[][] board) {

    	//For Every Col push the vals down;
    	for (int c = 0; c < board[0].length; c++) {
    		int bottom = board.length - 1;
    		int top = bottom - 1;    		
    		while (top >= 0) {
    			if (board[bottom][c] == 0) {    				
    				while (top > 0 && board[top][c] == 0) {    				
    					top--;
    				}    				
    				board[bottom][c] = board[top][c];
    				board[top][c] = 0;
    				bottom--;
    				top--;
    			} else {
    				bottom--;
    				top = bottom - 1;
    			}    			
    		}
    	}
    }

    public void deleteMarkedValues(int[][] board) {
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if (board[i][j] < 0) {
    				board[i][j] = 0;
    			}
    		}
    	}
    }


    public boolean searchAndMark(int[][] board) {
    	boolean marked = false;

    	for (int i = board.length - 1; i >= 0; i--) {
    		for (int j = board[0].length - 1; j >= 0; j--) {  
    			boolean markedRow = searchAndMarkRow(board, i, j);   			
    			boolean markedCol = searchAndMarkCol(board, i, j);
    			marked = marked || markedRow || markedCol;
    		}
    	}

    	return marked;
    }

    public boolean searchAndMarkRow(int[][] board, int r, int c) {
    	boolean marked = false;
    	int tempC = c;
    	if (tempC > 0) {
    		int size = 1;
    		while (tempC > 0 && Math.abs(board[r][tempC]) == Math.abs(board[r][tempC - 1]) && board[r][tempC] != 0) {
    			size++;
    			tempC--;
    		}

    		if (size >= 3) {
    			marked = true;
				while (size > 0) {
	    			board[r][c] = board[r][c] < 0 ? board[r][c] : -board[r][c];
	    			c--;
	    			size--;
	    		}    			
    		}
    	}
    	return marked;
    }

    public boolean searchAndMarkCol(int[][] board, int r, int c) {
    	boolean marked = false;
    	int tempR = r;
    	if (tempR > 0) {
    		int size = 1;
    		while (tempR > 0 && Math.abs(board[tempR][c]) == Math.abs(board[tempR - 1][c]) && board[tempR][c] != 0) {
    			size++;
    			tempR--;
    		}

    		if (size >= 3) {
    			marked = true;
				while (size > 0) {
	    			board[r][c] = board[r][c] < 0 ? board[r][c] : -board[r][c];
	    			r--;
	    			size--;
	    		}    			
    		}
    	}
    	return marked;
    }




    public void printMatrix(int[][] matrix) {
    	System.out.println();
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {
    			System.out.print(matrix[i][j] + "\t");
    		}
    		System.out.println();
    	}
    	System.out.println();    	
    }
}