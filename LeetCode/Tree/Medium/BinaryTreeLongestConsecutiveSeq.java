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
    int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
    	traverse(0, root, Integer.MIN_VALUE);
    	return maxLength;   
    }

    public void traverse(int length, TreeNode root, int parent) {
        
    	if (root == null) {
    		return;
    	}        
    	if (root.left == null && root.right == null) {
    		if (oneDiff(root.val, parent) || parent == Integer.MIN_VALUE) {
    			length += 1;
    			maxLength = maxLength < length ? length : maxLength;
    		}	            
    		return;
    	}       


    	if (oneDiff(root.val, parent) || parent == Integer.MIN_VALUE) {
			length += 1;
			maxLength = maxLength < length ? length : maxLength;
		} else {
			length = 1;
		}
        
		traverse(length, root.left, root.val);        
		traverse(length, root.right, root.val);        
    }

    public boolean oneDiff(int a, int b) {
    	return a - b == 1;
    	//return a > b ? a - b == 1 : b - a == 1;
    }
}