/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


// FUNCTION CODE
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
/* Should print vertical order such that each vertical line
    is separated by $ */
    //http://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
class GfG
{
    Map<Integer, List<Integer>> vMap = new TreeMap<>();
    void verticalOrder(Node node) {
        traverse(node, 0);
        for (Map.Entry<Integer, List<Integer>> entry : vMap.entrySet()) {
            List<Integer> column = entry.getValue();
            for (Integer val : column)  {
                System.out.print(val + " ");
            }
            System.out.print("$ ");
        }
    }

    void traverse(Node root, int column) {
        //System.out.print(vMap);
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (!vMap.containsKey(column)) {
                List<Integer> treeColumn = new ArrayList<>();
                treeColumn.add(root.data);
                vMap.put(column, treeColumn);
            } else {
                vMap.get(column).add(root.data);
            }       
            return;     
        }
        if (!vMap.containsKey(column)) {
            List<Integer> treeColumn = new ArrayList<>();
            treeColumn.add(root.data);
            vMap.put(column, treeColumn);
        } else {
            vMap.get(column).add(root.data);
        }            


        if (root.left != null) {
                traverse(root.left, column - 1);
            }

        if (root.right != null) {
            traverse(root.right, column + 1);
        }
    }
}