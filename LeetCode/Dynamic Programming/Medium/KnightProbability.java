class Solution {

	//Both 2D MAP and 3D Array works.

	//Map<Integer, Double>[][] mapArray;
    double[][][] mapArray;

    public double knightProbability(int N, int K, int r, int c) {
			//mapArray = new Map[N][N];
            mapArray = new double[N][N][K + 1];
			for (int i = 0; i < mapArray.length; i++) {
				for (int j = 0; j < mapArray[0].length; j++) {
					// mapArray[i][j] = new HashMap<>();
                    Arrays.fill(mapArray[i][j], Double.MIN_VALUE);
				}
			}

			double probability = findProbability(1, N, K, r, c);
			return probability;
    }


    public double findProbability(double currentProbability, int size, int moves, int r, int c) {

    	// if (mapArray[r][c].containsKey(moves)) {
    	// 	return mapArray[r][c].get(moves);
    	// }
        if (mapArray[r][c][moves] != Double.MIN_VALUE) {
            return mapArray[r][c][moves];
        }

    	if (moves == 0) {
    		//mapArray[r][c].put(moves, currentProbability);
            mapArray[r][c][moves] = currentProbability;
    		return currentProbability;
    	}


    	List<int[]> nextValidMoves = getValidMoves(r, c, size);

    	double nextProbability = getProbability(currentProbability);
    	double totalProbability = 0;
    	for (int[] nextValidMove : nextValidMoves) {
    		double probability = findProbability(nextProbability, size, moves - 1, nextValidMove[0], nextValidMove[1]);
    		totalProbability += probability;    		
    	}
        
        //mapArray[r][c].put(moves, totalProbability);
        mapArray[r][c][moves] = totalProbability;

    	return totalProbability;

    }

    public List<int[]> getValidMoves(int r, int c, int N) {
    	//There are 8 moves;
    	List<int[]> validMoves = new ArrayList<>();

    	if (isValid(r - 2, c - 1, N)) {
    		validMoves.add(new int[]{r - 2, c - 1});
    	}
    	if (isValid(r - 2, c + 1, N)) {
    		validMoves.add(new int[]{r - 2, c + 1});
    	}
    	if (isValid(r - 1, c - 2, N)) {
    		validMoves.add(new int[]{r - 1, c - 2});
    	}
    	if (isValid(r - 1, c + 2, N)) {
    		validMoves.add(new int[]{r - 1, c + 2});
    	}
    	if (isValid(r + 1, c - 2, N)) {
    		validMoves.add(new int[]{r + 1, c - 2});
    	}
    	if (isValid(r + 1, c + 2, N)) {
    		validMoves.add(new int[]{r + 1, c + 2});
    	}
    	if (isValid(r + 2, c - 1, N)) {
    		validMoves.add(new int[]{r + 2, c - 1});
    	}
    	if (isValid(r + 2, c + 1, N)) {
    		validMoves.add(new int[]{r + 2, c + 1});
    	}
    	return validMoves;
    }

    public boolean isValid(int r, int c, int N) {
    	return (r >= 0 && r < N && c >= 0 && c < N);
    }

    public double getProbability(double currentProbability) {
    	return ((currentProbability / 8));
    }
}