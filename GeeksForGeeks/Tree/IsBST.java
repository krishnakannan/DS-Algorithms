/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*  A Binary Search Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
} */

//http://practice.geeksforgeeks.org/problems/trapping-rain-water/0


class GfG
{
    boolean isValid = true;
    long val = Long.MIN_VALUE;

    int isBST(Node root)  
    {
        isBinSearchTree(root);
        return isValid ? 1 : 0;
    }

    void isBinSearchTree(Node root) {
        if (root == null) {
            return;
        }
        isBinSearchTree(root.left);
        if (val >= root.val) {
            isValid = false;
        } else {
            val = root.val;
        }
        isBinSearchTree(root.right);    
    }
}