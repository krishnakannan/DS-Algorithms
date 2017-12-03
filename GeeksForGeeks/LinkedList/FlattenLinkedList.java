/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1

class GfG
{
    Node flatten(Node root) {
		while (root.next != null) {
			root = merge(root, root.next);
		}
		return root;
    }

    Node merge(Node head1, Node head2) {
    	if (head1 == null) {
    		return head2;
    	}
    	if (head2 == null) {
    		return head1;
    	}
    	Node trav1;
    	Node trav2;
    	Node head;
    	if (head1.data < head2.data) {
    		head = head1;
			trav1 = head1;
    		trav2 = head2;    	
    	} else {
    		head = head2;
    		trav2 = head1;
    		trav1 = head2;    	
    	}
    	
    	while (trav1 != null && trav2 != null) {    		 
    		if (trav1.bottom != null && trav1.bottom.data <= trav2.data) {
    			trav1 = trav1.bottom;
    		} else {
    			Node temp = trav1.bottom;
    			trav1.bottom = trav2;
    			trav1 = trav2;
    			trav2 = trav2.bottom;    			
    			trav1.bottom = temp;
    		}    		
    	}    	

    	if (trav1 == null && trav2 != null) {
    		trav1 = head1;
    		while (trav1.bottom != null){
    			trav1 = trav1.bottom;
    		}	
    		trav1.bottom = trav2;
    	}
    	
    	if (head1.data < head2.data) {
    		head1.next = head2.next;    	
    	}
    	
    	return head;
    }

    public void print(Node head) {
    	Node trav = head;
    	while (trav != null) {
    		System.out.print(trav.data + "->");
    		trav = trav.bottom;
    	}
    	System.out.println();
    }
}