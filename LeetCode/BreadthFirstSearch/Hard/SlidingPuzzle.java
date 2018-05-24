import java.util.*;
import java.lang.*;
import java.io.*;

class SlidingPuzzle {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int[][] board = new int[2][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = in.nextInt();
			}
		}
		SlidingPuzzle sp = new SlidingPuzzle();
		System.out.println(sp.slidingPuzzle(board));
		System.out.println(sp.count);
	}

	/*
		Referred Hint. StraightForward BFS solution.
	*/

	class BoardConfig {
		int[][] board;
		String bString;
		int stepsSoFar;
		int[] zeroPos;
		public BoardConfig(int[][] board, String bString, int stepsSoFar, int[] zeroPos) {
			this.board = board;
			this.bString = bString;
			this.zeroPos = zeroPos;
			this.stepsSoFar = stepsSoFar;
		}
	}

	Set<String> processed;	

    public int slidingPuzzle(int[][] board) {
        processed = new HashSet<>();
        int[] initZeroPos = new int[2];
        for (int i = 0; i < board.length; i++) {
        	for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 0) {
					initZeroPos[0] = i;
					initZeroPos[1] = j;
					break;
				}        		
        	}
        }        
        BoardConfig initConfig = new BoardConfig(board, getConfigString(board), 0, initZeroPos);


        Queue<BoardConfig> bfsQ = new LinkedList<>();
        bfsQ.add(initConfig);
        processed.add(initConfig.bString);
        
        while (!bfsQ.isEmpty()) {
        	BoardConfig polledConfig = bfsQ.poll();
        	if (hasSolved(polledConfig.bString)) {
        		return polledConfig.stepsSoFar;
        	}
            processed.add(polledConfig.bString);            
        	List<BoardConfig> neighbors = getNeighbors(polledConfig);
        	for (BoardConfig neighborConfig : neighbors) {
				if (!processed.contains(neighborConfig.bString)) {
                    processed.add(neighborConfig.bString);
					if (hasSolved(neighborConfig.bString)) {
						return neighborConfig.stepsSoFar;
					}
					bfsQ.add(neighborConfig);
				}        		
        	}
        }

       return -1;


    }

    public boolean hasSolved(String configString) {
    	return configString.equals("[1, 2, 3][4, 5, 0]");
    }

    public List<BoardConfig> getNeighbors(BoardConfig current) {
    	int[][] board = current.board;
    	int[] zeroPos = current.zeroPos;
    	int steps = current.stepsSoFar;
    	List<BoardConfig> configs = new ArrayList<>();
    	int zx = zeroPos[0];
    	int zy = zeroPos[1];
    	
    	if (zx - 1 >= 0) {
    		int[][] newBoard = getDeepCopy(board);    	
    		newBoard[zx][zy] = newBoard[zx - 1][zy];
    		newBoard[zx - 1][zy] = 0;
    		configs.add(new BoardConfig(newBoard, getConfigString(newBoard), steps + 1, new int[]{zx - 1, zy}));
    	}

    	if (zx + 1 < 2) {
    		int[][] newBoard = getDeepCopy(board);    	
    		newBoard[zx][zy] = newBoard[zx + 1][zy];
    		newBoard[zx + 1][zy] = 0;
    		configs.add(new BoardConfig(newBoard, getConfigString(newBoard), steps + 1, new int[]{zx + 1, zy}));
    	}

    	if (zy - 1 >= 0) {
			int[][] newBoard = getDeepCopy(board);    	
    		newBoard[zx][zy] = newBoard[zx][zy - 1];
    		newBoard[zx][zy - 1] = 0;
    		configs.add(new BoardConfig(newBoard, getConfigString(newBoard), steps + 1, new int[]{zx, zy - 1}));
    	}

    	if (zy + 1 < 3) {
			int[][] newBoard = getDeepCopy(board);
    		newBoard[zx][zy] = newBoard[zx][zy + 1];
    		newBoard[zx][zy + 1] = 0;
    		configs.add(new BoardConfig(newBoard, getConfigString(newBoard), steps + 1, new int[]{zx, zy + 1}));
    	}

    	return configs;
    }

    public int[][] getDeepCopy(int[][] from) {
    	int[][] to = new int[from.length][from[0].length];
    	for (int i = 0; i < to.length; i++) {
    		for (int j = 0; j < to[0].length; j++) {
    			to[i][j] = from[i][j];
    		}
    	}
    	return to;
    }

    public String getConfigString(int[][] matrix) {
    	StringBuilder sb = new StringBuilder();
    	for (int[] matRow : matrix) {
    		sb.append(Arrays.toString(matRow));
    	}    	
    	return sb.toString();    	
    }

}