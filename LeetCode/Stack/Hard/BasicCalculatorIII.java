import java.util.*;
import java.lang.*;
import java.io.*;

class BasicCalculatorIII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		BasicCalculatorIII bc3 = new BasicCalculatorIII();
		String s = in.nextLine();
		System.out.println(bc3.calculate(s));
	}

    public int calculate(String s) {
     	String postFixString = convertToPostFix(s);
     	String[] postFix = postFixString.split(",");
     	// System.out.println(Arrays.toString(postFix));
     	int val = evaluate(postFix);
     	return val;   
    }

    public int evaluate(String[] expression) {
    	Stack<Integer> stack = new Stack<>();
    	for (int i = 0; i < expression.length; i++) {
    		if (expression[i].equals("+") || expression[i].equals("-") 
    			|| expression[i].equals("*") || expression[i].equals("/")) {
    			int rOperand = stack.isEmpty() ? 0 : stack.pop();
    			int lOperand = stack.isEmpty() ? 0 : stack.pop();
    			stack.push(calculate(lOperand, rOperand, expression[i]));

    		} else {
    			stack.push(getInt(expression[i]));
    		}
    	}

    	return stack.isEmpty() ? 0 : stack.pop();
    }

    public String convertToPostFix(String s) {
    	char[] expression = s.toCharArray();
 		Stack<Character> operatorStack = new Stack<>();
 		StringBuilder postFix = new StringBuilder();   	
 		for (int i = 0; i < expression.length; i++) {
 			if (expression[i] == ' ') {
 				continue;
 			}
 			if (expression[i] == '(') {
 				operatorStack.push(expression[i]);
 			} else if (expression[i] == ')') {
 				while (!operatorStack.isEmpty() && operatorStack.peek() != '(')  {
 					postFix.append(operatorStack.pop());
 					postFix.append(",");
 				}
 				operatorStack.pop();
 			} else if (expression[i] >= '0' && expression[i] <= '9') {
 				//Parse Integer
 				int endIndex = getEndIndexOfInt(expression, i);
 				while (i <= endIndex) {
 					postFix.append(expression[i]);
 					i += 1;
 				}
 				i -= 1;
 				postFix.append(",");
 			} else if (expression[i] == '+' || expression[i] == '-'
 				|| expression[i] == '*' || expression[i] == '/') {
 				while (!operatorStack.isEmpty() && isFirstHigher(operatorStack.peek(), expression[i])) {
 					postFix.append(operatorStack.pop());
 					postFix.append(",");
 				}
 				operatorStack.push(expression[i]);
 			}
 		}
 		while (!operatorStack.isEmpty()) {
 			postFix.append(operatorStack.pop());
 			postFix.append(",");
 		}
 		postFix.setLength(postFix.length() - 1);
 		return postFix.toString();
    }

    public boolean isFirstHigher(char first, char second) {
    	if ((first == '*' || first == '/') && (second == '+' || second == '-')) {
    		return true;
    	}
    	if ((first == '+' || first == '-') && (second == '+' || second == '-')) {
    		return true;
    	}
    	return false;
    }

    public int calculate(int l, int r, String operator) {
    	if (operator.equals("+")) {
    		return l + r;
    	} 
    	if (operator.equals("-")) {
    		return l - r;
    	}
    	if (operator.equals("*")) {
    		return l * r;
    	} 
    	if (operator.equals("/")) {
    		return r == 0 ? 0 : l / r;
    	}
    	return 0;
    }

    public int getInt(String str) {
    	int val = 0;
    	for (int i = 0; i < str.length(); i++) {
    		val *= 10;
    		val += str.charAt(i) - '0';
    	}
    	return val;
    }

    public int getEndIndexOfInt(char[] expression, int index) {
    	while (index < expression.length) {
    		if (expression[index] >= '0' && expression[index] <= '9') {
    			index += 1;
    		} else {
    			return index - 1;
    		}
    	}
    	return index - 1;
    }
}