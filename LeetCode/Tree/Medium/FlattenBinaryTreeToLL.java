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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root);
        TreeNode trav = root;
        trav = trav.left;
        while (trav != null && trav.right != null) {
            trav = trav.right;
        }
        if (trav != null) {
            trav.right = root.right;
            root.right = root.left;
            root.left = null;    
        }
        
    }
    
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.left.left == null && root.left.right == null) {
            root.left.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (root.left != null) {
            traverse(root.left);
        }
        
        TreeNode trav = root;
        trav = trav.left;
        while (trav != null && trav.right != null) {
            trav = trav.right;
        }
        if (trav != null) {
            trav.right = root.right;
            root.right = root.left;
            root.left = null;    
        }
        
        if (root.right != null) {
            traverse(root.right);
        }
    }
}