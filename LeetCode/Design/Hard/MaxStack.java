class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;
     
    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new Stack<Integer>();
        this.maxStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        
        if (stack.empty()) {
            //If stack is Empty the maxStack should be empty
            stack.push(x);
            maxStack.push(x);
        } else {
            stack.push(x);
            if (!maxStack.empty() && x >= maxStack.peek()) {
                maxStack.push(x);
            } else if (maxStack.empty()) {
                maxStack.push(x);
            }
        }        
    }
    
    public int pop() {
        
        int popped = Integer.MIN_VALUE;
        if (!stack.empty()) {
            popped = stack.pop();
            if (!maxStack.empty() && popped == maxStack.peek()) {
                maxStack.pop();
            }
        }        
        return popped;
    }
    
    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return Integer.MIN_VALUE;
    }
    
    public int peekMax() {
        if (!maxStack.empty()) {
            return maxStack.peek();
        }
        return Integer.MIN_VALUE;
    }
    
    public int popMax() {
        
        if (!maxStack.empty()) {
            int popped = maxStack.pop();
            
            Stack<Integer> tempStack = new Stack<Integer>();
            
            //Find the First Occurence and remove it
            while (stack.peek() != popped) {                
                int sPopped = stack.pop();
                tempStack.push(sPopped);
            }            
            stack.pop();
            
            while (!tempStack.empty()) {
                push(tempStack.pop());
            }
            return popped;
        }
        
        
        return Integer.MIN_VALUE;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */