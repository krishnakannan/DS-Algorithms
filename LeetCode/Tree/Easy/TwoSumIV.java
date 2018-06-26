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
    List<Integer> tree;
    public boolean findTarget(TreeNode root, int k) {
        tree = new ArrayList<>();
        inorder(root);        
        int left = 0; 
        int right = tree.size() - 1;
        while (left < right) {
            int num = tree.get(left) + tree.get(right);
            if (num > k) {
                right -= 1;
            } else if (num < k) {
                left += 1;
            } else {
                return true;
            }
        }
        return false;
    }
    
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            tree.add(root.val);
            return;
        }
        inorder(root.left);
        tree.add(root.val);
        inorder(root.right);
    }
}