import java.util.*;
import java.lang.*;   
import java.io.*;

class RemoveDuplicateLetters {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		RemoveDuplicateLetters rdl = new RemoveDuplicateLetters();
		System.out.println(rdl.removeDuplicateLetters(s));
	}
    public String removeDuplicateLetters(String s) {
    	int[] alphabetCount = new int[26];
    	boolean[] added = new boolean[26];
    	Stack<Character> stack = new Stack<>();
    	char[] string = s.toCharArray();
    	for (int i = 0; i < string.length; i++) {
    		alphabetCount[string[i] - 'a'] += 1;
    	}

    	for (int i = 0; i < string.length; i++) {
    		alphabetCount[string[i] - 'a'] -= 1;
    		if (added[string[i] - 'a']) {
    			continue;
    		}

    		while (!stack.empty() && stack.peek() > string[i] && alphabetCount[stack.peek() - 'a'] > 0) {
    			added[stack.pop() - 'a'] = false;
    		}
    		stack.push(string[i]);
    		added[string[i] - 'a'] = true;
    	}

    	StringBuilder builder = new StringBuilder();
    	while (!stack.empty()) {
    		builder.append(stack.pop());
    	}
    	return builder.reverse().toString();
    }
}