/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


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
} */

//http://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
class GfG
{
    int height(Node node) 
    {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        }
        return 1 + max(height(node.left), height(node.right));
    }   

    int max (int a, int b) {
        return a > b ? a : b;
    }
}