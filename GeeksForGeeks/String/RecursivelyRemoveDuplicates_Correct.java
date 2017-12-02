import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0

class RecursivelyRemoveDuplicatesI {	
	public static void main (String[] args) {
		RecursivelyRemoveDuplicatesI rd = new RecursivelyRemoveDuplicatesI();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    String str = in.next();		
		    System.out.println(rd.processString(str));
 		} 		
	}

	public String processString(String s) {
		String uniq = s;
		while(containsAdjacentDuplicates(uniq)) {
			uniq = removeDuplicates(uniq);
		}
		return uniq;
		
	}
	
	public String removeDuplicates(String s) {

		char[] string = s.toCharArray();
		StringBuilder sBuilder = new StringBuilder();
		int i;
		for (i = 0; i < string.length - 1; i++) {
			if (string[i] == string[i + 1]) {
				while (i < string.length - 1 && string[i] == string[i + 1]) {
					i++;
				}				
				continue;
			}			
			sBuilder.append(string[i]);
		}
		if (i == string.length - 1 && string[i] != string[i - 1]) {
			sBuilder.append(string[i]);
		}
		return sBuilder.toString();
	}

	public boolean containsAdjacentDuplicates(String s){
		int length = s.length();
		for (int i = 0; i < length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)){
				return true;
			}
		}
		return false;
	}
}