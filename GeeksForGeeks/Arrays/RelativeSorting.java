import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/relative-sorting/0

class RelativeSorting {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		RelativeSorting rs = new RelativeSorting();
		while (--testcases >= 0) {
		    int n1 = in.nextInt();
		    int n2 = in.nextInt();
		    int[] arr1 = new int[n1];
		    int[] arr2 = new int[n2];
		    for (int i = 0; i < arr1.length; i++) {
		        arr1[i] = in.nextInt();
		    }
			for (int i = 0; i < arr2.length; i++) {
		        arr2[i] = in.nextInt();
		    }
		    int[] result = rs.sort(arr1, arr2);
		    for (int i = 0; i < result.length; i++) {
		    	System.out.print(result[i] + " ");
		    }
		    System.out.println();
 		}
	}

	public int[] sort(int[] arr1, int[] arr2) {
		int[] result = new int[arr1.length];
		int rIndex = 0;
		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], map.containsKey(arr1[i]) ? map.get(arr1[i]) + 1 : 1);
		}

		for (int i = 0;  i < arr2.length; i++) {
			if (map.containsKey(arr2[i])) {
				int val = map.get(arr2[i]);
				map.remove(arr2[i]);
				while (--val >= 0) {
					result[rIndex] = arr2[i];
					rIndex++;
				}
			}			
		}

		for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int val = entry.getValue();					
			while (--val >= 0 && rIndex < result.length) {
				result[rIndex] = key;
				rIndex++;
			}	
		}

		return result;
	}
}