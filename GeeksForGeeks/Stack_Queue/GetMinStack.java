/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

//http://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

class GfG
{
    int minEle;
    Stack<Integer> s;
    Stack<Integer> minStack;
    /*returns min element from stack*/
    int getMin()
    {
        if (minStack != null && !minStack.empty()) {
            return minStack.peek();
        } else {
            return -1;
        }
    }
    
    /*returns poped element from stack*/
    int pop()
    {   int retVal;
        if (s!= null && minStack != null && !s.empty()) {
            if (s.peek() == minStack.peek()) {
                minStack.pop();
            }
            retVal = s.pop();    
        } else {
            retVal = -1;
        }
        
        return retVal;
    }
    /*push element x into the stack*/
    void push(int x)
    {
        if (s == null) {
            s = new Stack<>();
            minStack = new Stack<>();
        }
        if (s.empty()) {
            s.push(x);
            minStack.push(x);
        } else {
            s.push(x);
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }	
}