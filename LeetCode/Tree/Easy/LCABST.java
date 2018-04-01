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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        
        while (root != null) {
            if (root.val > pVal && root.val > qVal) {
                root = root.left;   
            } else if (root.val < pVal && root.val < qVal) {
                root = root.right;
            } else {
                return root;
            }
        }
        
        return root;
    }
}