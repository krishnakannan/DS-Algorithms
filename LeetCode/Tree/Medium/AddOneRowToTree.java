/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode temp = new TreeNode(v);
            temp.left = root;
            root = temp;
            return root;
        }
        traverse(root, v, d, 1);
        return root;
    }
    
    public void traverse(TreeNode root, int val, int depth, int cDepth) {
        if (root == null) {
            return;
        }
        
        if (cDepth == depth - 1) {
            TreeNode lTemp = new TreeNode(val);
            TreeNode rTemp = new TreeNode(val);
            
                lTemp.left = root.left;
                root.left = lTemp;
            
                rTemp.right = root.right;
                root.right = rTemp;
            
            return;
        }
        
        traverse(root.left, val, depth, cDepth + 1);
        traverse(root.right, val, depth, cDepth + 1);
    }
}