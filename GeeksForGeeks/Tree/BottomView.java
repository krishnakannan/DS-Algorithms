/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* Tree node class
class Node {
    int data; //data of the node
    int hd; //horizontal distance of the node
    Node left, right; //left and right references
    public Node(int key)
    {
        data = key;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}*/

//http://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

class GfG
{
    Map<Integer,Integer> map = new TreeMap<>();
    int printedColumn = Integer.MIN_VALUE;
    public void bottomView(Node root) {
        traverse(root, 0);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.print(entry.getValue() + " ");
        }
    }

    public void traverse(Node root, int column) {
        
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
                printedColumn = column;
                map.put(column, root.data);
        }
        if (root.left != null) {
            traverse(root.left, column - 1);    
        } 
        
        
        printedColumn = column;
        map.put(column, root.data);

        if (root.right != null) {
            traverse(root.right, column + 1);    
        }
        
    }
}
