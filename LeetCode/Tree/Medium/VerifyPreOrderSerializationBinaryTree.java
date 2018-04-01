public class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] poArr = preorder.split(",");
        Stack<String> stack = new Stack<>();            
        for (int i = 0; i < poArr.length; i++) {
        	// System.out.println("Processing the element. = " + poArr[i]);
        	// if (!stack.empty()) {
        	// 	System.out.println("Here stack.peek() = " + stack.peek());	
        	// }
    		if (poArr[i].equals("#")) {
    			if (!stack.empty()) {    				
    				if (stack.peek().equals("#")) {
    					if (!stack.empty()) {
    						stack.pop();
    					} else {
    						return false;
    					}
    					if (!stack.empty()) {
    						stack.pop();
    					} else {
    						return false;
    					}
    					i--;
    				} else {
    					stack.push(poArr[i]);	
    				}
    			} else {
    				stack.push(poArr[i]);
    			}
    		} else {
    			stack.push(poArr[i]);
    		}        
        }

        if (stack.empty()) {
        	return false;
        } else {
        	String val = stack.pop();
        	if (stack.empty() && val.equals("#")) {
        		return true;
        	} else {
        		return false;
        	}
        }
    }
}