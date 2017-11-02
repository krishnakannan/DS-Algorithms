/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


// A Binary Tree node
/* class Node
{
    int data;
    Node left, right, nextRight;
    Node(int item)
    {
        data = item;
        left = right = nextRight = null;
		
    }
} */

//http://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
class GfG
{
    Queue<Node> q1 = new LinkedList<>();
    Queue<Node> q2 = new LinkedList<>();
    void connect(Node root) {        
        q1.add(root);
        if (root != null) {
            root.nextRight = null;    
        }    
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (q2.isEmpty()) {
                while (!q1.isEmpty()) {
                    Node temp = q1.poll();                
                    if (q1.isEmpty()) {
                        temp.nextRight = null;
                    } else {
                        temp.nextRight = q1.peek();
                    }
                    if (temp.left != null) {
                        q2.add(temp.left);    
                    } 

                    if (temp.right != null) {
                        q2.add(temp.right);    
                    }
                }
            } else if (q1.isEmpty()) {
                while (!q2.isEmpty()) {
                    Node temp = q2.poll();                
                    if (q2.isEmpty()) {
                        temp.nextRight = null;
                    } else {
                        temp.nextRight = q2.peek();
                    }
                    if (temp.left != null) {
                        q1.add(temp.left);    
                    } 

                    if (temp.right != null) {
                        q1.add(temp.right);
                    }
                }
            } 
        }
    }
}