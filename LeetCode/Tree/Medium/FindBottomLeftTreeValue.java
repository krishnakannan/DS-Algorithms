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
    int leftVal = 0;
    int rightVal = 0;
    int leftMax = Integer.MIN_VALUE;
    int rightMax = Integer.MIN_VALUE;
    public int findBottomLeftValue(TreeNode root) {
        leftVal = root.val;
        traverse(root, 1, true);
        return leftMax >= rightMax ? leftVal : rightVal;
    }
    
    public void traverse(TreeNode root, int val, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            if (val > leftMax) {
                leftMax = val;
                leftVal = root.val;
            }
            return;
        } else if (root.left == null && root.right == null && !isLeft) {
            if (val > rightMax) {
                rightMax = val;
                rightVal = root.val;
            }
        }
        traverse(root.left, val + 1, true);
        traverse(root.right, val + 1, false);
    }
}