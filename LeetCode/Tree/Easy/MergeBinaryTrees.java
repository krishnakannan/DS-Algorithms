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

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return merge(t1,t2, null);
    }
    
    public TreeNode merge(TreeNode t1, TreeNode t2, TreeNode root) {
        if (t1 == null && t2 == null) {
            return null;
        }
        
        if (t1 == null && t2 != null) {
            root = new TreeNode(t2.val);
            root.left = merge(t1, t2.left, root.left);
            root.right = merge(t1, t2.right, root.right);
        } else if (t1 != null && t2 == null) {
            root = new TreeNode(t1.val);
            root.left = merge(t1.left, t2, root.left);
            root.right = merge(t1.right, t2, root.right);
        } else {
            root = new TreeNode(t1.val + t2.val);
            root.left = merge(t1.left, t2.left, root.left);
            root.right = merge(t1.right, t2.right, root.right);
        }        
        return root;
    }
}