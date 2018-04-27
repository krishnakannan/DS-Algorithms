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
    List<Double> nodes;
    
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        nodes = new ArrayList<>();    
        List<Integer> kNearest = new ArrayList<>();        
        traverse(root);        
        int treeSize = nodes.size();
        int minIndex = -1;
        double minDiff = Double.MAX_VALUE;
        for (int i = 0; i < treeSize; i++) {            
            double diff = diff(nodes.get(i), target);
            if (minDiff > diff) {
                minDiff = diff;
                minIndex = i;
            }
        }
        
        int left = minIndex;
        int right = minIndex;
        
        while (--k >= 0 && left >= 0 && right < treeSize) {
            kNearest.add(nodes.get(minIndex).intValue());
            if (left == minIndex && right == minIndex) {
                left--;
                right++;                                
            } else if (left == minIndex) {
                left--;
            } else if (right == minIndex) {
                right++;
            }
            if (left >= 0 && right < treeSize) {
                double rDiff = diff(nodes.get(right), target);
                double lDiff = diff(nodes.get(left), target);
                minIndex = rDiff < lDiff ? right : left;    
            } else {
                break;
            }            
        }                
        
        if (left < 0 && k > 0) {
            while (--k >= 0) {
                kNearest.add(nodes.get(right).intValue());
                right++;
            }
        }
        
        if (right >= treeSize && k > 0) {
            while (--k >= 0) {
                kNearest.add(nodes.get(left).intValue());
                left--;
            }
        }        
        return kNearest;
    }
    
    public void traverse(TreeNode root) {
        if (root == null) {
            return;            
        }        
        if (root.left == null && root.right == null) {
            nodes.add((double)root.val);
            return;
        }    
        traverse(root.left);
        nodes.add((double)root.val);
        traverse(root.right);
    }
    
    public double diff(double a, double b) {
        return a > b ? a - b : b - a;
    }
    
}