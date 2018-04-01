class Solution {

	boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board.length == 0 || board[0].length == 0) {
            return false;
        }
        visited = new boolean[board.length][board[0].length];

        char[] wArray = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (board[i][j] == wArray[0]) {
        			boolean isExisting = check(board, wArray, 0, i, j);
        			if (isExisting) {
        				return isExisting;
        			}
        		}
        	}
        }

        return false;
    }

    public boolean check(char[][] board, char[] word, int index, int row, int col) {

    	if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
    		return false;
    	}
        
        //System.out.println("TO SEARCH " + word[index] + " CURRENTLY LOOKING AT " + board[row][col]);
        
    	if (index == word.length - 1) {
    		if (word[index] == board[row][col]) {
    			return true;
    		} else {
    			return false;
    		}
    	}

    	boolean top = false;
    	boolean bottom = false;
    	boolean left = false;
    	boolean right = false;
        boolean hasAlreadyFound = false;
    	if (board[row][col] == word[index]) {
    		visited[row][col] = true;
    		
    		//Search Top
            if (!hasAlreadyFound && row > 0 && !visited[row - 1][col]) {
                top = check(board, word, index + 1, row - 1, col);    
                hasAlreadyFound = top;
            }
    		//Search Bottom
            if (!hasAlreadyFound && row < board.length - 1 && !visited[row + 1][col]) {
                bottom = check(board, word, index + 1, row + 1, col);    
                hasAlreadyFound = hasAlreadyFound || bottom;
            }
    		//Search Left
            if (!hasAlreadyFound && col > 0 && !visited[row][col - 1]) {
                left = check(board, word, index + 1, row, col - 1);    
                hasAlreadyFound = hasAlreadyFound || left;
            }    		
    		//Search Right
            if (!hasAlreadyFound && col < board[0].length - 1 && !visited[row][col + 1]) {
                right = check(board, word, index + 1, row, col + 1);    
                hasAlreadyFound = hasAlreadyFound || right;
            }
    		

    		visited[row][col] = false;
    	}

    	return top || bottom || left || right;
    }
}