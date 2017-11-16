//https://leetcode.com/problems/maximal-square/description/

class MaximalSquare {
      public int maximalSquare(char[][] charMatrix) {
      	int max = Integer.MIN_VALUE;
      	if (charMatrix.length == 0) {
      		return 0;
      	}
      	int[][] matrix = new int[charMatrix.length][charMatrix[0].length];
 		
 		for (int i = 0; i < matrix.length; i++) {
 			for (int j = 0; j < matrix[0].length; j++) {
 				matrix[i][j] = Character.getNumericValue(charMatrix[i][j]);
 			}
 		}
          	System.out.println();
 		for (int i = 1; i < matrix.length; i++) {
 			for (int j = 1; j < matrix[0].length; j++) {
 				if (matrix[i][j] > 0) {
 					int minValue =  min(matrix[i - 1][j - 1], matrix[i][j - 1], matrix[i - 1][j]);
 					matrix[i][j] = minValue == 0 && matrix[i][j] == 1 ? matrix[i][j] : matrix[i][j] + minValue;
 				}
 			}
 		}

 		for (int i = 0; i < matrix.length; i++) {
 			for (int j = 0; j < matrix[0].length; j++) {
 				max = max < matrix[i][j] ? matrix[i][j] : max;
 			}
 		}

 		return max * max;

    }

    public int min(int a, int b, int c) {
    	return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
}