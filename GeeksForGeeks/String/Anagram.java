import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/anagram/0

class Anagram {
	public static void main (String[] args) {
		Anagram an = new Anagram();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    String s1 = in.next();	
		    String s2 = in.next();
		    System.out.println(an.isAnagram(s1, s2) ? "YES" : "NO");
 		}
	}

	public boolean isAnagram(String s1, String s2) {
		int[] cArr = new int[256];
		if (s1.length() != s2.length()) {
			return false;
		}
		for (int i = 0; i < s1.length(); i++) {
			cArr[(int)s1.charAt(i)]++;
		}
		
		for (int i = 0; i < s2.length(); i++) {
			cArr[(int)s2.charAt(i)]--;
		}
		
		for (int i = 0; i < cArr.length; i++) {
			if (cArr[i] != 0) {
				return false;
			}
		}
		return true;
	}
}