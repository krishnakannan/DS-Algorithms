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
    boolean isSame = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        traverse(p, q);
        return isSame;
    }
    
    public void traverse(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return;
        } else if (p == null || q == null) {
            isSame = false;
            return;
        } else if (p.left == null && q.left == null && p.right == null && q.right == null && p.val != q.val) {
            isSame = false;
            return;
        }
        
        traverse(p.left, q.left);
        if (p.val != q.val) {
            isSame = false;
        }
        traverse(p.right, q.right);
        if (p.val != q.val) {
            isSame = false;
        }
        
    }
}