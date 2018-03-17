class Solution {
    public void wallsAndGates(int[][] rooms) {
        
    	for (int i = 0; i < rooms.length; i++) {
    		for (int j = 0; j < rooms[0].length; j++) {
    			if (rooms[i][j] == 0) {
    				bfs(rooms, i, j);
    			}
    		}
    	}
    	
    }


    public void bfs(int[][] rooms, int row, int col) {
    
    	Queue<List<int[]>> bfsQ = new LinkedList<>();
    	List<int[]> levelZero = new ArrayList<>();    	    	
        levelZero.add(getCoord(row, col));
    	bfsQ.add(levelZero);
    	int distance = 0;

    	while (!bfsQ.isEmpty()) {
    		List<int[]> currentLevel = bfsQ.poll();
    		distance++;
    		List<int[]> nextLevel = new ArrayList<>();

    		for (int[] currentPos : currentLevel) {
    			int i = currentPos[0];
    			int j = currentPos[1];

	    		//top
	    		if (i - 1 >= 0 && rooms[i - 1][j] != -1 && rooms[i - 1][j] > distance) {
	    			rooms[i - 1][j] = distance;
	    			nextLevel.add(getCoord(i - 1, j));
	    		}

	    		//bottom
	    		if (i + 1 < rooms.length && rooms[i + 1][j] != -1 && rooms[i + 1][j] > distance) {
	    			rooms[i + 1][j] = distance;
	    			nextLevel.add(getCoord(i + 1, j));
	    		}

	    		//Left
	    		if (j - 1 >= 0 && rooms[i][j - 1] != -1 && rooms[i][j - 1] > distance) {
	    			rooms[i][j - 1] = distance;
	    			nextLevel.add(getCoord(i, j - 1));
	    		}


	    		if (j + 1 < rooms[0].length && rooms[i][j + 1] != -1 && rooms[i][j + 1] > distance) {
	    			rooms[i][j + 1] = distance;
	    			nextLevel.add(getCoord(i, j + 1));
	    		}
    		}

    		if (!nextLevel.isEmpty()) {
    			bfsQ.add(nextLevel);
    		}
    	}
    }


    public int[] getCoord(int row, int col) {
    	int[] coord = new int[2];
    	coord[0] = row;
    	coord[1] = col;
    	return coord;
    }
}