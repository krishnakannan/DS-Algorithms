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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.empty()) {
            // System.out.println(list);
            if (stack.peek().left == null && stack.peek().right == null) {
                TreeNode x = stack.pop();
                list.add(x.val);
                if (!stack.empty()) {
                    stack.peek().left = null;
                }
            } else if (stack.peek().left == null && stack.peek().right != null) {
                TreeNode x = stack.pop();
                list.add(x.val);
                if (x.right != null) {
                    stack.push(x.right);    
                }
            } else {
                stack.push(stack.peek().left);
            }
        }
        return list;
    }
}