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

	
	int maxDepth = 0;
	boolean firstLeftLeaf = false;
	boolean firstRightLeaf = false;

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
    	List<Integer> boundaryList = new ArrayList<>();
        if (root == null) {
            return boundaryList;
        }
    	boundaryList.add(root.val);
        List<Integer> leftList = travLeft(root.left, 1, new ArrayList<>());
    	boundaryList.addAll(leftList);
    	maxDepth = 0;       
        List<Integer> rightList = travRight(root.right, 1, new ArrayList<>());
        Collections.reverse(rightList);
        boundaryList.addAll(rightList);   
    	return boundaryList;
    }

    public List<Integer> travLeft(TreeNode root, int depth, List<Integer> list) {    	
    	if (root == null) {
    		return list;
    	}
    	if (root.left == null && root.right == null) {
    		if (!firstLeftLeaf) {
    			firstLeftLeaf = true;
    		}
    		list.add(root.val);
    		if (depth > maxDepth) {	    		
	    		maxDepth = depth;
	    	}
    		return list;
    	}

    	if (depth > maxDepth && ! firstLeftLeaf) {
    		list.add(root.val);
    		maxDepth = depth;
    	}
    	travLeft(root.left, depth + 1, list);
    	travLeft(root.right, depth + 1, list);
    	return list;
    }

    public List<Integer> travRight(TreeNode root, int depth, List<Integer> list) {    	
    	if (root == null) {
    		return list;
    	}

    	if (root.left == null && root.right == null) {
    		list.add(root.val);
    		if (!firstRightLeaf) {
    			firstRightLeaf = true;
    		}
    		if (depth > maxDepth) {	    		
	    		maxDepth = depth;
	    	}
    		return list;
    	}

    	if (depth > maxDepth && !firstRightLeaf) {
    		list.add(root.val);
    		maxDepth = depth;
    	}
    	travRight(root.right, depth + 1, list);
    	travRight(root.left, depth + 1, list);

    	return list;
    }
}	