import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem/0

class ArrayPairSumDivisibility {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		ArrayPairSumDivisibility apsd = new ArrayPairSumDivisibility();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			int k = in.nextInt();
			System.out.println(apsd.hasPairs(arr, k) ? "True" : "False");
 		}
	}

	public boolean hasPairs(int arr[], int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int needed = (arr[i] % k) == 0 ? 0 : k - (arr[i] % k);
			//System.out.println(needed);
			if (map.containsKey(needed) && map.get(needed) == 1) {
				map.put(needed, 0);
				continue;
			} else {
				int key = arr[i] > k ? arr[i] % k : k - arr[i];
				map.put(key, 1);	
			}
			//System.out.println(map);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 0) {
				return false;
			}
		}

		return true;
	}
}