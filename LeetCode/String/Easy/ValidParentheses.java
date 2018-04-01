public class Solution {
    public boolean isValid(String s) {
        Stack<Character> pStack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
        	if (s.charAt(i) == '{' || s.charAt(i) == '}' || s.charAt(i) == '[' || s.charAt(i) == ']' || s.charAt(i) == '(' || s.charAt(i) == ')') {
        		if (!pStack.empty()) {

        			if (pStack.peek().equals('{') && s.charAt(i) == '}') {
        				pStack.pop();
        			} else if (pStack.peek().equals('[') && s.charAt(i) == ']') {
        				pStack.pop();
        			} else if (pStack.peek().equals('(') && s.charAt(i) == ')') {
        				pStack.pop();
        			} else {
        				pStack.push(s.charAt(i));
        			}

        		} else {
        			pStack.push(s.charAt(i));	
        		}
        	}
        }
        return pStack.empty();    
    }
}