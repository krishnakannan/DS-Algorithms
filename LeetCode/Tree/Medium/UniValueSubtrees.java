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
    
    int count = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        traverse(root);
        return count;
    }

    public boolean traverse(TreeNode root) {

    	if (root == null) {
    		return true;
    	}

    	if (root.left == null && root.right == null) {
            count++;
    		return true;
    	}


    	boolean left = traverse(root.left);
    	boolean right = traverse(root.right);
    	boolean isUniValue = true;

    	if (root.left != null) {
    		isUniValue = isUniValue && (root.val == root.left.val);
    	}
		
    	if (root.right != null) {
    		isUniValue = isUniValue && (root.val == root.right.val);
    	}
    
        if (left && right && isUniValue) {
            count++;
        }
        
		return left && right && isUniValue;

    }
}