public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;

        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
        		if (i == 0 && j == 0 && board[i][j] == 'X')  {
        			count++;
        			continue;
        		} else if (i == 0 && j > 0 && board[i][j] == 'X') {
        			if (board[i][j - 1] == 'X') {
        				continue;
        			} else {
        				count++;
        			}
        		} else if (i > 0 && j == 0 && board[i][j] == 'X') {
        			if (board[i - 1][j] == 'X') {
        				continue;
        			} else {
        				count++;
        			}
        		} else if (i > 0 && j > 0 && board[i][j] == 'X') {
        			if (board[i - 1][j] == 'X' ||board[i][j - 1] == 'X') {
        				continue;
        			} else {
        				count++;
        			}
        		}
        	}
        }
        return count;
    }
}