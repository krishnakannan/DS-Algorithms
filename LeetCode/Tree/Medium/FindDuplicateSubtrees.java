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


	Set<String> subTrees;
	Map<String, TreeNode> duplicateMap;
	List<TreeNode> duplicates;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        subTrees = new HashSet<>();
        duplicateMap = new HashMap<>();
        duplicates = new ArrayList<>();
		postOrder(root);
        //System.out.println(subTrees);

		for (Map.Entry<String, TreeNode> entry : duplicateMap.entrySet()) {
			duplicates.add(entry.getValue());
		}

        return duplicates;
    }

    public String postOrder(TreeNode root) {
    	if (root == null) {
    		return "#";
    	}

    	if (root.left == null && root.right == null) {
    		String str = "L" + Integer.toString(root.val) + "R";
    		if (subTrees.contains(str)) {
    			duplicateMap.put(str, root);
    		}
    		subTrees.add(str);
    		return str;
    	}

    	String leftSubTree = postOrder(root.left);
    	String rightSubTree = postOrder(root.right);
        int rVal = 0;
        if (root.left != null) {
            rVal += root.left.val;
        }
        
        if (root.right != null) {
            rVal += root.right.val;
        }
        
        rVal += root.val;
        
    	String currentTree = "|" + leftSubTree + "L" + rVal + "R" + rightSubTree + "|";        	
    	
    	if (subTrees.contains(currentTree)) {
			duplicateMap.put(currentTree, root);
		}    	
		
		subTrees.add(currentTree);

		return currentTree;
    }   
}