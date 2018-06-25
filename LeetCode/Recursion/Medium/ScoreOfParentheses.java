import java.util.*;
import java.lang.*;   
import java.io.*;

class ScoreOfParentheses {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		ScoreOfParentheses sop = new ScoreOfParentheses();
		System.out.println(sop.scoreOfParentheses(s));
	}

    public int scoreOfParentheses(String s) {
    	return calculate(s);
    }

    public int calculate(String s) {
    	
    	if (s.length() == 0) {    		
    		return 0;
    	}

    	
    	if (s.length() == 2 && s.charAt(0) == '(' && s.charAt(1) == ')') {    		
    		return 1;
    	}

    	int length = 0;

    	int index = 0;
    	while (index < s.length()) {
    		if (s.charAt(index) == '(' && s.charAt(index + 1) == ')') {
    			length += 1;
    			index += 2;
    		} else {
    			int endIndex = getEndIndex(s, index);    			
    			length = length + 2 * calculate(s.substring(index + 1, endIndex));
    			index = endIndex + 1;
    		}    		
    	}    	    	
    	return length;
    }

    public int getEndIndex(String s, int startIndex) {
    	int bracketCount = 0;
    	int index = startIndex;
    	while (index < s.length()) {
    		if (s.charAt(index) == '(') {
    			bracketCount += 1;
    		} else {
    			bracketCount -= 1;
    		}
    		if (bracketCount == 0) {
    			return index;
    		}
    		index += 1;
    	}
    	return s.length() - 1;
    }
}