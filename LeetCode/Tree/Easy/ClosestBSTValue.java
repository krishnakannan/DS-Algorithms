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

	double diff = Double.MAX_VALUE;
	int minValue;

    public int closestValue(TreeNode root, double target) {
        inorder(root, target);        
        return minValue;
    }

    public void inorder(TreeNode root, double target) {
    	if (root == null) {
    		return;
    	}                
        
    	if (root.left == null && root.right == null) {
    		if (diff((double)root.val, target) < diff) {
    			minValue = root.val;
    			diff = diff((double)root.val, target);
    		}
    		return;
    	}

    	inorder(root.left, target);
    	if (diff((double)root.val, target) < diff) {
			minValue = root.val;
			diff = diff((double)root.val, target);
		} else {
			return;
		}
		inorder(root.right, target);
    }


    public double diff(double a, double b) {
    	return a > b ? a - b : b - a;
    }
}