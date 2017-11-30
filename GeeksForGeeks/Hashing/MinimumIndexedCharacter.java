import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/minimum-indexed-character/0

class MinimumIndexedCharacter {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MinimumIndexedCharacter mic = new MinimumIndexedCharacter();
		while (--testcases >= 0) {
		    String str = in.next();
		    String patt = in.next();
		    System.out.println(mic.findMinimumIndexedChar(str, patt));
		
 		}
	}

	public String findMinimumIndexedChar(String str, String patt) {
		Set<Character> charSet = new HashSet<>();
		int pattLen = patt.length();
		int strLen = str.length();
		for (int i = 0; i < pattLen; i++) {
			charSet.add(patt.charAt(i));
		}

		for (int i = 0; i < strLen; i++) {
			if (charSet.contains(str.charAt(i))) {
				return Character.toString(str.charAt(i));
			}
		}

		return "No character present";
	}
}