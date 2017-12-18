import java.util.*;
import java.lang.*;
import java.io.*;

class MinimumWindowSubstring {

	
	int[] subStringChars = new int[256];	
	String window = "";
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		MinimumWindowSubstring mws = new MinimumWindowSubstring();
		while (--testcases >= 0) {
		    String str1 = in.next();	
		    String str2 = in.next();			    
		    System.out.println(mws.minWindow(str1, str2));
 		}
	}


    public String minWindow(String s, String t) {
    	window = "";	
		subStringChars = new int[256];		        
        populateSet(t);
        int windowLength = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int strLength = s.length();
        char[] sArray = s.toCharArray();
        while (left <  strLength || right < strLength && left < right) {        	
        	if (windowHasSubstring()) {
        		if ((right - left) < windowLength) {
        			windowLength = right - left;
        			window = s.substring(left, right);
        			//System.out.println(window);
        		}        		
        		subStringChars[(int)sArray[left]]++;
        		left++;
        		
        	} else if (right < strLength) {
        		subStringChars[(int)sArray[right]]--;        		
        		if (right < strLength) {
        			right++;	
        		} else {
        			left++;
        		}        		
        	} else {
        		if (right < strLength) {        			
        			right++;	
        		} else {
        			left++;
        		}        		
        	}        	
        }
        return window;
    }

    public void populateSet(String str) {
    	char[] sArr = str.toCharArray();
    	for (int i = 0; i < sArr.length; i++) {    		
    		subStringChars[(int)sArr[i]]++;
    	}    	
    }

    public boolean windowHasSubstring() {
    	for (int i = 0; i < 256; i++) {
    		if (subStringChars[i] > 0) {
    			return false;
    		}
    	}    	
    	return true;
    }
}