/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
//http://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
class GfG
{
    int diameter = 0;
   /* Complete the function to get diameter of a binary tree */
    int diameter(Node node) {
        if (node == null) {
            return 0;
        }
        getHeight(node);
        return diameter;    
    }

    int getHeight(Node root) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 0;
        }
        if (root.left != null) {
            leftHeight = 1 + getHeight(root.left);    
        } 
        if (root.right != null) {
            rightHeight = 1 + getHeight(root.right);    
        }
        diameter = diameter > (1 + leftHeight + rightHeight) ? diameter : (1 + leftHeight + rightHeight);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}
