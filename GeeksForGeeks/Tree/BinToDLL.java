/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* class Node
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}*/
// This function should convert a given Binary tree to Doubly
// Linked List
// root --> Root of Binary Tree
// head --> head of created doubly linked list

//http://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1

class GfG
{
    Node head;
    Node trav;
    boolean isHead = false;
    Node BToDLL(Node root) {
    	traverse(root);
    	return head;
    }

    void traverse(Node root) {

    	if (root == null) {
    		return;
    	} else if (root.left == null && root.right == null) {
    		if (!isHead) {
    			head = root;
    			trav = root;
    			isHead = true;
    		} else {    			
		    	root.left = trav;
		    	root.left.right = root;
		    	trav = root;
    		}
    		return;
    	}
    	if (root.left != null) {
    		traverse(root.left);	
    	}
    	

    	//DO MATH
    	root.left = trav;
    	root.left.right = root;
    	trav = root;

    	if (root.right != null) {
    		traverse(root.right);	
    	}
    	

    }
}