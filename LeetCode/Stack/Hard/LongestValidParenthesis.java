import java.util.*;
import java.lang.*;
import java.io.*;

class LongestValidParentheses {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		LongestValidParentheses lvp = new LongestValidParentheses();
		String s = in.next();
		System.out.println(lvp.longestValidParentheses(s));
	}

    public int longestValidParentheses(String s) {        
        Stack<Integer> numStack = new Stack<>();
        char[] parenthesis = s.toCharArray();
        int[] aux = new int[parenthesis.length];
        int count = 0;
        for (int i = 0; i < parenthesis.length; i++) {
        	if (numStack.empty()) {        		
        		numStack.push(i);
        	} else {
        		if (parenthesis[numStack.peek()] == '(' && parenthesis[i] == ')') {
        			aux[i] = 1;
        			aux[numStack.pop()] = 1;        			        			
                    count++;
        		} else {        			
        			numStack.push(i);
        		}
        	}
        }
        if (count == 0) {
            return 0;
        }
        int longest = 0;
        count = 0;
        for (int i = 0; i < aux.length; i++) {        	
        	if (aux[i] == 1) {
        		count++;
        	} else {
        		longest = longest < count ? count : longest;
        		count = 0;
        	}
        }
       	longest = longest < count ? count : longest;
        return longest;
    }
}