import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/longest-common-prefix-in-an-array/0

class LongestCommonPrefix {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		while (--testcases >= 0) {
			int n = in.nextInt();
			String[] sArr = new String[n];
			for (int i = 0; i < sArr.length; i++) {
				sArr[i] = in.next();					
			}		    
			System.out.println(lcp.getCommonPrefix(sArr));
 		}	
	}

	public String getCommonPrefix(String[] arr)  {
		int minLength = getMinLength(arr);
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < minLength; i++) {
			boolean isSameChar = true;
			char currentChar = '-';
			for (String s : arr) {
				if (currentChar == '-') { 
					currentChar = s.charAt(i);
				} else if (currentChar != s.charAt(i)) {
					isSameChar = false;
				}
			}
			if (isSameChar){
				sBuilder.append(arr[0].charAt(i));
			} else {
				break;
			}
		}

		return sBuilder.length() == 0 ? "-1" : sBuilder.toString();
	}

	public int getMinLength(String[] arr) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			min = min > arr[i].length() ? arr[i].length() : min;
		}
		return min;
	}
}