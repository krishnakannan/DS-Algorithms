class Solution {

    //This is N Square Algorithm. Read Disjoint Union Find

    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    Map<Integer, List<Integer>> parentMap = new HashMap<>();
    List<Integer> parentsWithSameChild = new ArrayList<>();
    Integer childWithManyParents = 0;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        int[] edgeToBeDeleted = new int[2];        
        int i = 0;
        for (; i < edges.length; i++) {
            int[] edge = edges[i];
            if (hasTwoParents(edge[0], edge[1])) {                
                edgeToBeDeleted[0] = edge[0];
                edgeToBeDeleted[1] = edge[1];
                childWithManyParents = edge[1];
                parentsWithSameChild = parentMap.get(edge[1]);
                break;
            }
            expandGraph(edge[0], edge[1]);
            if (hasCircle(edge[0], edge[0])) {                
                edgeToBeDeleted[0] = edge[0];
                edgeToBeDeleted[1] = edge[1];
                break;
            } 
        }
        buildGraph(edges, i);
        if (parentsWithSameChild.size() > 1) {            
            for (Integer parent : parentsWithSameChild) {
                if (hasCircle(parent, parent)) {
                    edgeToBeDeleted[0] = parent;
                    edgeToBeDeleted[1] = childWithManyParents;
                } 
            }    
        }

        //System.out.println(adjacencyList);
        return edgeToBeDeleted;
    }

    /*  
        If from the source we can reach destination before connecting 
        them with an edge then there is another way of reaching. 
        The current edge is to be returned.

        We also have to check whether a node has two parents 
        which is not possible in a tree

    */

    public boolean hasTwoParents(Integer parent, Integer child) {
        if (parentMap.containsKey(child)) {
            parentMap.get(child).add(parent);
            return true;
        } else {
            parentMap.put(child, new ArrayList<>());
            parentMap.get(child).add(parent);
            return false;
        }
    }


    public boolean hasCircle(Integer start, Integer destination) {
        boolean[] visited = new boolean[1001];
        visited[start] = true;
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            Integer currentNode = stack.pop();            
            List<Integer> neighbors = adjacencyList.get(currentNode);
            if (neighbors != null) {
                for (Integer neighbor : neighbors) {
                    if (neighbor.equals(destination)) {
                        return true;
                    }   
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack.push(neighbor);
                    }
                }              
            }           
        }
        return false;
    }

    public void expandGraph(Integer source, Integer destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).add(destination);
        } else {
            adjacencyList.put(source, new ArrayList<>());
            adjacencyList.get(source).add(destination);
        }
    }

    public void buildGraph(int[][] edges, int startPoint) { 
        for (; startPoint < edges.length; startPoint++) {
            int[] edge = edges[startPoint];
            int source = edge[0];
            int destination = edge[1];
            if (adjacencyList.containsKey(source)) {
                adjacencyList.get(source).add(destination);
            } else {
                adjacencyList.put(source, new ArrayList<>());
                adjacencyList.get(source).add(destination);
            }
            if (hasTwoParents(edge[0], edge[1])) {                                
                childWithManyParents = edge[1];
                parentsWithSameChild = parentMap.get(edge[1]);             
            }
        }        
    }
}