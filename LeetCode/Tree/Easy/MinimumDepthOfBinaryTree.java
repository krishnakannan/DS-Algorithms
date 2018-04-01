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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = 1 + minDepth(root.left);   
        }
        
        if (root.right != null) {
            rightDepth = 1 + minDepth(root.right);
        }

        return leftDepth < rightDepth ? leftDepth : rightDepth;
    }
}