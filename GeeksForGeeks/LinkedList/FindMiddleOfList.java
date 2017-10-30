// class Node {
//    int data;
//     Node next;
//     Node(int d)  { data = d;  next = null; }
// }
// Function to find middle element a linked list
   int getMiddle(Node head)
   {
   		Node slowPtr = head;
   		Node fastPtr = head;

   		while (fastPtr != null) {   			
   			if (fastPtr.next != null) {
   				slowPtr = slowPtr.next;
   				fastPtr = fastPtr.next.next;	
   			} else {
   				fastPtr = fastPtr.next;
   			}   			
   		}

   		return slowPtr.data;
   }