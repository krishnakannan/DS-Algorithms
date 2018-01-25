class Solution {

    /* 
        This solution does not check for the circle everytime the 
        edge is added. Instead it builds the graph first then if a 
            Node has two parents it checks which 
                parent to remove. (either the last parent or the one which creates a circle)
            If Node doesnt have two parents then check which forms a circle and remove it.
    */

    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
    Map<Integer, List<Integer>> parentMap = new HashMap<>();
    List<Integer> parentsWithSameChild = new ArrayList<>();
    Integer childWithManyParents = 0;
    int[] edgeToBeDeleted;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        
        edgeToBeDeleted = new int[2];                        
        buildGraph(edges);
        if (parentsWithSameChild.size() > 1) {            
            for (Integer parent : parentsWithSameChild) {
                if (hasCircle(parent, parent)) {
                    edgeToBeDeleted[0] = parent;
                    edgeToBeDeleted[1] = childWithManyParents;
                    break;
                }  else {
                    edgeToBeDeleted[0] = parent;
                    edgeToBeDeleted[1] = childWithManyParents;
                }
            }    
        } else  {
            dfs(edges);
        }

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


    //This will be called at the max 2 times
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
                        edgeToBeDeleted[0] = currentNode;
                        edgeToBeDeleted[1] = destination;
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

    //Simple DFS for identifying loop
    public void dfs(int[][] edges) {
        boolean[] visited = new boolean[1001];
        for (int[] edge : edges) {
            if (visited[edge[0]] && visited[edge[1]]) {
                edgeToBeDeleted[0] = edge[0];
                edgeToBeDeleted[1] = edge[1];
                return;
            } else {
                visited[edge[0]] = true;
                visited[edge[1]] = true;
            }
        }
    }

    public void buildGraph(int[][] edges) { 
        for (int startPoint = 0; startPoint < edges.length; startPoint++) {
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