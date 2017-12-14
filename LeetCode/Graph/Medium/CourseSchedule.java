class Solution {



	Map<Integer, List<Integer>> graph = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        createGraph(prerequisites);
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, List<Integer>> node : graph.entrySet()) {
        	boolean hasCycle = detectCycle(node.getKey(), new HashSet<>(), visited);
            //System.out.println("Node " + node.getKey() + " hasCycle " + hasCycle);
        	if (hasCycle) {
        		//Impossible to complete
        		return false;
        	} else {
        		visited.add(node.getKey());
        	}
        }
        
        return true;
    }

    //Perform DFS
    //Explored is to maintain local traversal and Visited is to maintain global traversal
    public boolean detectCycle(Integer currentCourse, Set<Integer> explored, Set<Integer> visited) {
    	
    	if (visited.contains(currentCourse)) {
    		return false;
    	}

    	if (explored.contains(currentCourse)) {
    		return true;
    	}
    	explored.add(currentCourse);
    	List<Integer> neighbors = graph.get(currentCourse);
        boolean detectedCycle = false;
    	if (neighbors != null && !neighbors.isEmpty()) {
    		for (Integer neighbor : neighbors) {    
                //System.out.println(neighbor + " is currently being processed");
	    		detectedCycle = detectedCycle || detectCycle(neighbor, explored, visited);
	    	}	
    	}
        explored.remove(currentCourse);
    	return detectedCycle;
    }


	/*
		Modelling graph as a Adjacency List
		Course -> List of Prerequisites (Neighbors)

	*/
     public void createGraph(int[][] prerequisites) {
    	for (int i = 0; i < prerequisites.length; i++) {
    		if (graph.containsKey(prerequisites[i][0])) {
    			graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    		} else {
    			graph.put(prerequisites[i][0], new ArrayList<>());	
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
    		}    		
    	}
    	//System.out.println(graph);
    }


}