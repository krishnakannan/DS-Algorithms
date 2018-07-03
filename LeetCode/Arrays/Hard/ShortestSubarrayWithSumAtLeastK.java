import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestSubarrayWithSumAtLeastK {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();
		}
		int K = in.nextInt();
		ShortestSubarrayWithSumAtLeastK sswsalk = new ShortestSubarrayWithSumAtLeastK();
		System.out.println(sswsalk.shortestSubarray(A, K));
	}

	//Referred

    public int shortestSubarray(int[] A, int K) {
        LinkedList<Integer> indexList = new LinkedList<>();
        long[] pSum = new long[A.length  + 1];
        for (int i = 0; i < A.length; i++) {
            pSum[i + 1] = pSum[i] + A[i];
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < pSum.length; i++) {
            while (indexList.size() > 0 && pSum[i] - pSum[indexList.peekFirst()] >= K) {
                minLength = Math.min(i - indexList.pollFirst(), minLength);
            }
            
            while (indexList.size() > 0 && pSum[i] <= pSum[indexList.peekLast()]) {
                indexList.pollLast();
            }
            
            indexList.addLast(i);
        }
        
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}