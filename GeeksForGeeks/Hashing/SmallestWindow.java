import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string/0

class SmallestWindow {
	public static void main (String[] args) {
		SmallestWindow smallestWindowObj = new SmallestWindow();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    String str = in.next();	
		    String patt = in.next();	
		    System.out.println(smallestWindowObj.getWindow(str, patt));
 		}
	}

	public String getWindow(String string, String pattern) {
		
		int len1 = string.length();
        int len2 = pattern.length();
        if (len1 < len2) {            
            return "-1";
        }
      
        int pArray[] = new int[256];
        int sArray[] = new int[256];
      
        
        for (int i = 0; i < len2; i++) {        	
            pArray[pattern.charAt(i)]++;
        }
      
        int start = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;
        int count = 0;
        for (int j = 0; j < len1 ; j++) {
            sArray[string.charAt(j)]++;
            if (pArray[string.charAt(j)] != 0 && sArray[string.charAt(j)] <= pArray[string.charAt(j)]) {
                count++;
            }            
            if (count == len2) {
                // Try to minimize the window i.e., check if
                // any character is occurring more no. of times
                // than its occurrence  in pattern, if yes
                // then remove it from starting and also remove
                // the useless characters.
                while (sArray[string.charAt(start)] > pArray[string.charAt(start)] || pArray[string.charAt(start)] == 0) {
                    if (sArray[string.charAt(start)] > pArray[string.charAt(start)]) {                    	
                        sArray[string.charAt(start)]--;
                    }
                    start++;
                }
                int windowLength = j - start + 1;
                if (minLength > windowLength) {
                    minLength = windowLength;
                    startIndex = start;
                }
            }
        }
              
        if (startIndex == -1) {           
           return "-1";
        }
      
        return string.substring(startIndex, startIndex + minLength);
	}
}