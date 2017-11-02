import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0

class MinJumpsLinear {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MinJumpsLinear mj = new MinJumpsLinear();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(mj.minJumps(arr));
 		}
	}

	public int minJumps(int[] arr) {
		if (arr.length <= 1)
            return 0;

        if (arr[0] == 0)
            return -1;

		int maxReach = arr[0];
		int jumps = 1;
		int stepsRemaining = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1) {
				return jumps;
			}
			maxReach = max(maxReach, arr[i] + i) ;
			stepsRemaining--;
			if (stepsRemaining == 0) {
				jumps++;
				if (i >= maxReach) {
					return -1;
				}
				stepsRemaining = maxReach - i;
			}
		}
		return -1;
	}

	public int max(int a, int b) {
		return a > b ? a : b;
	}

}