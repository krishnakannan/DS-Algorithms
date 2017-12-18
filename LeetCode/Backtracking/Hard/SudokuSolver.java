class Solution {

	public void solveSudoku(char[][] board) {
        sudokuSolver(board);
    }

	public boolean sudokuSolver(char[][] grid) {

		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == '.') {
					for (int currentVal = 1; currentVal < 10; currentVal++) {
						if (isValidPlacement(grid, r, c, (char) (currentVal + '0')) {
							grid[r][c] = (char) (currentVal + '0');
							if (sudokuSolver(grid)) {
								return true;
							} else {
								grid[r][c] = '.';
							}
						}
					}
					return false;
				}
			}
		}

		return true;

	}

	public boolean isValidPlacement(char[][] grid, int row, int col, char num) {

		boolean isSafe = true;
		grid[row][col] = num;
		char placedNumber = num;

		//Check current row
		for (int i = 0; i < grid[0].length; i++) {
			if (i == col) {
				continue;
			}
			if (grid[row][i] == placedNumber) {
				grid[row][col] = '.';
				return !isSafe;
			}
		}

		//Check current col
		for (int i = 0; i < grid.length; i++) {
			if (i == row) {
				continue;
			}
			if (grid[i][col] ==  placedNumber) {
				grid[row][col] = '.';
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
					grid[row][col] = '.';
					return !isSafe;
				}
			}
		}
		return isSafe;
	}
}