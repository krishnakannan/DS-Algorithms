/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Integer minimum = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int minDiffInBST(TreeNode root) {
        traverse(root);
        return minimum;
    }
    
    public void traverse(TreeNode root) {
        
        if (root == null) { 
            return;
        }
        
        if (root.left == null && root.right == null) {
            if (prev == null) {
                prev = root.val;
            } else {
                minimum = minimum > (root.val - prev) ? (root.val - prev) : minimum;
                prev = root.val;
            }
            return;
        }
        
        traverse(root.left);        
        if (prev == null) {
            prev = root.val;
        } else {
            minimum = minimum > (root.val - prev) ? (root.val - prev) : minimum;
            prev = root.val;
        }
        traverse(root.right);
    }
}