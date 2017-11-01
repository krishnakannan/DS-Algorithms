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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSum(root);
        return maxSum;
    }

    public int maxSum(TreeNode root) {
    	if (root == null) {
    		return 0;
    	} else if (root.left == null && root.right == null) {
            maxSum = maxSum < root.val ? root.val : maxSum;            
    		return root.val < 0 ? 0 : root.val;
    	}

    	int leftVal = maxSum(root.left);
    	int rightVal = maxSum(root.right);
    	maxSum = maxSum < root.val + leftVal + rightVal ? root.val + leftVal + rightVal : maxSum;
    	return root.val + max(leftVal, rightVal) > 0 ? root.val + max(leftVal, rightVal) : 0;
    }

    int max (int a, int b) {
    	return a > b ? a : b;
	}
}