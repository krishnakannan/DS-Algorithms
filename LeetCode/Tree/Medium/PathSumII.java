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
    List<List<Integer>> mList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        traverse(root, path, 0, sum);
        return mList;
    }
    
    public void traverse(TreeNode root, List<Integer> path, int cSum, int sum) {
        if (root == null) {
            return;
        } 
        if (root.left == null && root.right == null) {
            int temp = root.val + cSum;
            if (temp == sum) {
                path.add(root.val);
                mList.add(path);
            }
            return;
        }
        
        List<Integer> lPath = new ArrayList<>();
        List<Integer> rPath = new ArrayList<>();
        cSum += root.val;
        if (root.left != null) {
            lPath.addAll(path);
            lPath.add(root.val);
            traverse(root.left, lPath, cSum, sum);    
        }
        if (root.right != null) {
            rPath.addAll(path);
            rPath.add(root.val);
            traverse(root.right, rPath, cSum, sum);    
        }
        
        
    }
}