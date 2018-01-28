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
    int leavesSize;
    TreeNode origRoot;
    boolean isRoot = false;
    public List<List<Integer>> findLeaves(TreeNode root) {
        origRoot = root;
        List<List<Integer>> leavesList = new ArrayList<>();
        
    	while (root != null && !isRoot) {
    		List<Integer> leaves = getLeaves(root, new ArrayList<>());            
    		leavesList.add(leaves);    		
    	}
    	return leavesList;
    }

    public List<Integer> getLeaves(TreeNode root, List<Integer> leaves) {

    	if (root.left == null && root.right == null) {
    		leaves.add(root.val);
    		if (root == origRoot) {
                isRoot = true;
            }
    		return leaves;
    	}
    	leavesSize = leaves.size();
    	if (root.left != null) {
    		getLeaves(root.left, leaves);	
    		if (leavesSize < leaves.size()) {
	    		root.left = null;
	    		leavesSize = leaves.size();
	    	}
    	}    	
    	if (root.right != null) {
    		getLeaves(root.right, leaves);    	
    		if (leavesSize < leaves.size()) {
	    		root.right = null;
	    		leavesSize = leaves.size();
	    	}
    	}    	
        
        return leaves;
    }
}