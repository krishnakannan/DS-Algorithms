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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> mList = new ArrayList<>();
        if (root == null) {
            return mList;
        }
        queue.add(root);
        queue.add(null);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                if (queue.peek() == null) {
                    list.add(temp.val);
                    mList.add(list);
                    list = new ArrayList<>();
                    queue.poll();
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                    queue.add(null);
                } else {
                    list.add(temp.val);
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }
        
        return mList;
    }
}