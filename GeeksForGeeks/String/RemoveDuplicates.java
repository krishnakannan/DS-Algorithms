import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/remove-duplicates/0

class RemoveDuplicates {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		in.nextLine();
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		while (--testcases >= 0) {
		    String str = in.nextLine();		
		    System.out.println(removeDuplicates.getString(str));
 		}
	}

	public String getString(String s) {
		int[] charArr = new int[256];
		Character[] arr = new Character[256];
		int length = s.length();
		int index = 0;
		for (int i = 0; i < length; i++) {			
			if (charArr[(int)s.charAt(i)] == 0) {
				charArr[(int)s.charAt(i)]++;
				arr[index] = s.charAt(i);
				index++;
			}
		}
		StringBuilder sBuilder = new StringBuilder();
		index = 0;
		while (arr[index] != null) {
			sBuilder.append(arr[index]);
			index++;
		}
		return sBuilder.toString();
	}
}