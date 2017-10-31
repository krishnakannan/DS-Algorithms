import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/leaders-in-an-array/0

class LeadersArray {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LeadersArray la = new LeadersArray();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			la.findLeaders(arr);
 		}
	}

	public void findLeaders(int[] arr) {
		if (arr.length == 0) {
			return;
		}
		int rHigh = arr[arr.length - 1];
		List<Integer> leaders = new ArrayList<>();
		leaders.add(rHigh);
		for (int i = arr.length - 2; i >=0; i--) {			
			if (arr[i] > rHigh) {
				rHigh = arr[i];
				leaders.add(rHigh);
			}
		}
		Collections.reverse(leaders);
		for (Integer leader : leaders) {
			System.out.print(leader + " ");
		}
	}
}