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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        stack.push(root); 
        list.add(root.val);
        while (!stack.empty()) {
            //System.out.println(list);
            if (stack.peek().left == null && stack.peek().right == null) {
                stack.pop();
                if (!stack.empty()) {
                    TreeNode x = stack.pop();
                    if (!stack.empty()) {
                        stack.peek().left = null;
                    }
                    if (x.right != null) {
                        list.add(x.right.val);
                        stack.push(x.right);   
                    }
                }
            } else if (stack.peek().left != null) {
                TreeNode x = stack.peek().left;
                list.add(x.val);
                stack.push(x);
            } else if (stack.peek().left == null && stack.peek().right != null) {
                TreeNode x = stack.pop().right;
                list.add(x.val);
                stack.push(x);
            }
        }
        
        return list;
    }
}