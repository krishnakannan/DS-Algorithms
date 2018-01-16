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
    int currentDepth = Integer.MAX_VALUE;
    int minDepth = Integer.MAX_VALUE;
    int minLeaf = 0;
    int closestLeaf = 0;
    
    boolean hasFound = false;
    List<TreeNode> path = new ArrayList<>();

    public int findClosestLeaf(TreeNode root, int k) {
        List<TreeNode> currentPath = new ArrayList<>();
        currentPath.add(root);
        tracePath(root, k, currentPath);
        int distanceToTarget = path.size() - 1;
        for (TreeNode node : path) {
            currentDepth = Integer.MAX_VALUE;
            traverse(node, 0);
            currentDepth += distanceToTarget;            
            if (currentDepth < minDepth) {
                minDepth = currentDepth;    
                minLeaf = closestLeaf;                
            } 
            distanceToTarget--;
        }

        return minLeaf;
    }


    public void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (depth < currentDepth) {
                currentDepth = depth;
                closestLeaf = root.val;                
            }
            return;
        }

        traverse(root.left, depth + 1);
        traverse(root.right, depth + 1);
    }


    public void tracePath(TreeNode root, int k, List<TreeNode> currentPath) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {            
            if (root.val == k) {
                path.addAll(currentPath);               
                hasFound = true;
            }
            return;
        }
        
        if (root.val == k) {
            path.addAll(currentPath);                    
            hasFound = true;
            return;
        }        
        
        if (!hasFound) {
            if (root.left != null) {
                currentPath.add(root.left);        
                tracePath(root.left, k, currentPath);    
                currentPath.remove(currentPath.size() - 1);    
            } 

            if (root.right != null) {
                currentPath.add(root.right);             
                tracePath(root.right, k, currentPath);    
                currentPath.remove(currentPath.size() - 1);
            }                       
        }        
    }

}