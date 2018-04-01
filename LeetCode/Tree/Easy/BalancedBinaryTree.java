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
    
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        traverse(root);
        return balanced;
    }
    
    public void traverse(TreeNode root) {
        if (balanced) {
            
            if (root == null) {
                return;
            } else if (root.left == null && root.right == null) {
                return;
            }
             
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if (Math.abs(leftDepth - rightDepth) > 1) {
                balanced = false;
            }
            traverse(root.left);
            traverse(root.right);
        }
    }
    
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return  1;
        }
        int leftDepth = 1 + maxDepth(root.left);
        int rightDepth = 1 + maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }
}