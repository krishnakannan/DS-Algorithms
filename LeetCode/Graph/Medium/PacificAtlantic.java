//Plain BT - DFS Implementation

class PacificAtlantic {

    int[][] pdp;
	int[][] adp;
    

    public List<int[]> pacificAtlantic(int[][] matrix) {
        
    	List<int[]> positions = new ArrayList<>();
        if (matrix.length > 0) {
            pdp = new int[matrix.length][matrix[0].length];
    	    adp = new int[matrix.length][matrix[0].length];    
        }
    	

    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {
                
                boolean crPacific = canReachOcean(matrix, i, j, true);
                boolean crAtlantic = canReachOcean(matrix, i, j, false);
                
    			if (crPacific && crAtlantic) {
    				int[] arr = new int[2];
    				arr[0] = i;
    				arr[1] = j;
    				positions.add(arr);
    			}
    		}
    	}    
        
    	return positions;
    }

    //Left and Top are Pacific.   
	//Right and Bottom are Atlantic. 
    public boolean canReachOcean(int[][] matrix, int row, int col, boolean isReachingPacific) {

    	if (isReachingPacific) {
    		if (row == 0 || col == 0) {
                pdp[row][col] = 1;    
	    		return true;
	    	}

	    	if (pdp[row][col] == 1) {
	    		return true;
	    	} 
	    
    	} else {
    		if (row == matrix.length - 1 || col == matrix[0].length - 1) {
                adp[row][col] = 1;    
	    		return true;
	    	}

	    	if (adp[row][col] == 1) {
	    		return true;
	    	} 
    	}
    	
    	boolean top = false;
    	boolean left = false;
    	boolean right = false;
        boolean bottom = false;

        //Top
    	if (row - 1 >= 0 && matrix[row - 1][col] >= 0 && matrix[row - 1][col] <= matrix[row][col]) {
            int matrixVal = matrix[row][col];
    		matrix[row][col] = -1;
    		top = canReachOcean(matrix, row - 1, col, isReachingPacific);
    		matrix[row][col] = matrixVal;
    	}

    	//Left 
    	if (col - 1 >= 0 && matrix[row][col - 1] >= 0 && matrix[row][col - 1] <= matrix[row][col]) {
    		int matrixVal = matrix[row][col];
    		matrix[row][col] = -1;
    		left = canReachOcean(matrix, row, col - 1, isReachingPacific);
    		matrix[row][col] = matrixVal;
    	}

    	//Right
    	if (col + 1 < matrix[0].length && matrix[row][col + 1] >= 0 && matrix[row][col + 1] <= matrix[row][col]) {
    		int matrixVal = matrix[row][col];
    		matrix[row][col] = -1;
    		right = canReachOcean(matrix, row, col + 1, isReachingPacific);
    		matrix[row][col] = matrixVal;
    	}
        
        //Bottom
        if (row + 1 < matrix.length && matrix[row + 1][col] >= 0 && matrix[row + 1][col] <= matrix[row][col]) {
    		int matrixVal = matrix[row][col];
    		matrix[row][col] = -1;
    		bottom = canReachOcean(matrix, row + 1, col, isReachingPacific);
    		matrix[row][col] = matrixVal;
    	}
        
        boolean canReach = top || bottom || left || right;
        
        if (isReachingPacific) {
            if (canReach) {
                pdp[row][col] = 1;    
            } else {
                pdp[row][col] = -1;
            }   
        } else {
            if (canReach) {
                adp[row][col] = 1;
            } else {
                adp[row][col] = -1;
            }   
        }
        
    	return top || bottom || left || right;
    }
}