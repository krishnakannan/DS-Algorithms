/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
The structure of the node of the queue is
class QueueNode
{
	int data;
	QueueNode next;
}
and the structure of the class is
class Queue_using_LinkedList
{
	QueueNode front;
	QueueNode rear;
}
*/

//http://practice.geeksforgeeks.org/problems/implement-queue-using-linked-list/1


class GfG
{
	
    /* The method push to push element into the queue*/
	void push(int a, Queue_using_LinkedList ob) {
		//Empty
		QueueNode node = new QueueNode();
		node.data = a;
		if (ob.front == null && ob.rear == null) {			
			ob.front = node;
			ob.rear = node;
		} else {
			node.next = ob.rear;
			ob.rear = node;
		}
	}
        
	/*The method pop which return the element poped out of the queue*/
	int pop(Queue_using_LinkedList ob)
	{	
		if (ob.front == null && ob.rear == null) {
			return -1;
		} else if (ob.rear == ob.front) {
			int ret = ob.front.data;
			ob.front = null;
			ob.rear = null;
			return ret;
		} else {			
			int ret = ob.front.data;
			QueueNode trav = ob.rear;
			while (trav.next != ob.front) {
				trav = trav.next;				
			}			
			ob.front = trav;
			return ret;
		}
	}
}