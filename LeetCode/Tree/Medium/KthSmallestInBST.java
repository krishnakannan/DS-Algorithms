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
    boolean found = false;
    public int kth = 0;
    public int val = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return root.val;
        }
        
        traverse(root, k);
        return val;
    }
    
    public void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            kth++;
            if (kth == k) {
                val = root.val;
                found = true;
            }
            return;
        }
        
        if (!found) {
            traverse(root.left, k);
        }
        kth++;
        if (kth == k) {
            val = root.val;
            found = true;
        }
        if (!found) {
            traverse(root.right, k);
        }
    }
}