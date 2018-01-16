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
	int currentDepth = Integer.MAX_VALUE;
	int closestLeaf = 0;

    public int findClosestLeaf(TreeNode root, int k) {
    	TreeNode target = search(root, k);
    	traverse(root, 0);
    	return closestLeaf;
    }

    public void traverse(TreeNode root, int depth) {
    	if (root == null) {
    		return;
    	}
    	if (root.left == null && root.right == null) {
    		if (depth < currentDepth) {
    			currentDepth = depth;
    			closestLeaf = root.val;
    		}
    		return;
     	}

     	traverse(root.left, depth + 1);
     	traverse(root.right, depth + 1);
    }

    public TreeNode search(TreeNode root, int k) {
    	Queue<TreeNode> bfsQueue = new LinkedList<>();
    	bfsQueue.add(root);
    	while (!bfsQueue.isEmpty()) {
    		TreeNode currentNode = bfsQueue.poll();
    		if (currentNode.val == k) {
    			return currentNode;
    		} 
    		if (currentNode.left != null) {
    			bfsQueue.add(currentNode.left);
    		}
    		if (currentNode.right != null) {
    			bfsQueue.add(currentNode.right);
    		}
    	}
    	return null;
    }

}