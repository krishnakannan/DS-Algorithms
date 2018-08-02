import java.util.*;
import java.lang.*;   
import java.io.*;

class LongestFibonacciSubsequence {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();			
		}
		LongestFibonacciSubsequence lfs = new LongestFibonacciSubsequence();
		System.out.println(lfs.lenLongestFibSubseq);
	}

    int[][] dp; 
    Map<Integer, Integer> map = new HashMap<>();
    
    public int lenLongestFibSubseq(int[] arr) {
        dp = new int[arr.length][arr.length];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        
        int longestLength = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int length = longestLength(arr, j, i);
                longestLength = length > longestLength ? length : longestLength;
            }
        }
        
        // for (int[] dpR : dp) {
        //     for (int x : dpR) {
        //         System.out.print(x + " ");
        //     }
        //     System.out.println();
        // }
        
        return longestLength == 2 ? 0 : longestLength;
    }
    
    public int longestLength(int[] arr, int leftIndex, int rightIndex) {
        
        if (arr[rightIndex] - arr[leftIndex] >= arr[leftIndex]) {
            dp[leftIndex][rightIndex] = 2;        
            return 2;
        }
        
        if (dp[leftIndex][rightIndex] >= 0) {
            return dp[leftIndex][rightIndex];
        }
        
        int maxLength = 2;
        if (map.containsKey(arr[rightIndex] - arr[leftIndex])) {
            int length = longestLength(arr, map.get(arr[rightIndex] - arr[leftIndex]), leftIndex) + 1;
            maxLength = length > maxLength ? length : maxLength;
        }
        
        dp[leftIndex][rightIndex] = maxLength;        
        return dp[leftIndex][rightIndex];
    }
}