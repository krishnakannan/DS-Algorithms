import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0

class ChocDistribution {
	public static void main (String[] args) {
		ChocDistribution cd = new ChocDistribution();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int packets = in.nextInt();
		    int[] arr = new int[packets];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
		    int students = in.nextInt();
		    System.out.println(cd.distribute(arr, students));
 		}
	}

	public int distribute(int[] arr, students) {
		Arrays.sort(arr);
		int j = students - 1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; j < arr.length; j++, i++) {
			min = min > arr[j] - arr[i] ? arr[j] - arr[i] : min;
		}
		return min;
	}
}