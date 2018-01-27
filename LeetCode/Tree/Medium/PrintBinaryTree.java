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
	
	class Node {
		int val;
		int col;	
		public Node(int val, int col) {
			this.val = val;
			this.col = col;
		}
	}

	//<Level, List of Nodes>
	Map<Integer, List<Node>> levelOrder = new HashMap<>();
	int maxLevel = 0;	
    int currentCol = 0;
    boolean lsTreeFlag = true;

    public List<List<String>> printTree(TreeNode root) {
        getDepth(root, 1);        
        traverse(root, maxLevel);        
        List<List<String>> printVal = new ArrayList<>();
        for (int i = 0; i < maxLevel; i++) {
            List<String> list = Arrays.asList(new String[(int)Math.pow(2, maxLevel) - 1]);
            Collections.fill(list, "");
            printVal.add(list);
        }
        
        for (Map.Entry<Integer, List<Node>> entry : levelOrder.entrySet()) {
        	int level = entry.getKey();
        	for (Node node : entry.getValue()) {
        		printVal.get(level).set(node.col - 1, Integer.toString(node.val));
        	}
        }        
        return printVal;
    }

    public void traverse(TreeNode root, int level) {
		if (root == null) {
			int index = (int)Math.pow(2, level) - 1;            
			currentCol += index;
			return;
		}

		traverse(root.left, level - 1);
		if (!levelOrder.containsKey(maxLevel - level)) {
			levelOrder.put(maxLevel - level, new ArrayList<>());
		}
        currentCol++;
		Node node = new Node(root.val, currentCol);
		levelOrder.get(maxLevel - level).add(node);                
		traverse(root.right, level - 1);

     }

     public void getDepth(TreeNode root, int level) {
     	if (root == null) {
     		return;
     	}

     	if (root.left == null && root.right == null) {
     		maxLevel = maxLevel < level ? level : maxLevel;
     	}
     	getDepth(root.left, level + 1);
     	getDepth(root.right, level + 1);
     }
}