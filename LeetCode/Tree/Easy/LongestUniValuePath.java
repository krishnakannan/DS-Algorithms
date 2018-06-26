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
    
    int maxPath;
    
    public int longestUnivaluePath(TreeNode root) {
        getMaxPath(root);
        return maxPath;
    }
    
    public int getMaxPath(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        if (root.left == null && root.right == null) {
            return 0;
        }
        
        int left = getMaxPath(root.left);
        int right = getMaxPath(root.right);
        int localMax = 0;
        if (left > -1 && root.val == root.left.val) {
            localMax += 1 + left;
        } 
        if (right > -1 && root.val == root.right.val) {
            localMax += 1 + right;
        }
        
        maxPath = localMax > maxPath ? localMax : maxPath;
        if (left > right) {
            if (left > -1 && root.val == root.left.val)  {
                return left + 1;
            } else if (right > -1 && root.val == root.right.val) {
                return right + 1;
            } else {
                return 0;
            }
        } else {
            if (right > -1 && root.val == root.right.val) {
                return right + 1;
            } else if (left > -1 && root.val == root.left.val)  {
                return left + 1;
            } else {
                return 0;
            }
        }
        //return left > right ? left + 1 : right + 1;
        
    }
}