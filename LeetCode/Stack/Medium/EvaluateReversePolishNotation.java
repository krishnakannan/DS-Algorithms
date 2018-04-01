public class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                Integer o2 = stack.pop();
                Integer o1 = stack.pop();
                int val = 0;
                if (tokens[i].equals("+")) {
                    val = o1 + o2;
                } else if (tokens[i].equals("-")) {
                    val = o1 - o2;
                }  else if (tokens[i].equals("*")) {
                    val = o1 * o2;
                }  else if (tokens[i].equals("/")) {
                    if (o1 == 0 || o2 == 0) {
                        val = 0;
                    } else {
                        val = o1 / o2;    
                    }
                }
                stack.push(val);
                
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        
        return stack.pop();
    }
}