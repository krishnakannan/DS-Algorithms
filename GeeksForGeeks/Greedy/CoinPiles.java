import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/coin-piles/0#ExpectOP

class CoinPiles {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		CoinPiles cp = new CoinPiles();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int k = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(cp.getMinRemoval(arr, k));
 		}
	}

	public int getMinRemoval(int[] arr, int k) {
		if(arr.length <= 1) return 0;
        
        // findMin
        Arrays.sort(arr);
        
        int minRemoval = Integer.MAX_VALUE;
        int rc = 0;
        int prc = 0;
        for(int i = 0; i < arr.length && prc < minRemoval; i++) {
            rc = prc;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] + k < arr[j]) {
                    rc += arr[j] - arr[i] - k;
                }
            }
            
            if(rc < minRemoval) {
                minRemoval = rc;
            }
            prc += arr[i];
        }
        return minRemoval;
	}
}