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
    
    List<Long> firstList = new ArrayList<>();
    List<Long> secondList = new ArrayList<>();
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        inOrderTrav(s, true);
        inOrderTrav(t, false);
        System.out.println(firstList);
        System.out.println(secondList);
        return firstList.size() > secondList.size() ? Collections.indexOfSubList(firstList, secondList) != -1 : Collections.indexOfSubList(secondList, firstList) != -1;
    }
    
    public void inOrderTrav(TreeNode root, boolean isFirst) {
        if (root == null) {
            if (isFirst) {
                firstList.add(Long.MIN_VALUE);
            } else {
                secondList.add(Long.MIN_VALUE);
            }
            return;
        }
        // if (root.left == null && root.right == null) {
        //     if (isFirst) {
        //         firstList.add(root.val);
        //     } else {
        //         secondList.add(root.val);
        //     }
        //     return;
        // }
        if (isFirst) {
            firstList.add((long)root.val);
        } else {
            secondList.add((long)root.val);
        }
        
        inOrderTrav(root.left, isFirst);    
        inOrderTrav(root.right, isFirst);
            
    }
}