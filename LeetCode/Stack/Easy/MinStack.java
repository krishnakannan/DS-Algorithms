import java.util.EmptyStackException;
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            minStack.push(x);
        } else {
            if(x <= minStack.peek()) {
                minStack.push(x);
            }
            stack.push(x);
        }
        
    }
    
    public void pop() {
        
        if (!stack.isEmpty()) {
            if (stack.peek().equals(minStack.peek())) {                
                minStack.pop();
                stack.pop();
            } else {                
                stack.pop();
            }
        } else {
            throw new EmptyStackException();
        }
    }
    
    public int top() {
        if (!stack.isEmpty()) {
            return stack.peek();
        } else {
            throw new EmptyStackException();
        }
    }
    
    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            throw new EmptyStackException();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */