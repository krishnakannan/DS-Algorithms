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

	int index = 0;

    public TreeNode str2tree(String s) {
    	Stack<TreeNode> nodeStack = new Stack<>();
    	Stack<Character> bracketStack = new Stack<>();

    	char[] arr = s.toCharArray();

 		while (index < arr.length) {
 			if (arr[index] == '(') {
 				bracketStack.push('(');
 			} else if (arr[index] == ')') {
 				if (!bracketStack.empty()){
 					bracketStack.pop();
 				}
 				if (!nodeStack.empty()) {
 					TreeNode popped = nodeStack.pop();	
 					if (!nodeStack.empty() && nodeStack.peek().left == null) {
 						nodeStack.peek().left = popped;
 					} else if (!nodeStack.empty()) {
 						nodeStack.peek().right = popped;
 					}
 				} 				
 			} else {
 				int val = getValue(arr);
 				TreeNode node = new TreeNode(val);
 				nodeStack.push(node);
 			}
 			index++;
 		}
 		return nodeStack.empty() ? null : nodeStack.peek(); 		
    }

    public int getValue(char[] arr) {
    	StringBuilder sBuilder = new StringBuilder();
    	while ((index < arr.length && arr[index] >= '0' && arr[index] <= '9') || (index < arr.length && arr[index] == '-')) {
    		sBuilder.append(arr[index]);
    		index++;
    	}
    	index--;
    	return Integer.parseInt(sBuilder.toString());
    }


}