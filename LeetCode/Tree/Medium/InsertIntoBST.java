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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        
        traverse(root, val);
        return root;
    }
    
    public void traverse(TreeNode root, int val) {
        if (root == null) {
            return;
        }        
        if (root.left == null && root.right == null) {
            TreeNode newNode = new TreeNode(val);
            if (root.val > val) {
                root.left = newNode;
            } else {
                root.right = newNode;
            }
            return;
        }
        
        if (root.val > val) {
            if (root.left == null) {
                root.left = new TreeNode(val);   
            } else {
                traverse(root.left, val);    
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);   
            } else {
                traverse(root.right, val);    
            }
        }
    }
}