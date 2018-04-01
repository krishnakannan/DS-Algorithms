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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root, false);
        return sum;
    }
    
    public void traverse(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null && isLeft) {
            sum += root.val;
        }
        
        traverse(root.left, true);
        traverse(root.right, false);
    }
}