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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largest = new ArrayList<>();
        if (root == null) {
            return largest;
        }
        Queue<TreeNode> iQue = new LinkedList<>();
        Queue<TreeNode> tQue = new LinkedList<>();
        iQue.add(root);
        int max = root.val;
        while (!iQue.isEmpty()) {
            TreeNode temp = iQue.poll();
            if (temp.left != null) {
                tQue.add(temp.left);    
            }
            if (temp.right != null) {
                tQue.add(temp.right);    
            }
            if (iQue.isEmpty()) {
                largest.add(getMax(max, temp.val));
                max = Integer.MIN_VALUE;
                iQue.addAll(tQue);
                tQue.clear();
            } else {
                max = getMax(max, temp.val);
            }
        }
        return largest;
    }
    
    public int getMax (int a, int b) {
        return a > b ? a : b; 
    }
}