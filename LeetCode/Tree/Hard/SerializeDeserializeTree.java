
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
     	Queue<TreeNode> queue = new LinkedList<>();
     	queue.add(root);
     	StringBuilder sBuilder = new StringBuilder();
     	while (!queue.isEmpty()) {
     		TreeNode currentNode = queue.poll();
            if (currentNode != null) {
                sBuilder.append(currentNode.val);
            } else {
                sBuilder.append(currentNode);
            }
     		sBuilder.append(",");
     		if (currentNode != null) {
     			queue.add(currentNode.left);
     			queue.add(currentNode.right);
     		}
     	}
     	sBuilder.setLength(sBuilder.length() - 1);
     	//System.out.println(sBuilder.toString());
     	return sBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	TreeNode root = null;
    	if (data.isEmpty()) {
    		return root;
    	}
        int index = 0;
    	String[] array = data.split(",");
    	Queue<TreeNode> queue = new LinkedList<>();
    	if (!array[index].equals("null")) { 
    		queue.add(new TreeNode(Integer.parseInt(array[index])));
    	}
    	
    	while (!queue.isEmpty()) { 
    		TreeNode currentNode = queue.poll();    		
    		if (index == 0) {
    			root = currentNode;
    		}
    		TreeNode leftChild = null;
    		TreeNode rightChild = null;
    		if (currentNode != null) {
    			if (!array[index + 1].equals("null")) {
    			 	leftChild = new TreeNode(Integer.parseInt(array[index + 1]));
    			}
    			if (!array[index + 2].equals("null")) {
    			 	rightChild = new TreeNode(Integer.parseInt(array[index + 2]));
    			}    			
    			currentNode.left = leftChild;
    			currentNode.right = rightChild;
    			if (leftChild != null) {
    				queue.add(leftChild);
    			}
    			if (rightChild != null) {
    				queue.add(rightChild);
    			}
    		}    		
    		index += 2;
    	}
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));