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
    public int countNodes(TreeNode root) {
        int height = leftHeight(root);
        if (root == null) {
            return height;
        }
        int count = power(height - 1) - 1;
        count += countLeaves(root.left, root.right, height - 1);
        return count;
    }
    
    public int countLeaves(TreeNode left, TreeNode right, int height) {
        int maxLeaves = power(height);
        int halfVal = height - 1;
        while (left != null && right != null) {
            if (leftHeight(left) > leftHeight(right)) {
                TreeNode temp = left;
                left = temp.left;
                right = temp.right;
                maxLeaves = maxLeaves - power(halfVal);
                
            } else {
                TreeNode temp = right;
                left = temp.left;
                right = temp.right;
            }
            halfVal--;
        }
        if (left != null && right == null) {
                maxLeaves--;
        }
        return maxLeaves;
    }
    
    public int leftHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + leftHeight(root.left);
    }
    
    /* Function to calculate x raised to the power y in O(logn)*/
    public int power(int x)
    {
        return 1 << x;
    }
    
}