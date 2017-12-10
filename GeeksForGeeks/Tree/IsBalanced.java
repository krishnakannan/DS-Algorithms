/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */

//http://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1

class GfG
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false.  Time complexity should
     be O(n) where n is number of nodes in tree */
    boolean isBalanced = true;
    boolean isBalanced(Node root) {
    	getMaxDepth(root);
    	return isBalanced;
    }

    int getMaxDepth(Node root) {
    	if (!isBalanced) {
    		return 0;
    	}
    	if (root == null) {
    		return 0;
    	}
    	if (root.left == null && root.right = null) {
    		return 1;
    	}

    	int leftDepth = getMaxDepth(root.left);
    	int rightDepth = getMaxDepth(root.right);
    	if (diff(leftDepth, rightDepth) > 1) {
    		isBalanced = false;
    	}
    	return 1 + max(leftDepth, rightDepth);
    }

    int max(int a, int b) {
    	return a > b ? a : b;
    }

    int diff(int a, int b) {
    	return a > b ? a - b : b - a;
    }
}
