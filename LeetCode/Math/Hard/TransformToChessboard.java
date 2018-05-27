class Solution {
    
    //Based on a hint - Dimensional Reduction
    int[][] reducedBoard;
    int rowsMovement = 0;
    int colsMovement = 0;
    public int movesToChessboard(int[][] board) {
         
         if (reduceCols(board) && reduceRows(board)) {
            return rowsMovement + colsMovement;
         }
        return -1;
    }
    
    public boolean isAltering(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean reduceCols(int[][] board) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            builder.setLength(0);
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    zeros += 1;
                } else if (board[i][j] == 1) {
                    ones += 1;
                } else {
                    return false;
                }
                builder.append(board[i][j]);
            }
            if (diff(ones, zeros) > 1) {
                return false;
            }
            map.put(builder.toString(), i);
            if (map.size() > 2) {
                return false;
            }            
        }
        String col = "";
        if (map.size() == 2) {
            reducedBoard = new int[2][board[0].length];
            int index = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (index == 0) {
                    reducedBoard[0] = Arrays.copyOf(board[entry.getValue()], board[entry.getValue()].length);
                    col = entry.getKey();
                    index += 1;
                } else {
                    reducedBoard[1] = Arrays.copyOf(board[entry.getValue()], board[entry.getValue()].length);
                }
            }        
            for (int j = 0; j < reducedBoard[0].length; j++) {
                if (reducedBoard[0][j] == reducedBoard[1][j]) {                    
                    return false;
                }
            }
            //Referred section to find number of swaps
            int N = board.length;
            int Nones = (1 << N) - 1;
            int k1 = Integer.parseInt(col, 2);
            int ones = Integer.bitCount(k1 & Nones);
            int candidate = Integer.MAX_VALUE;
            if (N % 2 == 0 || ones * 2 < N) // zero start
                candidate = Math.min(candidate, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);

            if (N % 2 == 0 || ones * 2 > N) // ones start
                candidate = Math.min(candidate, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);            
            colsMovement = candidate;
            return true;

        } else {
            return false;
        }
    }

    public boolean reduceRows(int[][] board) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < board[0].length; j++) {
            builder.setLength(0);
            int ones = 0;
            int zeros = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == 0) {
                    zeros += 1;
                } else if (board[i][j] == 1) {
                    ones += 1;
                } else {
                    return false;
                }
                builder.append(board[i][j]);
            }
            if (diff(ones, zeros) > 1) {
                return false;
            }
            map.put(builder.toString(), j);
            if (map.size() > 2) {
                return false;
            }            
        }
        String row = "";
        if (map.size() == 2) {
            reducedBoard = new int[2][board.length];
            int index = 0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                char[] arr = entry.getKey().toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    reducedBoard[index][i] = (int)(arr[i] - '0');
                } 
                if (index == 0) {
                    row = entry.getKey();    
                }                
                index += 1;
            }        
            for (int j = 0; j < reducedBoard[0].length; j++) {
                if (reducedBoard[0][j] == reducedBoard[1][j]) {
                    return false;
                }
            }

            //Referred section to find number of swaps
            int N = board.length;
            int Nones = (1 << N) - 1;
            int k1 = Integer.parseInt(row, 2);            
            int ones = Integer.bitCount(k1 & Nones);
            int candidate = Integer.MAX_VALUE;
            if (N % 2 == 0 || ones * 2 < N) // zero start
                candidate = Math.min(candidate, Integer.bitCount(k1 ^ 0xAAAAAAAA & Nones) / 2);
            if (N % 2 == 0 || ones * 2 > N) // ones start
                candidate = Math.min(candidate, Integer.bitCount(k1 ^ 0x55555555 & Nones) / 2);                        
            rowsMovement = candidate;
            return true;         
        } else {
            return false;
        }
    }
    
    
    public int diff(int a, int b) {
        return a > b ? a - b : b - a;
    }
}