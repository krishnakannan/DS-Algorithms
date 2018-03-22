import java.util.*;
import java.lang.*;
import java.io.*;

class BasicCalculatorII {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		BasicCalculatorII bc = new BasicCalculatorII();
		System.out.println(bc.calculate(s));
	}

    Stack<Character> operatorStack;
	Stack<Integer> operandStack;
	Integer index;

    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        char[] expression = s.toCharArray();        
        operatorStack = new Stack<>();
        operandStack = new Stack<>();
        
        if (expression[0] == '-') {
            operatorStack.add('-');
        } else {
            operatorStack.add('+');
        }
        
        int finalValue = 0;
        index = 0;
        int lOperand = 0;
        int rOperand = 0;

        while (index < expression.length) {
        	if (operandStack.empty()) {
        		lOperand = getInteger(expression);
        	} else {
        		lOperand = operandStack.pop();
        	}

        	while (index < expression.length && expression[index] == ' ') {
        		index++;
        	}

        	char operator = index < expression.length ? expression[index] : '?';
        	index++;

        	rOperand = getInteger(expression);

        	if (operator == '*') {
        		operandStack.push(lOperand * rOperand);
        	} else if (operator == '/') {
        		operandStack.push(lOperand / rOperand);
        	} else {
        		operatorStack.push(operator);
        		operandStack.push(lOperand);
        		operandStack.push(rOperand);
        	}
        }
        
        while (!operandStack.empty() && !operatorStack.empty()) {            
        	int nextNum = operandStack.pop();        
        	char operator = operatorStack.pop();
            nextNum = operator == '-' ? -nextNum : nextNum;
            finalValue += nextNum;
            //System.out.println("NextNum " + nextNum + " Oper " + operator + " FINAL " + finalValue);        	
        }

        return finalValue;

    }

    public int getInteger(char[] expression) {
    	int value = 0;
    	while ((index < expression.length && expression[index] >= '0' && expression[index] <= '9') || (index < expression.length &&expression[index] == ' ')) {
    		if (expression[index] == ' ') {
                index++;
    			continue;
    		}
    		value *= 10;
    		value += expression[index] - '0';
    		index++;
    	}
    	return value;
    }
}