class Solution {

	boolean[] visited;
	Set<Integer> set1;
	Set<Integer> set2;

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 0 || graph.length == 1) {
            return true;
        }
        
        visited = new boolean[graph.length];
        set1 = new HashSet<>();
        set2 = new HashSet<>();

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(graph, i, true);                    
            }            
        }
        
        
        for (Integer s1 : set1) {
            if (set2.contains(s1)) {
                return false;
            }
        }

        return true;
    }

    public void dfs(int[][] graph, int root, boolean isSet1) {        
        if (isSet1) {
    		set1.add(root);
    	} else {
    		set2.add(root);
    	}
        
        if (visited[root]) {
            return;
        }
            
    	visited[root] = true;    	

    	int[] neighbors = graph[root];    	

    	for (Integer neighbor : neighbors) {    		
            dfs(graph, neighbor, !isSet1);
    	}
    }
}