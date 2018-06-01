import java.util.*;
import java.lang.*;
import java.io.*;

class MaxSumRectangleNoLargerThanK {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		int[][] matrix = new int[m][n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		int k = in.nextInt();
		MaxSumRectangleNoLargerThanK msrnltk = new MaxSumRectangleNoLargerThanK();
		System.out.println(msrnltk.maxSumSubmatrix(matrix, k));
	}
	
    int[][] dp;
	int maxSum = Integer.MIN_VALUE;
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	int[][] newMatrix = getAppendedMatrix(matrix);
        dp = new int[newMatrix.length][newMatrix[0].length];
        for (int i = 1; i < newMatrix.length; i++) {
        	for (int j = 1; j < newMatrix[0].length; j++) {
        		if (newMatrix[i][j] > maxSum && newMatrix[i][j] <= k) {
        			maxSum = newMatrix[i][j];
        		}
        		dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + newMatrix[i][j];
        		if (dp[i][j] > maxSum && dp[i][j] <= k) {
        			maxSum = dp[i][j];
        		}
        		for (int x = 0; x < i; x++) {
        			for (int y = 0; y < j; y++) {        				
                        int sum = dp[i][j] - dp[i][y] - dp[x][j] + dp[x][y];
        				if (maxSum < sum && sum <= k) {
        					maxSum = sum;
        				}                        
        			}
        		}
        	}
            
        }
        //print(dp);
        return maxSum;
    }

    public int[][] getAppendedMatrix(int[][] matrix) {
    	int[][] newMatrix = new int[matrix.length + 1][matrix[0].length + 1];
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[0].length; j++) {
    			newMatrix[i + 1][j + 1] = matrix[i][j];
    		}
    	}
    	return newMatrix;
    }
    public void print(int matrix[][]) {
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
    }
}