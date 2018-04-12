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
    public TreeNode[] splitBST(TreeNode root, int V) {
		if (root == null) {
			return new TreeNode[]{null, null};
		} else if (root.val <= V) {
			TreeNode[] splits = splitBST(root.right, V);
			root.right = splits[0];
			splits[0] = root;
			return splits;
		} else {
			TreeNode[] splits = splitBST(root.left, V);
			root.left = splits[1];
			splits[1] = root;
			return splits;
		}
    }   
}