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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getHeight(root);
        return diameter;
    }
    
    public int getHeight(TreeNode root) {
        int leftHeight = 0;
        int rightHeight = 0;
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 0;
        }
        if (root.left != null) {
            leftHeight = 1 + getHeight(root.left);    
        } 
        if (root.right != null) {
            rightHeight = 1 + getHeight(root.right);    
        }
        diameter = diameter > (leftHeight + rightHeight) ? diameter : (leftHeight + rightHeight);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}