class Solution {
    public void gameOfLife(int[][] board) {
        int bRows = board.length;
        int bCols = board[0].length;
        if (bRows == 1 && bCols == 1) {
            board[bRows - 1][bCols - 1] = 0;
            return;
        }
        for (int i = 0; i < bRows; i++) {
            for (int j = 0; j < bCols; j++) {
                int ones = 0;
                if (i == 0 && j == 0) {                    
                    if (bRows > 1 && bCols > 1) {
                        ones += getNewVal(board, i + 1, j);
                        ones += getNewVal(board, i + 1, j + 1);
                        ones += getNewVal(board, i, j + 1);
                    }
                    board[i][j] = isDoA(board[i][j], ones);    
                } else if (i == 0 && j != 0 && j != bCols - 1) {
                    ones += getNewVal(board, i, j + 1);                    
                    ones += getNewVal(board, i, j - 1);
                    if (bRows > 1) {
                        ones += getNewVal(board, i + 1, j);
                        ones += getNewVal(board, i + 1, j + 1);
                        ones += getNewVal(board, i + 1, j - 1);    
                    }
                    board[i][j] = isDoA(board[i][j], ones);
                } else if (i == 0 && j == bCols - 1) {                    
                    ones += getNewVal(board, i, j - 1);
                    if (bRows > 1) {
                        ones += getNewVal(board, i + 1, j - 1);
                        ones += getNewVal(board, i + 1, j);    
                    }
                    board[i][j] = isDoA(board[i][j], ones);
                } else if (i != 0 && i != bRows - 1 && j == 0) {
                    ones += getNewVal(board, i - 1, j);                    
                    ones += getNewVal(board, i + 1, j);
                    if (bCols > 1){
                        ones += getNewVal(board, i - 1, j + 1);
                        ones += getNewVal(board, i, j + 1);
                        ones += getNewVal(board, i + 1, j + 1);
                    }
                    board[i][j] = isDoA(board[i][j], ones);
                } else if (i == bRows - 1 && j == 0) {
                    ones += getNewVal(board, i - 1, j);
                    if (bCols > 1) {
                        ones += getNewVal(board, i - 1, j + 1);
                        ones += getNewVal(board, i, j + 1);    
                    }
                    board[i][j] = isDoA(board[i][j], ones);
                } else if (i == bRows - 1 && j != 0 && j != bCols - 1) {
                    ones += getNewVal(board, i - 1, j - 1);
                    ones += getNewVal(board, i - 1, j);
                    ones += getNewVal(board, i - 1, j + 1);
                    ones += getNewVal(board, i, j + 1);
                    ones += getNewVal(board, i, j - 1);
                    board[i][j] = isDoA(board[i][j], ones);
                } else if (i != 0 && i != bRows - 1 && j == bCols - 1) {
                    ones += getNewVal(board, i - 1, j - 1);
                    ones += getNewVal(board, i - 1, j);
                    ones += getNewVal(board, i + 1, j - 1);
                    ones += getNewVal(board, i + 1, j);
                    ones += getNewVal(board, i, j - 1);
                    board[i][j] = isDoA(board[i][j], ones);
                } else if (i == bRows - 1 && j == bCols - 1) {
                    ones += getNewVal(board, i - 1, j - 1);
                    ones += getNewVal(board, i - 1, j);
                    ones += getNewVal(board, i, j - 1);
                    board[i][j] = isDoA(board[i][j], ones);
                } else {
                    ones += getNewVal(board, i - 1, j - 1);
                    ones += getNewVal(board, i - 1, j);
                    ones += getNewVal(board, i - 1, j + 1);
                    ones += getNewVal(board, i, j + 1);
                    ones += getNewVal(board, i, j - 1);
                    ones += getNewVal(board, i + 1, j - 1);
                    ones += getNewVal(board, i + 1, j);
                    ones += getNewVal(board, i + 1, j + 1);
                    board[i][j] = isDoA(board[i][j], ones);
                }
            }
        }   
        
        for (int i = 0; i < bRows; i++) {
                for (int j = 0; j < bCols; j++) {
                    if (board[i][j] == 2) {
                        board[i][j] = 0;
                    } else if (board[i][j] == 3) {
                        board[i][j] = 1;
                    }
                }
            }
    }
    
    public int isDoA(int val, int ones) {
        int retval = -1;
        if (val == 1) {
            if (ones < 2) {
                retval = 2;
            } else if (ones > 3) {
                retval = 2;
            } else {
                retval = val;
            }
        } else if (val == 0) {
            if (ones == 3) {
                retval = 3;
            } else {
                retval = val;
            }
        }
        return retval;
    }
    
    public int getNewVal(int board[][], int i, int j) {
        
        if (board[i][j] == 1 || board[i][j] == 2) {
            return 1;
        } else {
            return 0;
        }
    }
}