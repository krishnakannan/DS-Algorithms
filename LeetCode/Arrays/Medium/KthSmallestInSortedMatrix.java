public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
    	int[] flatMatrix = new int[matrix.length * matrix.length];
    	int index = 0;
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix.length; j++) {
        		flatMatrix[index] = matrix[i][j];
        		index++;
        	}
        }

        Arrays.sort(flatMatrix);
        return flatMatrix[k - 1];
    }
}