/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Structure of node
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}
*/

//http://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1
class GfG
{
    int getNthFromLast(Node head, int n) {
    	Node trav = head;
		while (--n > 0 && trav != null) {
			trav = trav.next;
		}
		if (trav == null && n == 0) {
			return -1;
		} 

		Node prev = head;
		while (trav.next != null) {
			trav = trav.next;
			prev = prev.next;
		}

		return prev.data;
    }
}
	