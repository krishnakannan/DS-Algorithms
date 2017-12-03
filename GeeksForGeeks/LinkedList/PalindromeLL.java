/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Structure of class Node is
class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/

//https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1

class GfG {	
	Node head = null;
    boolean isPalindrome(Node oHead) {
    	head = oHead;
    	if (head.next == null) {
    		return true;
    	}
    	return checkPalindrome(head.next);
    }    

    boolean checkPalindrome(Node trav) {    	
    	if (head == trav && trav.next == null) {    		
    		return true;
    	}
    	if (trav.next == null) {    		    		
    		if (head.data == trav.data) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	boolean isPalindrome = checkPalindrome(trav.next);   	
    	head = head.next;    	
    	if (head.data == trav.data) {    			
    			return isPalindrome && true;
    		} else {
    			return isPalindrome && false;
    		}
    }
}