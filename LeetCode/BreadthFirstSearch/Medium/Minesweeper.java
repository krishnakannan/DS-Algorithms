class Solution {
    boolean[][] visited;
    
    public char[][] updateBoard(char[][] board, int[] click) {
     
        visited = new boolean[board.length][board[0].length];
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        
        Queue<int[]> queue  = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] coord = queue.poll();
            if (visited[coord[0]][coord[1]]) {
                continue;
            }
            visited[coord[0]][coord[1]] = true;
            int count = getAdjacentMines(board, coord[0], coord[1]);
            if (count == 0) {
                board[coord[0]][coord[1]] = 'B';
                queue.addAll(getNeighbors(board, coord[0], coord[1]));
            } else {
                board[coord[0]][coord[1]] = (char)(count + '0');
            }
            //print(board);
        }
        
        return board;
        
    }
    
    public List<int[]> getNeighbors(char[][] board, int r, int c) {
        List<int[]> validNeighbors = new ArrayList<>();
        if (r - 1 >= 0 && !visited[r - 1][c]) {
            validNeighbors.add(new int[]{r - 1, c});
        }
        if (r + 1 < board.length && !visited[r + 1][c]) {
            validNeighbors.add(new int[]{r + 1, c});
        }
        if (c - 1 >= 0 && !visited[r][c - 1]) {
            validNeighbors.add(new int[]{r, c - 1});
        }
        if (c + 1 < board[0].length && !visited[r][c + 1]) {
            validNeighbors.add(new int[]{r, c + 1});
        }
        if (r - 1 >= 0 && c - 1 >= 0 && !visited[r - 1][c - 1]) {
            validNeighbors.add(new int[]{r - 1, c - 1});
        }
        if (r - 1 >= 0 && c + 1 < board[0].length && !visited[r - 1][c + 1]) {
            validNeighbors.add(new int[]{r - 1, c + 1});
        }
        if (r + 1 < board.length && c + 1 < board[0].length && !visited[r + 1][c + 1]) {
            validNeighbors.add(new int[]{r + 1, c + 1});
        }
        if (r + 1 < board.length && c - 1 >= 0 && !visited[r + 1][c - 1]) {
            validNeighbors.add(new int[]{r + 1, c - 1});
        }        
        return validNeighbors;
    }
    
    public int getAdjacentMines(char[][] board, int r, int c) {
        int adjacentMines = 0;
        //Top
        if (r > 0 && board[r - 1][c] == 'M') {
            adjacentMines++;
        }
        //Bottom
        if (r < board.length - 1 && board[r + 1][c] == 'M') {
            adjacentMines++;
        }
        //Left
        if (c > 0 && board[r][c - 1] == 'M') {
            adjacentMines++;
        }
        //Right
        if (c < board[0].length - 1 && board[r][c + 1] == 'M') {
            adjacentMines++;
        }
        //TopLeft
        if (r > 0 && c > 0 && board[r - 1][c - 1] == 'M') {
            adjacentMines++;
        }
        //TopRight
        if (r > 0 && c < board[0].length - 1 && board[r - 1][c + 1] == 'M') {
            adjacentMines++;
        }
        //BottomRight
        if (r < board.length - 1 && c < board[0].length - 1 && board[r + 1][c + 1] == 'M') {
            adjacentMines++;
        }
        //BottomLeft
        if (r < board.length - 1 && c > 0 && board[r + 1][c - 1] == 'M') {
            adjacentMines++;
        }
        return adjacentMines;
    }
    
    public void print(char[][] mat) {

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();   
    }        
    
}