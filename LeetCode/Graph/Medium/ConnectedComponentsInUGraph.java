class Solution {

	Set<Integer> visited = new HashSet<>();
	Map<Integer, List<Integer>> map = new HashMap<>();
    public int countComponents(int n, int[][] edges) {

    	int components = 0;

        // Create Adjacency List 
        for (int[] edge : edges) {
        	if (!map.containsKey(edge[0])) {
        		map.put(edge[0], new ArrayList<>());
        	}

        	if (!map.containsKey(edge[1])) {
        		map.put(edge[1], new ArrayList<>());
        	}
        	map.get(edge[0]).add(edge[1]);
        	map.get(edge[1]).add(edge[0]);
        }
        
        for (int i = 0; i < n; i++) {            
        	if (!visited.contains(i)) {                
        		components++;
        		bfs(i);
        	}
            
        }

        return components;
    }


    public void bfs(int n) {
    	Queue<Integer> bfsQ = new LinkedList<>();
    	bfsQ.add(n);
    	visited.add(n);
    	while (!bfsQ.isEmpty()) {
    		List<Integer> neighbors = map.get(bfsQ.poll());
            if (neighbors != null) {
                for (Integer neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        bfsQ.add(neighbor);
                        visited.add(neighbor);
                    }
                }   
            }    		
    	}
    }
}