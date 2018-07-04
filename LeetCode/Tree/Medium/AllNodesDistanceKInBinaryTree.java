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
    Map<Integer, List<Integer>> fwdPath = new HashMap<>();
    Map<Integer, List<Integer>> revPath = new HashMap<>();
    List<Integer> nodesAtK;
    boolean[] visited = new boolean[501];
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        nodesAtK = new ArrayList<>();
        traverse(null, root);
//         System.out.println(fwdPath);
//         System.out.println(revPath);
        dfs(target.val, 0, K);
        return nodesAtK;
    }
    
    public void dfs(int current, int distance, int K) { 
        if (distance > K) {
            return;
        }
        
        if (visited[current]) {
            return;
        }
        
        if (distance == K) {
            nodesAtK.add(current);
            return;
        }
        visited[current] = true;
        List<Integer> fwdNeighbors = fwdPath.get(current);
        List<Integer> revNeighbors = revPath.get(current);
        for (int i = 0; i < fwdNeighbors.size(); i++) {
            dfs(fwdNeighbors.get(i), distance + 1, K);
        }
        for (int i = 0; i < revNeighbors.size(); i++) {
            dfs(revNeighbors.get(i), distance + 1, K);
        }
    }
       
    public void traverse(TreeNode parent, TreeNode current) {
        if (current == null) {
            return;
        }
        
        if (current.left == null && current.right == null) {
            if (!fwdPath.containsKey(current.val)) {
                fwdPath.put(current.val, new ArrayList<>());
            }
            if (!revPath.containsKey(current.val)) {
                revPath.put(current.val, new ArrayList<>());                
            }
            if (parent != null) {
                revPath.get(current.val).add(parent.val);    
            }
            
            return;
        }
        
        traverse(current, current.left);
        if (!fwdPath.containsKey(current.val)) {
            fwdPath.put(current.val, new ArrayList<>());
        }
        if (current.left != null) {
            fwdPath.get(current.val).add(current.left.val);    
        }
        if (current.right != null) {
            fwdPath.get(current.val).add(current.right.val);    
        }
        
        if (!revPath.containsKey(current.val)) {
            revPath.put(current.val, new ArrayList<>());                
        }
        if (parent != null) {
            revPath.get(current.val).add(parent.val);    
        }
        traverse(current, current.right);
    }
}