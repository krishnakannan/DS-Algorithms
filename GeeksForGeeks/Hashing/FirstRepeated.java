import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/find-first-repeated-character/0

class FirstRepeated {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		FirstRepeated fr = new FirstRepeated();		
		while (--testcases >= 0) {
		 	String s = in.next();
		 	System.out.println(fr.firstRepeated(s));
 		}
	}

	public String firstRepeated(String s) { 
		Set<Character> stringSet = new HashSet<>();
		int length = s.length();
		for (int i = 0; i < length; i++) {
			if (stringSet.contains(s.charAt(i))) {
				return Character.toString(s.charAt(i));
			} else {
				stringSet.add(s.charAt(i));
			}
		}
		return "-1";
	}
}