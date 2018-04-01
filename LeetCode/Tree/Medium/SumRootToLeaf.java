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
    int retVal;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getNumbers(root, 0);
        return retVal;
    }
    
    public void getNumbers(TreeNode root, Integer chain) {
        if (root == null) {
                return;
        }
        if (root.left == null && root.right == null) {
            retVal += chain * 10 + root.val;
        }
        
        getNumbers(root.left, chain * 10 + root.val);
        getNumbers(root.right, chain * 10 + root.val);
    }
}