class Solution {
	int[] result;
	boolean[] visited;
	Map<Integer, List<Integer>> graph;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
    	result = new int[quiet.length];
    	visited = new boolean[quiet.length];
    	graph = new HashMap<>();

    	for (int i = 0; i < richer.length; i++) {
    		if (!graph.containsKey(richer[i][1])) {
    			graph.put(richer[i][1], new ArrayList<>());
    		} 
    		graph.get(richer[i][1]).add(richer[i][0]);
    	}
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(i, quiet);
            }
        }
        return result;
    }

    public int dfs(int current, int[] quiet) {
        //System.out.println(Arrays.toString(result));
    	if (visited[current]) {
    		return result[current];
    	}

    	if (!graph.containsKey(current)) {
    		visited[current] = true;
    		result[current] = current;
    		return result[current];
    	}

    	if (graph.get(current).size() == 1 && graph.get(current).get(0) == current) {
    		visited[current] = true;
    		result[current] = current;	
    		return result[current];
    	} 

    	visited[current] = true;
    	int minIndex = current;    	
    	List<Integer> neighbors = graph.get(current);
        //System.out.println("Current " + current + " Neighbors " + neighbors);
    	for (Integer neighbor : neighbors) {
    		int quietIndex = dfs(neighbor, quiet);
    		if (quiet[quietIndex] < quiet[minIndex]) {
    			minIndex = quietIndex;
    		}
    	}
    	result[current] = minIndex;        
    	return result[current];
    }
}