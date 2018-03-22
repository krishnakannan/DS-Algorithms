class Solution {

	Map<Integer, List<Integer>> aList;

	boolean visited[];
	boolean explored[];

    public boolean validTree(int n, int[][] edges) {

    	visited = new boolean[n];
    	explored = new boolean[n];
        aList = new HashMap<>();
    	for (int[] edge : edges) {
    		if (!aList.containsKey(edge[0])) {
    			aList.put(edge[0], new ArrayList<>());
    		}
    		if (!aList.containsKey(edge[1])) {
    			aList.put(edge[1], new ArrayList<>());
    		}

    		aList.get(edge[0]).add(edge[1]);
    		aList.get(edge[1]).add(edge[0]);
    	}      
        
        boolean isValidTree = dfs(0);
        
        for (int i = 0; i < explored.length; i++) {
            if (!explored[i]) {
                return false;
            }
        }
        
        return isValidTree;
    }



    public boolean dfs(int root) {

    	// if (explored[root]) {
    	// 		return false;
    	// }

    	boolean isValid = true;
    	List<Integer> neighbors = aList.get(root);
    	visited[root] = true;
        if (neighbors != null && !neighbors.isEmpty()) {
            for (Integer neighbor : neighbors) {
                if (explored[neighbor]) {
                    return false;
                }
                if (!visited[neighbor]) {
                    isValid &= dfs(neighbor);
                }    		
            }   
        }    	
    	visited[root] = false;

    	explored[root] = true;

    	return isValid;
    }
}