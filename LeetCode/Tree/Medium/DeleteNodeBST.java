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
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}       

		TreeNode localRoot = null;
		TreeNode trav = root;


		while (trav != null ) {
			if (key < trav.val) {
				localRoot = trav;
				trav = trav.left; 			
			} else if (key > trav.val) {
				localRoot = trav;
				trav = trav.right;
			} else {
				//Node found;
				//System.out.println("Trav = " + trav.val +  " and its root = " + localRoot.val);
				//	if it is leaf node;
				if (trav.left == null && trav.right == null) {
					//Edge case
					if (localRoot == null) {
						return localRoot;
					} else if (localRoot.left == trav) {
						localRoot.left = null;
					} else if (localRoot.right == trav) {
						localRoot.right = null;
					}
					return root;
				} else if (trav.left == null && trav.right != null) {
					//Exists right Subtree
					//Edge case
					if (localRoot == null) {
						root = root.right;
						return root;
					} else {
						if (localRoot.left == trav) {
							localRoot.left = trav.right;
						} else {
							localRoot.right = trav.right;
						}
						return root;
					}
				} else if (trav.left != null && trav.right == null) {
					//Exists left Subtree
					//Edge case
					if (localRoot == null) {
						root = root.left;
						return root;
					} else {
						if (localRoot.left == trav) {
							localRoot.left = trav.left;
						} else {
							localRoot.right = trav.left;
						}
						return root;
					}
				} else {
					//There exists two subtree
					TreeNode replacementNode = getMinInSubTree(trav.right);
					//This is not called more than once. Replacement Guaranteed to be a leaf;                    
					deleteNode(trav, replacementNode.val);
					if (localRoot == null) {
						replacementNode.left = root.left;
						replacementNode.right = root.right;
						root.left = null;
						root.right = null; 					
						return replacementNode;
					} else {
						if (localRoot.left == trav) {
							localRoot.left = replacementNode;
							replacementNode.left = trav.left;
							trav.left = null;
							replacementNode.right = trav.right;
							trav.right = null;
						} else {
							localRoot.right = replacementNode;
							replacementNode.left = trav.left;
							trav.left = null;
							replacementNode.right = trav.right;
							trav.right = null;
						}
						return root;
					}
				}
			}
		}

		
		return root;
	}

	public TreeNode getMinInSubTree(TreeNode root) {    	
		if (root.left == null && root.right == null) {
			return root;
		}
		TreeNode replacement = root;
		if (root.left != null) {
			replacement = getMinInSubTree(root.left);
		}
		
		return replacement;
	}
}