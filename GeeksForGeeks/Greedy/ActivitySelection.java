import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/activity-selection/0

class ActivitySelection {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		ActivitySelection as = new ActivitySelection();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] start = new int[n];
		    int[] finish = new int[n];
		    for (int i = 0; i < start.length; i++) {
		        start[i] = in.nextInt();
		    }
		    for (int i = 0; i < finish.length; i++) {
		        finish[i] = in.nextInt();
		    }
			System.out.println(as.countActivities(start, finish));
 		}
	}

	public int countActivities(int[] start, int[] finish) {
		int count = 1;
		int fIndex = 0;
		sort(start, finish);
		 
		for (int i = 1;  i < start.length; i++) {
			if (start[i] > finish[fIndex]) {
				count++;
				fIndex = i;
			}
		}

		for (int i = 0; i < start.length; i++) {
			System.out.print(start[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < start.length; i++) {
			System.out.print(finish[i] + " ");
		}
		
		return count;
	}

	public void sort(int[] array1, int[] array2) {
		for (int i = 0; i < array2.length; i++){
		    for (int j = 0; j < array2.length; j++){
		        if (array2[i] > array2[j] && i < j){
		            int temp1 = array1[i];
		            int temp2 = array2[i];

		            array1[i] = array1[j];
		            array2[i] = array2[j];

		            array1[j] = temp1;
		            array2[j] = temp2;
		        }
		    }
		}
	}
}