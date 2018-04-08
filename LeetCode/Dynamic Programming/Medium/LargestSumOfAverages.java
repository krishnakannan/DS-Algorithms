import java.util.*;
import java.lang.*;
import java.io.*;

class LargestSumOfAverages {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();
		}
		int K = in.nextInt();
		LargestSumOfAverages lsa = new LargestSumOfAverages();
		System.out.println(lsa.largestSumOfAverages(A, K));		
	}
	
	double[][] dp;
    public double largestSumOfAverages(int[] A, int K) {
    	dp = new double[A.length][K + 1];
    	for (double[] dpRow : dp) {
    		Arrays.fill(dpRow, Double.MIN_VALUE);
    	}
    	double val = getLargestSumOfAvg(A, K, 0);
    	System.out.println("DPED " + count);
    	return val;
    }

    int count = 0;

    public double getLargestSumOfAvg(int[] values, int reqdPartitions, int index) {    	    	

    	if (index >= values.length) {
    		return 0d;
    	}

    	if (dp[index][reqdPartitions] != Double.MIN_VALUE) {
    		count++;
    		return dp[index][reqdPartitions];
    	}

    	if (reqdPartitions == 1) {
    		double avg = getAvg(values, index, values.length - 1);    		
    		return avg;
    	}		
		double maxLocal = 0d;
    	for (int i = index; i < values.length; i++) {
    		double avg = getAvg(values, index, i) + getLargestSumOfAvg(values, reqdPartitions - 1, i + 1);    		
    		//maxAvg = maxAvg < avg ? avg : maxAvg;
    		maxLocal = maxLocal < avg ? avg : maxLocal;
    	}    	    
    	dp[index][reqdPartitions] = maxLocal;	
    	return dp[index][reqdPartitions];
    }

    public double getAvg(int[] values, int start, int end) {
    	double sum = 0d;
    	double count = 0d;
    	for (int i = start; i <= end; i++) {
    		sum += (double)values[i];
    		count += 1d;
    	}    	
    	return sum / count;
    }
}