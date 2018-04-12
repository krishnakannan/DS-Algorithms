class TicTacToe {
    
    class GameState {
        int p1Points = 0;
        int p2Points = 0;
        int winner = 0;
    }

    int[][] board;
    GameState state;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int[n][n];
        state = new GameState();
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if (state.winner == 0) {
            board[row][col] = player;
            return checkWinningCondition(row, col, player);
        }
        return state.winner;
    }

    public int checkWinningCondition(int r, int c, int player) {
        
        if (player == 1) {
            state.p1Points++;
        } else {
            state.p2Points++;
        }

        int left = 0;
        for (int i = c - 1; i >= 0 && board[r][i] == player; i--) {
            left++;
        }
        int right = 0;
        for (int i = c + 1; i < board[0].length && board[r][i] == player; i++) {
            right++;
        }

        int top = 0;
        for (int i = r - 1; i >= 0 && board[i][c] == player; i--) {
            top++;
        }
        
        int bottom = 0;
        for (int i = r + 1; i < board.length && board[i][c] == player; i++) {
            bottom++;
        }

        int toTopLeft = 0;
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0 && board[i][j] == player; i--, j--) {
            toTopLeft++;
        }

        int toTopRight = 0;
        for (int i = r - 1, j = c + 1; i >= 0 && j < board[0].length && board[i][j] == player; i--, j++) {
            toTopRight++;
        }

        int toBottomLeft = 0;
        for (int i = r + 1, j = c - 1; i < board.length && j >= 0 && board[i][j] == player; i++, j--) {
            toBottomLeft++;
        }

        int toBottomRight = 0;
        for (int i = r + 1, j = c + 1; i < board.length && j < board[0].length && board[i][j] == player; i++, j++) {
            toBottomRight++;
        }

        if (left + right + 1 == board.length) {
            state.winner = player;
        } else if (top + bottom + 1 == board.length) {
            state.winner = player;
        } else if (toTopLeft + toBottomRight + 1 == board.length) {
            state.winner = player;
        } else if (toTopRight + toBottomLeft + 1 == board.length) {
            state.winner = player;
        }
        return state.winner;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */