class Solution {

	boolean[] visited;
	boolean[] explored;
	boolean[] canReachSafeState;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        visited = new boolean[graph.length];
        explored = new boolean[graph.length];
        canReachSafeState = new boolean[graph.length];
        Arrays.fill(canReachSafeState, true);

        for (int i = 0; i < graph.length; i++) {
        	if (!explored[i]) {
        		dfs(graph, i, new ArrayList<>());
        	}
        }

        List<Integer> eventualSafeNodesList = new ArrayList<>();
        for (int i = 0; i < canReachSafeState.length; i++) {
        	if (canReachSafeState[i]) {
        		eventualSafeNodesList.add(i);
        	}        	
        }

        return eventualSafeNodesList;
    }

    public boolean dfs(int[][] graph, int currentNode,  List<Integer> routeTraversed) {        
        
        //System.out.println(routeTraversed);
        
    	//Leaf
    	if (graph[currentNode].length == 0) {
    		explored[currentNode] = true;
    		canReachSafeState[currentNode] = true;
    		return false;
    	}

    	if (visited[currentNode] && !explored[currentNode]) {
    		for (int traversed : routeTraversed) {
    			canReachSafeState[traversed] = false;
    		}
    		return true;
    	}

    	visited[currentNode] = true;

    	int[] neighbors = graph[currentNode];

    	for (int neighbor : neighbors) {
    		if (!explored[neighbor]) {
    			routeTraversed.add(currentNode);
    			boolean isCyclePresent = dfs(graph, neighbor, routeTraversed);
    			routeTraversed.remove(routeTraversed.size() - 1);
    			if (isCyclePresent) {
    				explored[currentNode] = true;
    				return true;
    			}
    		} else {
                if (!canReachSafeState[neighbor]) {
                    canReachSafeState[currentNode] = false;
                    for (int traversed : routeTraversed) {
                        canReachSafeState[traversed] = false;
                    }
                    return true;
                }        
            }
    	}

    	visited[currentNode] = false;
    	explored[currentNode] = true;
    	return false;
    }
}