class Solution {

	class GameState {
		int xCount = 0;
		int oCount = 0;
		boolean isXWinner = false;
        boolean isOWinner = false;
	}

	private static GameState state;

    public boolean validTicTacToe(String[] boardString) {
    	state = new GameState();
        char[][] board = new char[3][3];
        int index = 0;
        for (String str : boardString) {
        	board[index] = Arrays.copyOf(str.toCharArray(), str.length());
            index++;
        }
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') {
                    int count = 0;
                    int count1 = checkRL(board, i, j, 'X');
                    board[i][j] = 'X';
                    int count2 = checkTD(board, i, j, 'X');
                    board[i][j] = 'X';
                    int count3 = checkDLR(board, i, j, 'X');
                    board[i][j] = 'X';
                    int count4 = checkDRL(board, i, j, 'X');
                    
                    if (count1 == 3 || count2 == 3 || count3 == 3 || count4 == 3) {
                        state.isXWinner = true;
                    }
                    
                    state.xCount += count1 + count2 + count3 + count4 - 3;
                                        
                } else if (board[i][j] == 'O') {
                    int count = 0;
                    int count1 = checkRL(board, i, j, 'O');
                    board[i][j] = 'O';
                    int count2 = checkTD(board, i, j, 'O');
                    board[i][j] = 'O';
                    int count3 = checkDLR(board, i, j, 'O');
                    board[i][j] = 'O';
                    int count4 = checkDRL(board, i, j, 'O');
                    
                    if (count1 == 3 || count2 == 3 || count3 == 3 || count4 == 3) {
                        state.isOWinner = true;
                    }
                    
                    state.oCount += count1 + count2 + count3 + count4 - 3;
                }
        	}
        }
        
        if (state.isXWinner && state.isOWinner) {
            return false;
        } else if (state.isXWinner) {
            if (state.xCount <= state.oCount) {
                return false;
            }
        } else if (state.isOWinner) {
           if (state.oCount < state.xCount) {
                return false;
            }
        }
        if (state.oCount > state.xCount) {
            return false;
        }
        if (state.xCount - 1 > state.oCount) {
            return false;
        }
        
        return true;
    }
    
    //Check Right Left;
    public int checkRL(char[][] board, int r, int c, char searchItem) {        
        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            return 0;
        }        
        if (board[r][c] != searchItem) {
            return 0;
        }                        
        board[r][c] = '-';        
        int count = 1;           
        count += checkRL(board, r, c - 1, searchItem);
        count += checkRL(board, r, c + 1, searchItem);                
        return count;        
    }
    
    //Check Top Down;
    public int checkTD(char[][] board, int r, int c, char searchItem) {        
        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            return 0;
        }        
        if (board[r][c] != searchItem) {
            return 0;
        }                        
        board[r][c] = '-';        
        int count = 1;        
        count += checkTD(board, r - 1, c, searchItem);                        
        count += checkTD(board, r + 1, c, searchItem);        
        return count;        
    }
    
    //Diagonal Left to Right
    public int checkDLR(char[][] board, int r, int c, char searchItem) {        
        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            return 0;
        }        
        if (board[r][c] != searchItem) {
            return 0;
        }                        
        board[r][c] = '-';        
        int count = 1;
        count += checkDLR(board, r - 1, c - 1, searchItem);                
        count += checkDLR(board, r + 1, c + 1, searchItem);
        return count;        
    }
    
    //Diagonal Right to Left
    public int checkDRL(char[][] board, int r, int c, char searchItem) {        
        if (r < 0 || r >= 3 || c < 0 || c >= 3) {
            return 0;
        }        
        if (board[r][c] != searchItem) {
            return 0;
        }                        
        board[r][c] = '-';        
        int count = 1;        
        count += checkDRL(board, r - 1, c + 1, searchItem);        
        count += checkDRL(board, r + 1, c - 1, searchItem);        
        return count;        
    }
    
}