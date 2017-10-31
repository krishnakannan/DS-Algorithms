/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* A Binary Search Tree node */
/* class Node
{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
//http://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
class GfG
{   
    Node lca(Node node, int n1, int n2) {
        Node root = node;
        while (root != null) {
            if (root.data >= n1 && root.data <= n2) {
                return root;
            }
            if (root.data > n1 && root.data > n2) {
                root = root.left;
            } else if (root.data < n1 && root.data < n2){
                root = root.right;
            } else {
                break;
            }
        }

        return root;
    }
    
}