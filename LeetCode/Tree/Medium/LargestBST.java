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
	List<Integer> longestBST = new ArrayList<>();
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
		findLBST(root);
		return longestBST.isEmpty() ? 1 : longestBST.size();
    }

    public List<Integer> findLBST(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<>();
    	}

    	if (root.left == null && root.right == null) {
    		List<Integer> sTree = new ArrayList<>();
    		sTree.add(root.val);            
    		return sTree;
    	}

    	List<Integer> leftTree  = findLBST(root.left);
    	List<Integer> rightTree = findLBST(root.right);        
    	List<Integer> tempBST = new ArrayList<>();
    	if (leftTree != null && rightTree != null && !leftTree.isEmpty() && !rightTree.isEmpty()) {
    		if (root.val > leftTree.get(leftTree.size() - 1) && root.val < rightTree.get(0)) {    			    			
    			tempBST.addAll(leftTree);
    			tempBST.add(root.val);
    			tempBST.addAll(rightTree);
    		} else {
                tempBST =  null;
            }
    	} else if (leftTree != null && !leftTree.isEmpty()) {
    		if (rightTree != null && root.val > leftTree.get(leftTree.size() - 1)) {    			    			
    			tempBST.addAll(leftTree);
    			tempBST.add(root.val);
    		} else {
                tempBST =  null;
            }
    	} else if (rightTree != null && !rightTree.isEmpty()) {
    		if (leftTree != null && root.val < rightTree.get(0)) {    			    			    		
    			tempBST.add(root.val);
    			tempBST.addAll(rightTree);
    		} else {
                tempBST =  null;
            }
    	} else {
            if (leftTree == null || rightTree == null) {
                tempBST = null;
            }
        }

    	if (tempBST != null && tempBST.size() > longestBST.size()) {
    		longestBST.clear();
    		longestBST.addAll(tempBST);
    	}        
    	return tempBST;
    }

 
}