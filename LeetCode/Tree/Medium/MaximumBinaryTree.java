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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
    	if (start > end) {
    		return null;
    	}
    	int maxIndex = getMaxIndex(nums, start, end);
    	TreeNode node = new TreeNode(nums[maxIndex]);
    	node.left = buildTree(nums, start, maxIndex - 1);
    	node.right = buildTree(nums, maxIndex + 1, end);
    	return node;
    }

    public int getMaxIndex(int[] nums, int start, int end) {
    	int maxElement = Integer.MIN_VALUE;
    	int maxIndex = -1;
    	for (int i = start; i <= end; i++) {
    		if (nums[i] > maxElement) {
    			maxElement = nums[i];
    			maxIndex = i;
    		}
    	}
    	return maxIndex;
    }
}