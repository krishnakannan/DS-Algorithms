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
    int diff = 0;
    TreeNode rt = null;
    Boolean rBoolean = true;
    public int findTilt(TreeNode root) {
        int leftVal = 0;
        int rightVal = 0;
        if (rBoolean) {
            rBoolean = false;
            rt = root;
        }
        if (root == null) {
            return 0;
        }
        
        if (root.left == null && root.right == null) {
            return root.val;
        } else {
            leftVal = findTilt(root.left);
            rightVal = findTilt(root.right);
            diff += Math.abs(leftVal - rightVal);
            if (rt.equals(root)) {
                return diff;
            }
            return root.val + (leftVal + rightVal);
        }
    }
}