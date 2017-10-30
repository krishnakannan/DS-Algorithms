import java.util.*;
import java.lang.*;
import java.io.*;

class ParenthesisChecker {
	public static void main (String[] args) {
		ParenthesisChecker pc = new ParenthesisChecker();
 		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		
		while (--testcases >= 0) {
		    String str = in.next();		
		    System.out.println(pc.isBalanced(str) ? "balanced" : "not balanced");
 		}
	}

	public boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		char[] sArr = s.toCharArray();
		for (int i = 0; i < sArr.length; i++) {
			if (stack.empty()) {
				stack.push(sArr[i]);
			} else {
				if (sArr[i] == ')' && stack.peek() == '(') {
						stack.pop();
					} else if (sArr[i] == '}' && stack.peek() == '{') {
						stack.pop();
					} else if (sArr[i] == ']' && stack.peek() == '[') {
						stack.pop();
					} else if (sArr[i] == '('  || sArr[i] == '[' || sArr[i] == '{' || sArr[i] == ')'  || sArr[i] == '}' || sArr[i] == ']') {
						stack.push(sArr[i]);	
				}
			}
		}

		return stack.empty();
	}
}