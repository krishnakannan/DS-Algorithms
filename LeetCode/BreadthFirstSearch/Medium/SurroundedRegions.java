class Solution {

    /*
        Three States :

        Two Given - O - Uncaptured, X - Captured

        C - Denotes "CANT CAPTURE" (visited during DFS).

        T - Denotes "TRAVERSED" (visited during DFS).

    */

    Queue<int[]> bfsQ = new LinkedList<>();

    public void solve(char[][] board) {
        
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        
        //Fill Borders - Mark it C "CANT CAPTURE - Temporarily"
        //First Col
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 'O') {
                performBFS(board, i, 0, 'O', 'C');
            }
        }

        // Last Col
        for (int i = 0; i < board.length; i++) {
            if (board[i][board[0].length - 1] == 'O') {
                performBFS(board, i, board[0].length - 1, 'O', 'C');
            }
        }

        //First Row
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                performBFS(board, 0, i, 'O', 'C');
            }
        }

        //Last Row
        for (int i = 0; i < board[0].length; i++) {
            if (board[board.length - 1][i] == 'O') {
                performBFS(board, board.length - 1, i, 'O', 'C');
            }
        }

        

        //Fill Internal

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    performBFS(board, i, j, 'O', 'X');
                }
            }
        }



        //Restore the "CANT CAPTURE" part to Original

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'C') {
                    board[i][j] = 'O';
                }               
            }
        }
    }



    public void performBFS(char[][] board, int r, int c, char existing, char fill) {
        int[] coord = new int[2];
        coord[0] = r;
        coord[1] = c;        
        bfsQ.add(coord);

        while (!bfsQ.isEmpty()) {
            int[] tCoord = bfsQ.poll();
            board[tCoord[0]][tCoord[1]] = fill;
            //Top
            if (tCoord[0] > 0 && board[tCoord[0] - 1][tCoord[1]] == existing) {
                board[tCoord[0] - 1][tCoord[1]]  = fill;
                bfsQ.add(new int[]{tCoord[0] - 1, tCoord[1]});
            }
            //Bottom
            if (tCoord[0] < board.length - 1 && board[tCoord[0] + 1][tCoord[1]] == existing) {
                board[tCoord[0] + 1][tCoord[1]] = fill;
                bfsQ.add(new int[]{tCoord[0] + 1, tCoord[1]});
            }
            //Left
            if (tCoord[1] > 0 && board[tCoord[0]][tCoord[1] - 1] == existing) {
                board[tCoord[0]][tCoord[1] - 1] = fill;
                bfsQ.add(new int[]{tCoord[0], tCoord[1] - 1});
            }
            //Top
            if (tCoord[1] < board[0].length - 1 && board[tCoord[0]][tCoord[1] + 1] == existing) {
                board[tCoord[0]][tCoord[1] + 1] = fill;
                bfsQ.add(new int[]{tCoord[0], tCoord[1] + 1});
            }
        }
    }


}

    