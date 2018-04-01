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
    List<String> paths;
    public List<String> binaryTreePaths(TreeNode root) {
     paths = new ArrayList<>();    
     StringBuilder sb = new StringBuilder();
     if (root != null) {
        traverse(root, sb);    
     }
     
     return paths;
    }
    
    public void traverse(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            paths.add(sb.toString());
            return;
        }
        StringBuilder lPath = new StringBuilder(sb);
        StringBuilder rPath = new StringBuilder(sb);
        lPath.append(root.val + "->");
        rPath.append(root.val + "->");
        if (root.left != null) {
            traverse(root.left, lPath);
        }
        
        if (root.right != null) {
            traverse(root.right, rPath);
        }
        
        return;
    }
}