import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/zero-sum-subarrays/0

class ZeroSumSubArray {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		ZeroSumSubArray zssa = new ZeroSumSubArray();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(zssa.getSubArrayCount(arr));
 		}
	}

	public int getSubArrayCount(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == 0){
				count++;
			}

			if (map.containsKey(sum)) {				
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}
        //System.out.println(map);
		return count;
	}
}