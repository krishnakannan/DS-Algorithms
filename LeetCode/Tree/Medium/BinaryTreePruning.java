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
    public TreeNode pruneTree(TreeNode root) {
 		boolean hasChildren = traverse(root);
 		if (!hasChildren) {
 			return null;
 		}	       
 		return root;
    }

    public boolean traverse(TreeNode root) {

    	if (root == null) {
    		return false;
    	}

    	if (root.left == null && root.right == null) {
    		return root.val == 1;
    	}

    	boolean hasLeft = traverse(root.left);
    	boolean hasRight = traverse(root.right);
    	if (!hasLeft) {
    		root.left = null;
    	}
    	if (!hasRight) {
    		root.right = null;    		
    	}

    	return root.val == 1 || hasLeft || hasRight;
    }
}