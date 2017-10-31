/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


//User function Template for Java
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
//http://practice.geeksforgeeks.org/problems/count-leaves-in-binary-tree/1
class GfG
{
    int leavesCount = 0;
    int countLeaves(Node node) {
         traverse(node);
         return leavesCount;
    }

    public void traverse(Node root) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            leavesCount++;
        } else {
            traverse(root.left);
            traverse(root.right);
        }
    }
}
