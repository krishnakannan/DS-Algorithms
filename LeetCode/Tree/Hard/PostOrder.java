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
    public List<Integer> postorderTraversal(TreeNode root) {
 		List<Integer> postOrderList = new ArrayList<>();
 		if (root == null) {
 			return postOrderList;
 		}
 		Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
 		stack.push(root);

    	while (!stack.isEmpty()) {
    		TreeNode currentNode = stack.pop();
    		if ((currentNode.left == null && currentNode.right == null)) {
    			postOrderList.add(currentNode.val);
                visited.add(currentNode);
    		} else if (currentNode.left != null && currentNode.right != null && visited.contains(currentNode.left) && visited.contains(currentNode.right)) {
                postOrderList.add(currentNode.val);
                visited.add(currentNode);
            } else if (currentNode.left == null && currentNode.right != null && visited.contains(currentNode.right)) {
                postOrderList.add(currentNode.val);
                visited.add(currentNode);
            } else if (currentNode.left != null && currentNode.right == null && visited.contains(currentNode.left)) {
                postOrderList.add(currentNode.val);
                visited.add(currentNode);
            } else {
    			stack.push(currentNode);
    			if (currentNode.right != null && !visited.contains(currentNode.right)) {
    				stack.push(currentNode.right);
    			}
    			if (currentNode.left != null && !visited.contains(currentNode.left)) {
    				stack.push(currentNode.left);
    			}
    		}                        
    	}

    	return postOrderList;
    }


}