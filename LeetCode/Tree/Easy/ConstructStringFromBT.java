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
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        } else if (t.left == null && t.right == null) {
            return "" + t.val;
        } else {
            String formed = form(t);
            return formed.substring(1, formed.length() - 1);
        }
    }
    
    public String form(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        if (root.left == null && root.right == null) {
            return "(" + root.val + ")";
        }
        
        String parsed = "(";
        parsed = parsed + "" + root.val;
        if (root.left == null) {
            parsed += "()";
        } else {
            parsed += form(root.left);
        }
        
        if (root.right != null) {
            parsed += form(root.right);
        }
        parsed += ")";
        return parsed;
    }
}