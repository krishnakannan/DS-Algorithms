//To Find topological ordering and make sure that circle is not present in DG

class Solution {

	boolean[] visited;
	boolean[] explored;
	Stack<Integer> tStack;
	Map<Integer, List<Integer>> graph;


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        explored = new boolean[numCourses];
        tStack = new Stack<>();
        graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
        	if (!graph.containsKey(prerequisite[1])) {
        		graph.put(prerequisite[1], new ArrayList<>());
        	}
        	graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        //System.out.println(graph);
        
        for (int i = 0; i < explored.length; i++) {
        	if (!explored[i]) {
        		boolean isTopoPresent = dfs(i);                
        		if (!isTopoPresent) {
        			return new int[]{};
        		}
        	}
        }
        int[] topoOrdering = new int[numCourses];
        int tIndex = 0;

        while (!tStack.empty()) {
        	topoOrdering[tIndex] = tStack.pop();
        	tIndex++;
        }
        return topoOrdering;
    }

    public boolean dfs(int currentCourse) {                
    	// A leaf
    	if (!graph.containsKey(currentCourse) && !explored[currentCourse]) {           
    		explored[currentCourse] = true;
    		tStack.push(currentCourse);
    		return true;
    	}
        
    	if (explored[currentCourse]) {
    		return true;
    	}    	

    	boolean isTopoPresent = false;
    	List<Integer> nextCourses = graph.get(currentCourse);

    	for (Integer nextCourse : nextCourses) {                        
            if (visited[nextCourse] && !explored[nextCourse]) {            
                return false;
            }
    		if (!visited[nextCourse]) {
    			visited[nextCourse] = true;
	    		isTopoPresent = dfs(nextCourse);
                if (!isTopoPresent) {
                    return false;
                }
	    		visited[nextCourse] = false;
    		}    		
    	}
    	explored[currentCourse] = true;
    	tStack.push(currentCourse);
    	return isTopoPresent;
    }
}