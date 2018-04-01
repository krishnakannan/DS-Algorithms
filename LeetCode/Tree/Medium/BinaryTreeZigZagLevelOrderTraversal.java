/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	    List<List<Integer>> list = new ArrayList<>();
    	    if (root == null) {
    	        return list;
    	    }
        Queue<TreeNode> pQ = new LinkedList<>();
        Queue<TreeNode> sQ = new LinkedList<>();
        boolean isRev = false;
        
        List<Integer> sublist = null;
        pQ.add(root);
        while (!pQ.isEmpty()) {
    		Queue<TreeNode> temp = new LinkedList<>();
    		sublist = new ArrayList<>();
    		temp.addAll(pQ);
    		while (!temp.isEmpty()) {
    			TreeNode tempNode = temp.poll();
    			if (tempNode.left != null) {
    				sQ.add(tempNode.left);	
    			}
    			if (tempNode.right != null) {
    				sQ.add(tempNode.right);	
    			}
    		}    		
    		if (isRev) {
    			sublist = getReverseList(pQ);
    			isRev = false;
    		} else {
    			sublist = getList(pQ);
    			isRev = true;
    		}
    		list.add(sublist);
    		pQ.clear();
    		pQ.addAll(sQ);
    		sQ.clear();
        }
        return list;
    }
    
    public List<Integer> getList(Queue<TreeNode> queue) {
    	Queue<TreeNode> tempQueue = new LinkedList<>();
    	tempQueue.addAll(queue);
        List<Integer> list = new ArrayList<>();
        while(!tempQueue.isEmpty()) {
        	list.add(tempQueue.poll().val);
        }
        return list;
    }
    
    public List<Integer> getReverseList(Queue<TreeNode> queue) {
    	Queue<TreeNode> tempQueue = new LinkedList<>();
    	tempQueue.addAll(queue);
    	List<Integer> list = new ArrayList<>();
    	Stack<Integer> stack = new Stack<>();
        while(!tempQueue.isEmpty()) {
        	stack.push(tempQueue.poll().val);
        }
        while (!stack.empty()) {
        	list.add(stack.pop());
        }
        return list;   
    }
}