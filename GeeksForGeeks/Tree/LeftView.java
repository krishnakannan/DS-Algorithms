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
}*/

//http://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1

class GfG
{
    int level = 0;
    void leftView(Node root)
    {
        leftView(root, 1);
    }

    void leftView(Node root, int currentLevel) {

        if (root = null) {
            return;
        }
        
        if (level < currentLevel){
            System.out.print(root.data + " ");    
            level = currentLevel;
        }
        
        if (root.left != null) {
            leftView(root.left, currentLevel + 1);
        } 

        if (root.right != null) {
            leftView(root.right, currentLevel + 1);
        }
    }
}