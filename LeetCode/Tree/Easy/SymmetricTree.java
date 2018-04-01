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
    List<Integer> iOne = new ArrayList<>();
    List<Integer> iTwo = new ArrayList<>();
    public boolean isSymmetric(TreeNode root) {
        preorder(root, true);
        flip(root);
        preorder(root, false);
        System.out.println(iOne);
        System.out.println(iTwo);
        //Compare Two List
        int length = iOne.size();
        for (int i = 0; i < length; i++) {
            if (iOne.get(i) != iTwo.get(i)) {
                return false;
            }
        }
        return true;
    }
    
    public void preorder (TreeNode root, boolean isFirstList) {
        if (root == null) {
            if (isFirstList) {
                iOne.add(-1);
            } else {
                iTwo.add(-1);
            }
            return;
        }
        if (isFirstList) {
            iOne.add(root.val);
        } else {
            iTwo.add(root.val);
        }
        preorder(root.left, isFirstList);
        
        preorder(root.right, isFirstList);
    }
    
    public void flip(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else {
            return;
        }
        
        flip(root.left);
        flip(root.right);
        
        return;
    }
}