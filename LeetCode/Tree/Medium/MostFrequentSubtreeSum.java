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
    Map<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        int maxVal = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxVal) {
                maxVal = entry.getValue();
                count = 1;
            } else if (entry.getValue() == maxVal) {
                count++;    
            }
            
        }
        
        int[] arr = new int[count];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVal) {
                arr[index] = entry.getKey();
                index++;
            }
        }
        //System.out.println(map);
        return arr;
    }
    
    public int sum (TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            map.put(root.val, map.containsKey(root.val) ? map.get(root.val) + 1 : 1);
            return root.val;
        }
        
        int totalSum = sum(root.left) + sum(root.right) + root.val;
        map.put(totalSum, map.containsKey(totalSum) ? map.get(totalSum) + 1 : 1);
        return totalSum;
    }
}