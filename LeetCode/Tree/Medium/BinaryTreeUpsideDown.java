/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Idea is to traverse in post order and create a new tree in pre order. This will create Upside Down Tree

class Solution {
	public TreeNode newRoot;
	public TreeNode trav;

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        traverse(root);
        return newRoot;
    }

    public void traverse(TreeNode root)  {    
        if (root == null) {
            return;   
        }        
        
    	if (root.left == null && root.right == null) {
    		if (newRoot == null) {
    			newRoot = new TreeNode(root.val);
    			trav = newRoot;
    		} else {
    			trav.left = new TreeNode(root.val);
    		}
    		return;
    	}
        traverse(root.left);    
        traverse(root.right);    
        

    	trav.right = new TreeNode(root.val);
    	trav = trav.right;
    }
}
