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
    
    int max = 0;
    boolean isMax = false;
    
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            traverse(root);    
        }
        return root;
    }
    
    public int traverse(TreeNode root) {
        if (root.right != null) {
            traverse(root.right);
        }
        max += root.val;
        if (isMax) {
            root.val = max;
        }
        isMax = true;
        if (root.left != null) {
            traverse(root.left);
        }
        
        
        
        return 0;
     }
    
}