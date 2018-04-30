import java.util.*;
import java.lang.*;   
import java.io.*;

class ExpressionAddOperator {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String num = in.next();
		int target = in.nextInt();
		ExpressionAddOperator eao = new ExpressionAddOperator();
		System.out.println(eao.addOperators(num, target));
	}

	/*
		REFERRED FASTER SOLUTION - MATHEMATICAL	

		APPROX - 150 ms	
	*/

	List<String> validExpressions;
    public List<String> addOperators(String num, int target) {
        validExpressions = new ArrayList<>();
        if(num.equals("")) {
            return validExpressions;
        }
        dfs(num, "", 0, target, 0l, 0l);
        return validExpressions;
    }

    public void dfs(String num, String formedExpression, int position, int target, long evaluated, long prev) {    	
    	if (position >= num.length()) {
    		if (evaluated == target) {
    			validExpressions.add(formedExpression);
    		}
    		return;
    	}
        
    	
		for (int i = position; i < num.length(); i++) {            
            String currentString = num.substring(position, i + 1);
            if (currentString.charAt(0) == '0' && currentString.length() > 1) {
                break;  
            } 
            long current = getLong(currentString);
            if (position == 0) {
                dfs(num, formedExpression + currentString, i + 1, target, current, current);
            } else {
                dfs(num, formedExpression + "+" + currentString, i + 1, target, evaluated + current, current);
			    dfs(num, formedExpression + "-" + currentString, i + 1, target, evaluated - current, -current);
			    dfs(num, formedExpression + "*" + currentString, i + 1, target, evaluated - prev + prev * current, prev * current);    
            }
				
		}        
    }

    public long getLong(String expressionString) {    	
        char[] expression = expressionString.toCharArray();
    	long val = 0l;    		
    	for (int i = 0; i < expression.length; i++) {
    		val *= 10;
    		val += expression[i] - '0';
    	}
    	return val;
    }

}



/*
	ACCEPTED SOLUTION - (VERY SLOW) STACK - EXPRESSION EVALUATION BASED SOLUTION
	
	APPROX - 750 ms

	List<String> validExpressions;
    public List<String> addOperators(String num, int target) {
        validExpressions = new ArrayList<>();
        if(num.equals("")) {
            return validExpressions;
        }
        dfs(num, 1, target);
        return validExpressions;
    }

    public void dfs(String expression, int addExpPoint, int target) {
    	long evaluated = evaluate(expression, target)
    	if (addExpPoint >= expression.length()) {
    		if (evaluate == target) {
    			validExpressions.add(expression);
    		} else if (evaluated > target) {
    			return;
    		}
    		return;
    	}
    	if (evaluated == target) {
			validExpressions.add(expression);
		} else if (evaluated > target) {
			return;
		}
		for (int i = addExpPoint; i < expression.length(); i++) {
			dfs(expression.substring(0, i) + "+" + expression.substring(i, expression.length()), i + 2, target);
			dfs(expression.substring(0, i) + "-" + expression.substring(i, expression.length()), i + 2, target);
			dfs(expression.substring(0, i) + "*" + expression.substring(i, expression.length()), i + 2, target);	
		}
		
    }


    public long evaluate(String expressionString, int target) {
    	char[] expression = expressionString.toCharArray();
    	LinkedList<Long> operandQueue = new LinkedList<>();
    	LinkedList<Character> operatorQueue = new LinkedList<>();
    	for (int i = 0; i < expression.length; i++) {
    		if (expression[i] >= '0' && expression[i] <= '9') {    			
    			int j = getNumString(expression, i);
    			if (!isValidNumber(expression, i, j)) {
    				//Numbers starting with 0, 00
    				return target == 0 ? 1 : 0;
    			}
    			long number = getLong(expression, i, j);
    			operandQueue.add(number);
    			i = j;
    		} else if (expression[i] == '*') {
    			i += 1;
    			int j = getNumString(expression, i);
    			if (!isValidNumber(expression, i, j)) {
    				//Numbers starting with 0, 00    			
    				return target == 0 ? 1 : 0;
    			}
    			long number = getLong(expression, i, j);
    			operandQueue.add(operandQueue.pollLast() * number);
    			i = j;
    		} else {
    			operatorQueue.add(expression[i]);    			
    		}
    	}    	
    	long num = operandQueue.poll();    	
    	while (!operatorQueue.isEmpty()) {
    		char operator = operatorQueue.poll();
    		long polledNum = operandQueue.poll();
    		if (operator == '+') {
    			num += polledNum;
    		} else {
    			num = num - polledNum;
    		}
    	}
    	return num;
    }

    public int getNumString(char[] expression, int start) {
    	int end = start;
    	while (end < expression.length) {
    		if (expression[end] >= '0' && expression[end] <= '9') {
    			end++;
    		} else {
    			break;
    		}
    	}	
    	end -= 1;    	
    	return end;
    }

    public boolean isValidNumber(char[] expression, int start, int end) {
    	int index = start;
    	if (expression[index] == '-') {
    		index++;
    		if (expression[index] == '0') {
    			return false;
    		}
    	}
    	if (expression[index] == '0') { 
    		return start == end;
    	}
    	return true;
    }

    public long getLong(char[] expression, int start, int end) {    	
    	long val = 0l;
    	boolean isNegative = false;
    	int i = start;
    	if (expression[start] == '-') {
    		isNegative = true;
    		i += 1;
    	}	
    	for (; i <= end; i++) {
    		val *= 10;
    		val += expression[i] - '0';
    	}
    	return isNegative ? -val : val;
    }
    */