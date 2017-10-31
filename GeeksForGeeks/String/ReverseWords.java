import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0

class ReverseWords {
	public static void main (String[] args) {
		ReverseWords rw = new ReverseWords();
 		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    String str = in.next();		
		    rw.reverseSentence(str);
 		}
	}

	
	public void reverseSentence (String str) {
		String[] sArr = str.split("\\.");				
		for (int i = sArr.length - 1; i >= 0; i--) {			
			System.out.print(sArr[i]);
			if (i > 0) {
				System.out.print(".");
			}		
		}
		System.out.println();
	}
}