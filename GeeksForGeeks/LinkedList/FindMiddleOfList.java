// class Node {
//    int data;
//     Node next;
//     Node(int d)  { data = d;  next = null; }
// }
// Function to find middle element a linked list

//http://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1


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