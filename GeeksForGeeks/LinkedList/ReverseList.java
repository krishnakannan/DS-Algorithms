  /* Return reference of new head of the reverse linked list 
 class Node {
     int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
} */
  // This function should reverse linked list and return
   // head of the modified linked list.

//http://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1

   Node reverse(Node head)
   {
		Node p1 = null;
    	Node p2 = head;
    	Node p3 = null;
    	if (p2 != null) {
    			p3 = p2.next;	
    	}
    	while (p2 != null) {
    		p2.next = p1;
    		p1 = p2;
    		p2 = p3;
    		if (p2 != null) {
    			p3 = p2.next;	
    		}
    	}
    	return p1;
   }
