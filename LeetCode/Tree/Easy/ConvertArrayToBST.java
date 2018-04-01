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
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        TreeNode root = BST(nums, 0, length -1);
        return root;
    }
    
    public TreeNode BST(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        if (end < start) {
            return null;
        }
        TreeNode root = new TreeNode(nums[middle]);
        
        root.left = BST(nums, start, middle-1);
        root.right = BST(nums, middle+1, end);
        return root;
    }
}