import java.util.*;
import java.lang.*;   
import java.io.*;

class BasicCalculator {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.calculate(s));
	}	

    public int calculate(String s) {    	
        char[] string = s.toCharArray();
        String[] postfix = convertToPostfix(string);
        return evaluate(postfix);
    }

    public int evaluate(String[] postfix) {
    	Stack<Integer> stack = new Stack<>();
    	for (int i = 0; i < postfix.length; i++) {
    		if (postfix[i].equals("+")) {
    			int n1 = stack.pop();
    			int n2 = stack.pop();
    			stack.push(n1 + n2);
    		} else if (postfix[i].equals("-")) {
    			int n1 = stack.pop();
    			int n2 = stack.pop();
    			stack.push(n2 - n1);
    		} else {
    			stack.push(getNum(postfix[i]));
    		}
    	}
    	return stack.empty() ? 0 : stack.pop();
    }

    public String[] convertToPostfix(char[] infix) {
    	List<String> postfix = new ArrayList<>();
    	Stack<Character> operatorStack = new Stack<>();
    	for (int i = 0; i < infix.length; i++) {
    		if (infix[i] >= '0' && infix[i] <= '9') {
    			StringBuilder numBuilder = new StringBuilder();
    			while (i < infix.length && infix[i] >= '0' && infix[i] <= '9') {
    				numBuilder.append(infix[i]);
    				i++;
    			}
    			i--;
    			postfix.add(numBuilder.toString());    			
    		} else if (infix[i] == ' ') {
    			continue;
    		} else if (infix[i] == '(') {
    			operatorStack.push('(');
    		} else if (infix[i] == ')') {
    			while (!operatorStack.empty() && operatorStack.peek() != '(') {
    				postfix.add(operatorStack.pop() + "");
    			}
    			if (!operatorStack.empty() && operatorStack.peek() == '(') {
    				operatorStack.pop();
    			}
    		} else if (infix[i] == '+' || infix[i] == '-') {
    			while (!operatorStack.empty() && operatorStack.peek() != '(') {
    				postfix.add(operatorStack.pop() + "");
    			}
    			operatorStack.push(infix[i]);
    		}
    	}
    	while (!operatorStack.empty()) {
    		postfix.add(operatorStack.pop() + "");
    	}    	
    	return postfix.toArray(new String[postfix.size()]);
    }
    

    public int getNum(String num) {
    	char[] str = num.toCharArray();
    	boolean isNegative = false;
    	int i = 0;
    	if (str[0] == '-') {
    		isNegative = true;
    		i++;
    	}
    	int val = 0;
    	for (; i < str.length; i++) {
    		val *= 10;
    		val += str[i] - '0';
    	}
    	return isNegative ? -val : val;
    }

    public void print(Stack stack) {
        System.out.println(Arrays.toString(stack.toArray()));
    }
}