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
    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        traverse(root, 0, sum);
        return hasPath;
    }
    
    public void traverse(TreeNode root, int val, int sum) {
        if (root.left == null && root.right == null) {
            if (root.val + val == sum) {
                hasPath = true;
            }
            return;
        }
        if (root.left != null) {
            traverse(root.left, val + root.val, sum);    
        }
        
        if (root.right != null) {
            traverse(root.right, val + root.val, sum);
        }
        
    }
}