/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
The structure of the node of the stack is
class StackNode
{
	int data;
	StackNode next;
}
class Stack_using_LinkedList
{
	 StackNode top;
}
*/
// This is method only submission

//http://practice.geeksforgeeks.org/problems/implement-stack-using-linked-list/1
class GfG
{
	StackNode start = null;
	/* The method push to push element into the stack */
	void push(int a,Stack_using_LinkedList ob) {
		StackNode node = new StackNode();
		node.data = a;
		if (ob.top == null)	{
			ob.top = node;
			start = node;			
		} else {
			ob.top.next = node;
			ob.top = node;
		}
	}

	/*The method pop which return the element poped out of the stack*/
	int pop(Stack_using_LinkedList ob) {
		if (ob.top == null) {
			return -1;
		} else if (start == ob.top) {
			int ret = ob.top.data;
			ob.top = null;
			start = null;
			return ret;
		} else {
			StackNode trav = start;
			int ret = ob.top.data;
			while (trav.next != ob.top) {
				trav = trav.next;
			}
			ob.top = trav;
			return ret;
		}
	}
	
}
