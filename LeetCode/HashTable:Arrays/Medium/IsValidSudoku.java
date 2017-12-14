class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == '.') {
        			continue;
        		} else {
        			if (isValidPlacement(board, i, j)) {
        				continue;
        			} else {
        				return false;
        			}
        		}
        	}
        }
        return true;
    }

    public boolean isValidPlacement(char[][] grid, int row, int col) {
        
        boolean isSafe = true;        
        char placedNumber = grid[row][col];

        //Check current row
        for (int i = 0; i < grid[0].length; i++) {
            if (i == col) {
                continue;
            }
            if (grid[row][i] == placedNumber) {                
                return !isSafe;
            }
        }

        //Check current col
        for (int i = 0; i < grid.length; i++) {
            if (i == row) {
                continue;
            }
            if (grid[i][col] == placedNumber) {                
                return !isSafe;
            }
        }

        //Check local grid
        int startLocalGridRow = row - (row % 3);
        int startLocalGridCol = col - (col % 3);

        for (int i = startLocalGridRow; i < startLocalGridRow + 3; i++) {
            for (int j = startLocalGridCol; j < startLocalGridCol + 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (grid[i][j] == placedNumber) {                    
                    return !isSafe;
                }
            }
        }
        return isSafe;
    }
}