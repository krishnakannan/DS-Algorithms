class Solution {

	List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	dfs(graph, 0, graph.length - 1, new ArrayList<>());
        return paths;
    }


    public void dfs(int[][] graph, int currentNode, int destination, List<Integer> currentPath) {
    	
    	if (currentNode == destination) {
    		currentPath.add(currentNode);
    		paths.add(new ArrayList(currentPath));
			currentPath.remove(currentPath.size() - 1);
    		return;
    	}	


    	int[] neighbors = graph[currentNode];
    	currentPath.add(currentNode);

    	//Its a DAG so we do not need to check for visited
    	for (Integer neighbor : neighbors) {
    		dfs(graph, neighbor, destination, currentPath);
    	}

    	currentPath.remove(currentPath.size() - 1);
    }
}