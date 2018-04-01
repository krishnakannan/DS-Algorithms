public class MyQueue {
    
    Stack pushStack;
    Stack popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.pushStack = new Stack();
        this.popStack = new Stack();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        return (int)popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (popStack.empty()) {
            while (!pushStack.empty()) {
                popStack.push(pushStack.pop());
            }
        }
        return (int)popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (pushStack == null && popStack == null) || (pushStack.empty() && popStack.empty());
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */