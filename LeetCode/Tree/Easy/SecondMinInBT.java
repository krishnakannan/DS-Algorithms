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
    
    long firstMin = Long.MAX_VALUE;
    long secondMin = Long.MAX_VALUE;
    
    public int findSecondMinimumValue(TreeNode root) {
        traverse(root);
        //System.out.println(firstMin + " " + secondMin);
        return secondMin == Long.MAX_VALUE ? -1 : (int)secondMin;
    }
    
    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            if (root.val < firstMin) {
                long temp = firstMin;
                firstMin = root.val;
                secondMin = temp;
            } else if (root.val > firstMin && root.val < secondMin) {
                secondMin = root.val;
            }
            return;
        }
        traverse(root.left);
        if (root.val < firstMin) {
            long temp = firstMin;
            firstMin = root.val;
            secondMin = temp;
        } else if (root.val > firstMin && root.val < secondMin) {
            secondMin = root.val;
        }
        traverse(root.right);
    }
}