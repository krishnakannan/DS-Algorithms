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

	/*
		In order to identify the inorder successor we need to travel to the node first.
		Since it is BST we can reach that point in O(Log(n)). 
		We keep track of inorder successor at every level and update it.

		Worst case is height of BST. Worst case is O(N) for skewed trees.
	*/

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode inorderSuccessor = null;

        while (root != null) {
        	if (root.val > p.val) {
        		inorderSuccessor = root;
        		root = root.left;
        	} else {
        		root = root.right;
        	}
        }
        
        if (inorderSuccessor == null) {
            if (root != null) {
                inorderSuccessor = root.right;    
            }
            
        }
        
        return inorderSuccessor;
    }
}