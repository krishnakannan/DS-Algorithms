import java.util.*;
import java.lang.*;
import java.io.*;

class ShortestPalindrome {
	//Retry using KMP
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		ShortestPalindrome sp = new ShortestPalindrome();
		String s = in.next();
		System.out.println(sp.shortestPalindrome(s));
	}

    public String shortestPalindrome(String s) {
    	char[] string = s.toCharArray();
        int start = 0;
        int end = string.length - 1;
        while (start < end) {
        	if (isPalindrome(string, start, end)) {
        		break;
        	} 
        	end--;
        }

        char[] front = new char[string.length - end - 1];        
        for (int i = 0, j = string.length - 1; i < front.length && j > end; i++, j--) {
        	front[i] = string[j];
        }

        return new String(front) + new String(string);
    }

    public boolean isPalindrome(char[] string, int start, int end) {
    	while (start < end) {
    		if (string[start] == string[end]) {
    			start++;
    			end--;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
}