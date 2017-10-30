/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete The function
Node is as follows:
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/
class GfG{
	 int removeTheLoop(Node node) {
	 	Node slowPtr = node;	 	
		Node fastPtr;
		if (node.next != null)  {
			fastPtr = node.next.next;	   	
		} else {
			return 1;
		}

		while (fastPtr != null && fastPtr.next != null) {
			if (slowPtr == fastPtr) {
				slowPtr = node;
				fastPtr = fastPtr.next.next;
				break;
			} else {
				slowPtr = slowPtr.next;
				if (fastPtr.next != null) {
					fastPtr = fastPtr.next.next;
				}
			}
		}

		while (slowPtr.next != fastPtr.next) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next;
		}
		fastPtr.next = null;
		return 1;
	}
}