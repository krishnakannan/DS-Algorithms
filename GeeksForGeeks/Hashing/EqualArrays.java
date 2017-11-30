import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/check-if-two-arrays-are-equal-or-not/0

class EqualArrays {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		EqualArrays equalArraysObj = new EqualArrays();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr1 = new int[n];
		    int[] arr2 = new int[n];
		    for (int i = 0; i < n; i++) {
		        arr1[i] = in.nextInt();		        
		    }
		    for (int i = 0; i < n; i++) {
		        arr2[i] = in.nextInt();		        
		    }

			System.out.println(equalArraysObj.isEqual(arr1, arr2) ? 1 : 0);
 		}
	}

	public boolean isEqual(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], map.containsKey(arr1[i]) ? map.get(arr1[i]) + 1 : 1);
		}

		for (int i = 0; i < arr1.length; i++) {
			map.put(arr2[i], map.containsKey(arr2[i]) ? map.get(arr2[i]) - 1 : 0);
			if (map.get(arr2[i]) == 0) {
				map.remove(arr2[i]);
			}
		}		

		return map.size() == 0 ? true : false;
	}
}