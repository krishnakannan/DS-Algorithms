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


	int maxWidth = 1;
	boolean hasElements = true;
	List<Integer> positions = new ArrayList<>();
	Queue<TreeNode> lvlQueue = new LinkedList<>();
    public int widthOfBinaryTree(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	
    	positions.add(1);
    	lvlQueue.add(root);    	
    	int index = -1;
    	while (!lvlQueue.isEmpty()) {
    		TreeNode polled = lvlQueue.poll();
    		index++;
    		if (polled.left != null) {
    			positions.add(positions.get(index) * 2);
    			lvlQueue.add(polled.left);
    		}
    		if (polled.right != null) {
    			positions.add((positions.get(index) * 2) + 1);
    			lvlQueue.add(polled.right);
    		}
    	}
    	//System.out.println(positions);
        processPositions(positions);
        return maxWidth;
    }    

    public void processPositions(List<Integer> positions) {
    	int currentLimit = 1;
    	int currentLevel = 1;
    	int currentStart = 1;
    	int currentWidth = 0;

    	for (Integer val : positions) {
    		if (val <= currentLimit) {
    			currentWidth = val - currentStart + 1;			
    		} else {
    			currentLevel++;
    			currentLimit = (int)Math.pow(2, currentLevel) - 1;
    			currentStart = val;                
    		}
    		maxWidth = maxWidth < currentWidth ? currentWidth : maxWidth;
    	}     
    }
}