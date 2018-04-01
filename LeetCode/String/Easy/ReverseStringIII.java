public class Solution {
    Node stack = new Node();
    
    public String reverseWords(String s) {
        StringBuilder words = new StringBuilder();
        StringBuilder sentence = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++ ) {
        	if (s.charAt(i) == ' ') {
        		sentence.append(popString());
        		sentence.append(" ");
        	} else {
        		pushChar(s.charAt(i));
        	}
        }
        sentence.append(popString());
        return sentence.toString();
    }
    
    public void pushChar (char data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.prev = stack;
		stack = newNode;
	}

	public String popString () {
		StringBuilder word = new StringBuilder("");
		while (stack != null && stack.data != '\u0000') {
			word.append(stack.data);
			stack = stack.prev;
		}
		return word.toString();
	}
}

class Node {
		char data;
		Node prev;
	}