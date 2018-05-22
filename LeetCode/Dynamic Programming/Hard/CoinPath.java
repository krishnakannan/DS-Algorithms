import java.util.*;
import java.lang.*;
import java.io.*;

class CoinPath {

	public static void main(String args[]) {
		CoinPath cp = new CoinPath();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int A[] = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();
		}
		int B = in.nextInt();
		System.out.println(cp.cheapestJump(A, B));
	}

    public List<Integer> cheapestJump(int[] A, int B) {
        if (A.length == 0 || B <= 0) {
            return new ArrayList<>();
        }
        long[] dp = new long[A.length];
        List<Integer>[] dpList = new List[A.length];
        for (int i = 0; i < dpList.length; i++) {
        	dpList[i] = new ArrayList<>();
        	dp[i] = Integer.MAX_VALUE;
        }        
        dp[0] = (long)A[0];
        dpList[0].add(1);
        for (int i = 1; i < A.length; i++) {
        	int lowerLimit = i - B >= 0 ? i - B : 0;    
        	if (A[i] == -1) {
        		continue;
        	}    	
        	for (int j = lowerLimit; j < i; j++) {

        		long candidate = dp[j] + A[i];
        		if (candidate < dp[i]) {
        			dp[i] = candidate;
        			dpList[i].clear();
        			dpList[i].addAll(dpList[j]);        			
                    dpList[i].add(i + 1);
        		} else if (candidate == dp[i]) {
                    if (compare(dpList[j], dpList[i]) < 0) {
                        dpList[i].clear();
                        dpList[i].addAll(dpList[j]);        			
                        dpList[i].add(i + 1);
                    }
                }
        	}            
        }        
        return dpList[A.length - 1];
    }
    
    public int compare(List<Integer> first, List<Integer> second) {
        int fPointer = 0;
        int sPointer = 0;
        while (fPointer < first.size() && sPointer < second.size()) {
            if (first.get(fPointer) > second.get(sPointer)) {
                return 1;
            } else if (second.get(sPointer) > first.get(fPointer)) {
                return -1;
            } else {
                fPointer += 1;
                sPointer += 1;
            }
        }
        return 0;
    } 
}