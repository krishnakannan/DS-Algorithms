/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Node is defined as 
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/
class GfG
{
	int detectLoop(Node head) {
		Node slowPtr = head;
		Node fastPtr;
		if (head.next != null) {
			 fastPtr = head.next.next;	   	
		} else {
			return 0;
		}

		while (fastPtr != null && fastPtr.next != null) {
			if (slowPtr == fastPtr) {
				return 1;
			} else {
				slowPtr = slowPtr.next;
				if (fastPtr.next != null) {
					fastPtr = fastPtr.next.next;
				}
			}
		}
		return 0;
	}
}