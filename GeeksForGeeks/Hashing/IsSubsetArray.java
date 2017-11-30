import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/array-subset-of-another-array/0

class IsSubsetArray {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		IsSubsetArray isa = new IsSubsetArray();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int m = in.nextInt();
		    int[] arr1 = new int[n];
		    int[] arr2 = new int[m];
		    for (int i = 0; i < arr1.length; i++) {
		        arr1[i] = in.nextInt();
		    }
		    for (int i = 0; i < arr2.length; i++) {
		        arr2[i] = in.nextInt();
		    }
			System.out.println(isa.isSubsetArray(arr1, arr2) ? "Yes" : "No");
 		}
	}

	public boolean isSubsetArray(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new HashMap<>();
		if (arr1.length > arr2.length) {
			for (int i = 0; i < arr1.length; i++) {
				map.put(arr1[i], map.containsKey(arr1[i]) ? map.get(arr1[i]) + 1 : 1);
			}
			for (int i = 0; i < arr2.length; i++) {
				if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
					map.put(arr2[i], map.get(arr2[i]) - 1);
				} else {
					return false;
				}
			}
		} else {
			for (int i = 0; i < arr2.length; i++) {
				map.put(arr2[i], map.containsKey(arr2[i]) ? map.get(arr2[i]) + 1 : 1);
			}
			for (int i = 0; i < arr1.length; i++) {
				if (map.containsKey(arr1[i]) && map.get(arr1[i]) > 0) {
					map.put(arr1[i], map.get(arr1[i]) - 1);
				} else {
					return false;
				}
			}
		}

		return true;
	}
}