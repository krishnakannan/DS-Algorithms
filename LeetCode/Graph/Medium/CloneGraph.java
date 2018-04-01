/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }
        
        //Perform BFS.
        
        UndirectedGraphNode src = null;
        
        //init DS
        Queue<UndirectedGraphNode> neighbors = new LinkedList<>();
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        Set<UndirectedGraphNode> processedNodes = new HashSet<>();
        
        neighbors.add(node);
        
        while (!neighbors.isEmpty()) {
            UndirectedGraphNode currentNode = neighbors.poll();            
            UndirectedGraphNode newNode = new UndirectedGraphNode(currentNode.label);
            map.put(newNode.label, newNode);
            processedNodes.add(currentNode);
            if (src == null) {
                src = newNode;
            }
            for (UndirectedGraphNode nNode : currentNode.neighbors) {
                if (!processedNodes.contains(nNode)) {
                    neighbors.add(nNode);    
                }                
            }
        }
        
        neighbors.add(node);
        processedNodes.clear();
        
        while (!neighbors.isEmpty()) {            
            UndirectedGraphNode currentNode = neighbors.poll();                        
            processedNodes.add(currentNode);
            for (UndirectedGraphNode oldNeighbor : currentNode.neighbors) {                                
                map.get(currentNode.label).neighbors.add(map.get(oldNeighbor.label));                
                if (!processedNodes.contains(oldNeighbor)) {                    
                    neighbors.add(oldNeighbor);    
                    processedNodes.add(oldNeighbor);
                } 
            }
        }
        return src;
    }
}