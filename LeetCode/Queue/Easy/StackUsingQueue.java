public class MyStack {

    Queue<Integer> popQueue;
    Queue<Integer> elementsQueue;

    /** Initialize your data structure here. */
    public MyStack() {
        popQueue = new LinkedList<>();
        elementsQueue = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        popQueue.add(x);
        if (popQueue.size() > 1) {
            elementsQueue.add(popQueue.poll());    
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int val = 0;
        int size = elementsQueue.size();
        if (!popQueue.isEmpty()) {
            val = popQueue.poll();
            rearrange();
        } else {
            rearrange();
            val = popQueue.poll();
            rearrange();
        }
        return val;
    }
    
    public void rearrange() {
        int size = elementsQueue.size();
        for (int i = 0; i < size; i++) {
            push(elementsQueue.poll());
        }
    }
    
    /** Get the top element. */
    public int top() {
        int val = 0;
        int size = elementsQueue.size();
        if (!popQueue.isEmpty()) {
            val = popQueue.peek();
        } else {
            rearrange();
            val = popQueue.peek();
        }
        return val;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        System.out.println("PopQueue" + popQueue + " ElementsQueue = " + elementsQueue );
        return popQueue.isEmpty() && elementsQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */