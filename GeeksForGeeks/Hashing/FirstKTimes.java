import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/first-element-to-occur-k-times/0

class FirstKTimes {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		FirstKTimes firstKTimesObj = new FirstKTimes();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int k = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(firstKTimesObj.getTheFirstChar(arr, k));
 		}
	}

	public int getTheFirstChar(int[] array, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0;  i < array.length; i++) {
			map.put(array[i], map.containsKey(array[i]) ? map.get(array[i]) + 1 : 1);			
		}

		for (int i = 0;  i < array.length; i++) {
			if (map.get(array[i]) == k) {
				return array[i];
			}
		}
		return -1;
	}
}