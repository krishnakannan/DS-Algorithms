//This solution, also works for numbers which have more than one digit.

class Solution {

	Stack<String> stack = new Stack<>();
	int index;
    public String parseTernary(String expression) {
        char[] expressionArray = expression.toCharArray();
        index = expressionArray.length - 1;
        while (index >= 0) {            
        	String nextElement = getNextElement(expressionArray);
            if (!nextElement.isEmpty()) {
                stack.push(nextElement);    
            }            
            //printStack();
        	if (expressionArray[index] == '?') {
        		char condition = expressionArray[--index];                                
        		if (condition == 'T') {
        			String left = stack.pop();
        			String right = stack.pop();
        			stack.push(left);
        		} else {
        			String left = stack.pop();
        			String right = stack.pop();
        			stack.push(right);
        		}        
                //printStack();
        	}
            index--;
        }
        return stack.pop();
    }

    public String getNextElement(char[] expression) {
    	StringBuilder sBuilder = new StringBuilder();
    	while (index >= 0) {
    		if (expression[index] != ':' && expression[index] != '?') {
    			sBuilder.append(expression[index]);
    			index--;
    		} else {
                break;
            }
    	}
    	return sBuilder.reverse().toString();
    }
    
    public void printStack() {
        System.out.println(Arrays.toString(stack.toArray()));
    }
}