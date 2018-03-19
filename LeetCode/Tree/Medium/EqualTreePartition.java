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

	int totalValue = 0;
	boolean canPartition = false;

    public boolean checkEqualTree(TreeNode root) {
        count(root);
        traverse(root, true);
        return canPartition;
    }

    //Simple Pre Order
    public void count(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null) {
    		totalValue += root.val;
    		return;
    	}
    	totalValue += root.val;
    	count(root.left);
    	count(root.right);
    }

    //Post Order

    public int traverse(TreeNode root, boolean isRoot) {

    	if (root == null) {
    		return 0;
    	}

    	if (root.left == null && root.right == null) {
    		int restOfTree = totalValue - root.val;
    		if (restOfTree == root.val && !isRoot) {
    			canPartition = true;
    		}
    		return root.val;
    	}

        int leftVal = 0;
        int rightVal = 0;
    	if (!canPartition) {
            leftVal = traverse(root.left, false);
    		rightVal = traverse(root.right, false);	
    	}
    	

    	int subTreeVal = leftVal + rightVal + root.val;
    	int restOfTree = totalValue - subTreeVal;

    	if (restOfTree == subTreeVal && !isRoot) {
    		canPartition = true;
    	}

    	return subTreeVal;
    }

}