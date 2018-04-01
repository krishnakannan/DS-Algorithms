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
    
    
    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    int right = 0;
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        return min;
    }
    
    public void traverse (TreeNode root) {
        if (root != null) {
            traverse(root.left);
            if (prev == Integer.MAX_VALUE) {
                prev = root.val;
            } else {
                min = min >= Math.abs(prev - root.val) ? Math.abs(prev - root.val) : min;
                prev = root.val;
            }
            traverse(root.right);
            
            
        }
        
        // System.out.println ("LEFT Min = " + min + " left = " + left + " root " + root.val + " Diff = " + Math.abs(root.val - left));
        //min = min > Math.abs(root.val - left) ?  Math.abs(root.val - left) : min;
    
        // System.out.println ("RIGHT Min = " + min + " right = " + right + " root " + root.val + " Diff = " + Math.abs(root.val - right));
        //min = min > Math.abs(root.val - right) ?  Math.abs(root.val - right) : min;
    
    }
}