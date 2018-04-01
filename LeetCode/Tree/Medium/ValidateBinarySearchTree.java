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
    boolean isValid = true;
    long val = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        traverse(root);
        return isValid;    
    }
    
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (val >= root.val) {
            isValid = false;
        } else {
            val = root.val;
        }
        traverse(root.right);
    }
}