class Solution {

	//This is N Square Algorithm. Read Disjoint Union Find

    Map<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public int[] findRedundantConnection(int[][] edges) {
        
        int[] edgeToBeDeleted = new int[2];
        for (int[] edge : edges) {
            if (!hasCircle(edge[0], edge[1])) {
                expandGraph(edge[0], edge[1]);
            } else {
                edgeToBeDeleted[0] = edge[0];
                edgeToBeDeleted[1] = edge[1];
                break;
            }
        }
        return edgeToBeDeleted;
    }

    /*  
        If from the source we can reach destination before connecting 
        them with an edge then there is another way of reaching. 
        The current edge is to be returned.
    */
    public boolean hasCircle(Integer start, Integer destination) {
        boolean[] visited = new boolean[1001];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();            
            List<Integer> neighbors = adjacencyList.get(currentNode);
            if (neighbors != null) {
                for (Integer neighbor : neighbors) {
                    if (neighbor.equals(destination)) {
                        return true;
                    }   
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
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

        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).add(source);
        } else {
            adjacencyList.put(destination, new ArrayList<>());
            adjacencyList.get(destination).add(source);
        }
    }
}