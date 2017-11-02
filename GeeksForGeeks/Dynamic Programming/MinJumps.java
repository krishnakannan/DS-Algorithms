import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/minimum-number-of-jumps/0

class MinJumps {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MinJumps mj = new MinJumps();		
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

		int[] jumpArr = new int[arr.length];
		for (int i = 0; i < jumpArr.length; i++) {
			jumpArr[i] = Integer.MAX_VALUE;
		}
		jumpArr[0] = 0;
		int jumps = 0;
		int maxReach = arr[0];	
		for (int i = 0; i < arr.length; i++) {			
			jumps = jumpArr[i] + 1;					
  			for (int j = i + 1; j <= arr[i] + i; j++) { 				  				
  				if (maxReach < i) {
					return -1;
				} else {
					maxReach = maxReach < arr[i] + i ? arr[i] + i : maxReach;
				}
				if (j == arr.length - 1) {
					jumpArr[j] = jumpArr[j] > jumps ? jumps : jumpArr[j];
					return jumpArr[j];
				} else {
					if (j < arr.length) {
						jumpArr[j] = jumpArr[j] > jumps ? jumps : jumpArr[j];	
					}					
				}
			}
		}




		return -1;
	}


}