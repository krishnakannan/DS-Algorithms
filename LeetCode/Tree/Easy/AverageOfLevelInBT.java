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
    TreeMap<Integer, List<Integer>> levelOrder;
    public List<Double> averageOfLevels(TreeNode root) {
        levelOrder = new TreeMap<>();
        parseTree(root, 1);
        List<Double> result = new ArrayList<>();
        for (List<Integer> currentLevel : levelOrder.values()) {
            double val = 0d;            
            for (Integer current : currentLevel) {
                val += current;
            }
            result.add(val / (double)currentLevel.size());
        }
        return result;
    }
    
    public void parseTree(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (!levelOrder.containsKey(level)) {
                levelOrder.put(level, new ArrayList<>());                
            }
            levelOrder.get(level).add(root.val);
            return;
        }
        
        if (!levelOrder.containsKey(level)) {
            levelOrder.put(level, new ArrayList<>());                
        }
        levelOrder.get(level).add(root.val);
        parseTree(root.left, level + 1);
        parseTree(root.right, level + 1);
    }
}