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
    List<List<Integer>> mList = new ArrayList<List<Integer>>();
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        if (root != null) {
            queue.add(root);
        }
        
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            Queue<TreeNode> temp = new LinkedList<>();
            for (TreeNode x : queue) {
                tempList.add(x.val);
            }
            mList.add(tempList);
            
            
            for (TreeNode x : queue) {
               if (x.left != null) {
                    temp.add(x.left);    
                }
                if (x.right != null) {
                    temp.add(x.right);    
                }
            }
            queue.clear();
            queue.addAll(temp);
            
        }
        Collections.reverse(mList);
        return mList;
    }   
}