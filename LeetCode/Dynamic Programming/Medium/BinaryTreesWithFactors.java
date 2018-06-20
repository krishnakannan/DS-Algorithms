import java.util.*;
import java.lang.*;
import java.io.*;

class BinaryTreesWithFactors {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] A = new int[n];
		for (int i = 0; i < A.length; i++) {
			A[i] = in.nextInt();
		}
		BinaryTreesWithFactors btwf = new BinaryTreesWithFactors();
		System.out.println(btwf.numFactoredBinaryTrees(A));
	}
    public int numFactoredBinaryTrees(int[] A) {
    	if (A.length == 0) {
    		return 0;
    	}
    	Arrays.sort(A);    	
    	Map<Integer, Long> dp = new HashMap<>();         
        dp.put(A[0], 1l);
        for (int i = 1; i < A.length; i++) {        	
            long  val = 0l;
        	for (int j = 0; j < i; j++) {
        		if (A[i] % A[j] == 0 && dp.containsKey(A[i]/A[j])) {
                    val += dp.getOrDefault(A[i]/A[j], 0l) * dp.getOrDefault(A[j], 0l);        				
        			val %= 1000000007;
        		}
        	}
        	dp.put(A[i], val + 1);
        }
        //System.out.println(dp);
        int numOfFactoredBT = 0;
        for (Map.Entry<Integer, Long> entry : dp.entrySet()) {
        	numOfFactoredBT += entry.getValue().intValue();
        	numOfFactoredBT %= 1000000007;
        }
        return numOfFactoredBT;
    }
}