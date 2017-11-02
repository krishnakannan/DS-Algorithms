/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/

//http://practice.geeksforgeeks.org/problems/queue-using-two-stacks/1

class GfG
{
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    /* The method insert to push element into the queue */
    void insert(int B)
    {
        s1.push(B);
    }
	
    int remove()
    {
	   if (s2.empty() && s1.empty()) {
            return -1;
       } else if (s2.empty()) {
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
       } else {
            return s2.pop();
       }
    }
}