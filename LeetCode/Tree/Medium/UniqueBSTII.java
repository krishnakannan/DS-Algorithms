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
    public List<TreeNode> generateTrees(int n) {
 		
		List<TreeNode> bstList = generateBST(n);
		return bstList;
    }

    public List<TreeNode> generateBST(int n) {
        
        if (n == 0) {
            List<TreeNode> generated = new ArrayList<>();
            return generated;
        }
        
    	if (n == 1) {
    		TreeNode node = new TreeNode(1);
    		List<TreeNode> generated = new ArrayList<>();
    		generated.add(node);
    		return generated;
    	}


    	List<TreeNode> prevBSTs = generateBST(n - 1);
    	TreeNode currentNode = new TreeNode(n);
    	List<TreeNode> nextLevel = new ArrayList<>();
    	for (TreeNode bst : prevBSTs) {
    		generateNextLevel(bst, null, bst, currentNode, nextLevel);
    	}

    	return nextLevel;

    }

    public List<TreeNode> generateNextLevel(TreeNode root, TreeNode source, TreeNode target, TreeNode currentNode, List<TreeNode> currentList) {
    	if (target == null) {
    		source.right = currentNode;
    		TreeNode duplicate = cloneTree(root);
    		currentList.add(duplicate);
    		source.right = target;
    		return currentList;
    	}


    	if (source == null) {
    		currentNode.left = root;
    		TreeNode duplicate = cloneTree(currentNode);
    		currentList.add(duplicate);
    		currentNode.left = null;
    		return generateNextLevel(root, target, target.right, currentNode, currentList);
    	}

    	currentNode.left = target;
    	source.right = currentNode;
    	TreeNode duplicate = cloneTree(root);
    	currentList.add(duplicate);
    	source.right = currentNode.left;
    	currentNode.left = null;
		return generateNextLevel(root, target, target.right, currentNode, currentList);
    }


    public TreeNode cloneTree(TreeNode original) {
    	if (original == null) {
    		return null;
    	}
    	TreeNode duplicate = new TreeNode(original.val);
    	duplicate.left = cloneTree(original.left);
    	duplicate.right = cloneTree(original.right);
    	return duplicate;
    }
}