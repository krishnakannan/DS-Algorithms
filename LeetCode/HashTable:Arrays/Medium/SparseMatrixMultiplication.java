class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        
    	int[][] resultantMatrix = new int[A.length][B[0].length];
        Set<Integer> nonZeroARows = new HashSet<>();
        Set<Integer> nonZeroBCols = new HashSet<>();
        
        for (int i = 0; i < A.length; i++) {
            int rowVal = 0;
    		for (int j = 0; j < A[0].length; j++) {                
    			rowVal += A[i][j];
    		}
            if (rowVal != 0) {
                nonZeroARows.add(i);
            }
    	}
        
        for (int i = 0; i < B[0].length; i++) {
            int colVal = 0;
    		for (int j = 0; j < B.length; j++) {                
    			colVal += B[j][i];
    		}
            if (colVal != 0) {
                nonZeroBCols.add(i);
            }
    	}
        
        
        for (Integer i : nonZeroARows) {
            for (Integer j : nonZeroBCols) {
                resultantMatrix[i][j] = getValue(A, B, i, j);    
            }
        }
        
    	return resultantMatrix;
    }

    public int getValue(int[][] A, int[][] B, int i, int j) {
    	int val = 0;
    	//Summation of ith Row and jth col
    	for (int x = 0; x < A[0].length; x++) {            
    		val += A[i][x] * B[x][j];
    	}
    	return val;
	}
}