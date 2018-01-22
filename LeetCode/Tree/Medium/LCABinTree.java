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
    boolean hasFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        List<TreeNode> pPath = new ArrayList<>();
        pPath.add(root);
        List<TreeNode> qPath = new ArrayList<>();
        qPath.add(root);

        pPath = tracePath(root, p, pPath);
        hasFound = false;
        qPath = tracePath(root, q, qPath);

        int pIndex = 0;
        int qIndex = 0;
        int pSize = pPath.size() - 1;
        int qSize = qPath.size() - 1;
        TreeNode lca = root;

        while (pIndex <= pSize && qIndex <= qSize) {
            if (pPath.get(pIndex).equals(qPath.get(qIndex))) {
                lca = pPath.get(pIndex);
                pIndex++;
                qIndex++;
            } else {
                break;
            }
        }
        
        return lca;

    }

    public List<TreeNode> tracePath(TreeNode source, TreeNode destination, List<TreeNode> currentPath) {
        
        if (source == null) {
            return currentPath;
        }        
        
        if (source.equals(destination)) {            
            hasFound = true;
            return currentPath;
        }
        
        
        if (source.left == null && source.right == null) {
            return currentPath;
        }

        if (!hasFound) {
            currentPath.add(source.left);
            tracePath(source.left, destination, currentPath);   
            if (!hasFound) {
                currentPath.remove(currentPath.size() - 1);    
            }
        }
        if (!hasFound) {
            currentPath.add(source.right);
            tracePath(source.right, destination, currentPath);  
            if (!hasFound) {
                currentPath.remove(currentPath.size() - 1);    
            }           
        }

        return currentPath;
    }
}