/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/
//http://practice.geeksforgeeks.org/problems/stack-using-two-queues/1
class GfG
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
        if (q1.size() == 1) {
            return q1.poll();
        } else {
            while(q1.size() > 1) {
                q2.add(q1.poll());
            }
            if (q1.peek() == null) {
                return -1;
            }
            int retVal = q1.poll();
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return retVal;
        }
    }
    
    /* The method push to push element into the stack */
    void push(int a)
    {
       q1.add(a);
    }
}