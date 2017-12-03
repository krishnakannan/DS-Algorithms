import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/last-index-of-1/0

/*
	Even though the array/string is sorted, For the sake of question we cant use Binary search.
	It is a stream.
*/

class LastIndexOfOne {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LastIndexOfOne lastIndexObj = new LastIndexOfOne();
		while (--testcases >= 0) {		    
		    String stream = in.next();
			System.out.println(lastIndexObj.getIndex(stream.toCharArray()));
 		}
	}

	public int getIndex(char[] array) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '1') {
				index = i;
			}
		}
		return index;
	}
}