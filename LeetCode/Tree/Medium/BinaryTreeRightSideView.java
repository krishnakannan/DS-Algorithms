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
    Integer level = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightList = new ArrayList<>();
        rightView(root, 1, rightList);
        return rightList;
    }
    public void rightView(TreeNode root, int currentLevel, List<Integer> rightList) {
        if (root == null) {
            return;
        }        
        if (level < currentLevel){
            rightList.add(root.val);
            level = currentLevel;
        }
        
        if (root.right != null) {
            rightView(root.right, currentLevel + 1, rightList);
        }
        
        if (root.left != null) {
            rightView(root.left, currentLevel + 1, rightList);
        } 

        
    }
    
}